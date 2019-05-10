
package com.educacionit.java.threading.basic.thread;


public class StartupNonThread {


    public static void main (String[] args) {

        for (int i=0; i<3; i++) {

            NonThread nonThread = new NonThread (String.format ("NonThread N[%d]", i));
            nonThread.run ();
        }
    }
}