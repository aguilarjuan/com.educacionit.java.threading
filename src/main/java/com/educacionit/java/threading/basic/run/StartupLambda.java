
package com.educacionit.java.threading.basic.run;


public class StartupLambda {


    public static void main (String[] args) {

        Runnable run = () -> {

            for (int i=0; i<20; i++) {

                System.out.println (String.format ("Running %s step %d", Thread.currentThread ().getName (), i));
            }
        };


        for (int i=0; i<3; i++) {

            Thread myRun = new Thread (run, String.format ("Thread N[%d]", i));
            myRun.start ();
        }
    }
}