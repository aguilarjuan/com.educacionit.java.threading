
package com.educacionit.java.threading.basic.thread;


public class StartupInvalidThread {


    public static void main (String[] args) {

        for (int i=0; i<3; i++) {

            MyThread myThread = new MyThread (String.format ("NonThread N[%d]", i));
            myThread.run ();
        }
    }
}