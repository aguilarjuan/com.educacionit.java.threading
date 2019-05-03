
package com.educacionit.java.threading.basic.thread;


public class NonThread {


    private String name;


    public NonThread (String name) {

        super ();

        this.name = name;
    }


    public void run () {

        for (int i=0; i<20; i++) {

            System.out.println (String.format ("Running %s step %d", this.name, i));
        }
    }
}