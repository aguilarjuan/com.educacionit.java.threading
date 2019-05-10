
package com.educacionit.java.threading.intermediate;


public class StartupThreadJoin2 {


    public static void main(String[] args) {

        Thread th1 = new Thread (new Join2Thread (), "Thread 1");
        Thread th2 = new Thread (new Join2Thread (), "Thread 2");
        Thread th3 = new Thread (new Join2Thread (), "Thread 3");

        th1.start ();

        try {

            th1.join ();

        } catch (InterruptedException ex) { ex.printStackTrace (); }
        th2.start();


        try {

            th2.join ();

        } catch (InterruptedException ex) { ex.printStackTrace (); }
        th3.start ();


        try {

            th3.join ();

        } catch (InterruptedException ex) { ex.printStackTrace (); }

        System.out.println("All three threads have finished execution");
    }
}


class Join2Thread implements Runnable {


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