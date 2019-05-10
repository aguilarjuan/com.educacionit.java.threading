
package com.educacionit.java.customers.server;


import java.net.*;
import java.io.*;

import org.apache.log4j.Logger;


public class TCPServer {


    private ServerSocket serverSocket;


    private static final Logger LOG = Logger.getLogger (TCPServer.class);


    public TCPServer () {

        super ();
    }


    public void start (int port) {

        try {

            serverSocket = new ServerSocket (port);

            while (true) {

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

                    if (".".equals(inputLine)) {
                        out.println("bye");
                        break;
                    }
                    out.println(inputLine);
                }

                in.close ();
                out.close ();
                clientSocket.close ();

            } catch (IOException e) {

                LOG.debug (e.getMessage ());
            }
        }
    }



    public static void main (String[] args) {

        TCPServer server = new TCPServer ();
        server.start (5555);
    }
}