
package com.educacionit.java.threading.basic.thread;


public class StartupThreadWithPause {


    public static void main (String[] args) throws Exception {

        for (int i=0; i<3; i++) {

            MyThreadPaused myThread = new MyThreadPaused (String.format ("Thread N[%d]", i));
            myThread.start ();
        }
    }
}