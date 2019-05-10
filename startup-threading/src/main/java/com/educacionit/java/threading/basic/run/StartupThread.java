
package com.educacionit.java.threading.basic.run;


public class StartupThread {


    public static void main (String[] args) {

        for (int i=0; i<3; i++) {

            Thread myRun = new Thread (new MyThread (String.format ("Thread N[%d]", i)));
            myRun.start ();
        }
    }
}