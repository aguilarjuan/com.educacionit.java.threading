
package com.educacionit.java.threading.basic.run;


public class MyThread implements Runnable {


    private String name;


    public MyThread (String name) {

        super ();

        this.name = name;
    }

    @Override
    public void run () {

        for (int i=0; i<20; i++) {

            System.out.println (String.format ("Running %s step %d", this.name, i));
        }
    }
}