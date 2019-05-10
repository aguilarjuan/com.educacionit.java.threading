
package com.educacionit.java.threading.intermediate;



public class StartupYield2 {


    public static void main (String[] args) {

        MyThreadYield t = new MyThreadYield ();
        t.start ();

        for (int i=0; i<5; i++) {

            Thread.yield ();

            System.out.println (Thread.currentThread ().getName () + " in control");
        }
    }
}


class MyThreadYield extends Thread {


    public void run () {

        for (int i=0; i<5 ; i++) {

            System.out.println (Thread.currentThread ().getName () + " in control "  + i);
        }
    }
}