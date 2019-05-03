
package com.educacionit.java.threading.intermediate;


public class DaemonThread extends Thread {


    public DaemonThread () {

        setDaemon (true);
    }


    public void run () {

        while (true) {

            try {

                System.out.println ("Is this thread Daemon? - " + isDaemon ());
                Thread.sleep (5000);

            } catch (Exception ex) { ex.printStackTrace(); }
        }
    }


    public static void main (String a[]) {

        DaemonThread dt = new DaemonThread ();

        dt.start ();
    }
}