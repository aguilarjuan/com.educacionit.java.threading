
package com.educacionit.java.threading.basic.thread;


import static org.apache.commons.lang3.RandomUtils.nextInt;


public class MyThreadPaused extends Thread {


    private String name;


    public MyThreadPaused (String name) {

        super ();

        this.name = name;
    }

    @Override
    public void run () {

        try {

            for (int i=0; i<20; i++) {

                System.out.println (String.format ("Running %s step %d", this.name, i));

                int s = nextInt (1000, 5000);
                System.out.println (String.format ("%s paused %d", this.name, s));
                Thread.sleep (s);
            }

        } catch (Exception e) { e.printStackTrace ();}
    }
}