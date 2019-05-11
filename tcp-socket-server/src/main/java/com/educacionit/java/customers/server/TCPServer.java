
package com.educacionit.java.customers.server;


import java.net.*;
import java.io.*;
import java.util.Properties;

import org.apache.log4j.Logger;


public class TCPServer {


    private ServerSocket serverSocket;

    private static DBConnectionManager dbConnectionManager;

    private static final Logger log = Logger.getLogger (TCPServer.class);


    static {

        try {

            Properties pop = new Properties ();
            pop.load (TCPServer.class.getClassLoader().getResourceAsStream("jdbc.properties"));

            dbConnectionManager = new DBConnectionManager (pop.getProperty("jdbc.url"),
                    pop.getProperty("jdbc.user"),
                    pop.getProperty("jdbc.password"),
                    pop.getProperty("jdbc.driver"));

        } catch (Exception e) {

            log.error ("Fail connecting to database..", e);
            throw new DataException (e);
        }
    }


    public TCPServer () {

        super ();
    }


    public void start (int port) {

        try {

            serverSocket = new ServerSocket (port);

            while (true) {

                log.info ("Waiting new message..");
                new ServerHandler (serverSocket.accept()).start();
            }


        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            stop ();
        }

    }

    public void stop () {

        try {

            serverSocket.close ();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }



    private static class ServerHandler extends Thread {

        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;


        public ServerHandler (Socket socket) {

            this.clientSocket = socket;
        }


        public void run () {

            try {

                out = new PrintWriter (clientSocket.getOutputStream (), true);
                in = new BufferedReader (new InputStreamReader (clientSocket.getInputStream ()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {

                    log.debug (String.format ("Message received %s from %s",
                            inputLine, clientSocket.getInetAddress().getHostName ()));

                    if (".".equals(inputLine)) {
                        out.println("bye");
                        break;
                    }

                    out.println(inputLine.toUpperCase());
                }

                in.close ();
                out.close ();
                clientSocket.close ();

            } catch (Exception e) {

                log.debug (e.getMessage ());
            }
        }
    }



    public static void main (String[] args) {

        TCPServer server = new TCPServer ();
        server.start (5555);


        
    }
}