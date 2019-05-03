
package com.educacionit.java.threading.basic.thread;


public class StartupThread {


    public static void main (String[] args) {

        for (int i=0; i<3; i++) {

            MyThread myThread = new MyThread (String.format ("Thread N[%d]", i));
            myThread.start ();
        }
    }
}