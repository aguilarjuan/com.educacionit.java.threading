
package com.educacionit.java.threading.intermediate;


public class NonDaemonThread extends Thread {


    public NonDaemonThread() {

        setDaemon (false);
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

        NonDaemonThread dt = new NonDaemonThread();

        dt.start ();
    }
}