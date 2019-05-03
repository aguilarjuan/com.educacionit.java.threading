
package com.educacionit.java.threading.intermediate;


public class StartupThreadNonJoin2 {


    public static void main(String[] args) {

        Thread th1 = new Thread (new JoinThread (), "Thread 1");
        Thread th2 = new Thread (new JoinThread (), "Thread 2");
        Thread th3 = new Thread (new JoinThread (), "Thread 3");

        th1.start ();
        th2.start ();
        th3.start ();
    }
}


class JoinThread implements Runnable {


    @Override
    public void run () {

        Thread t = Thread.currentThread ();
        System.out.println ("Thread started: " + t.getName ());

        try {

            Thread.sleep (4000);

        } catch (InterruptedException ex) { ex.printStackTrace (); }

        System.out.println ("Thread ended: " + t.getName ());
    }
}