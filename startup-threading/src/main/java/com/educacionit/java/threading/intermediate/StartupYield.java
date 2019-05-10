
package com.educacionit.java.threading.intermediate;


import java.util.ArrayList;
import java.util.List;


public class StartupYield {


    public static void main (String[] args) {

        List<SampleThread> list = new ArrayList<> ();

        for(int i=0; i<3; i++) {

            SampleThread et = new SampleThread (i + 5);

            list.add (et);
            et.start ();
        }

        for (SampleThread et: list){

            try {
                et.join ();

            } catch (InterruptedException ex) { ex.printStackTrace (); }
        }
    }
}



class SampleThread extends Thread {

    private int stopCount;


    public SampleThread (int count) {

        this.stopCount = count;
    }


    public void run () {

        for(int i=0; i<50; i++) {

            if (i%stopCount == 0) {

                System.out.println ("Stopping thread: " + getName ());
                yield ();
            }
        }
    }
}