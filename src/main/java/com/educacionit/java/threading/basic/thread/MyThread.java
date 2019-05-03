
package com.educacionit.java.threading.basic.thread;


public class MyThread extends Thread {


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