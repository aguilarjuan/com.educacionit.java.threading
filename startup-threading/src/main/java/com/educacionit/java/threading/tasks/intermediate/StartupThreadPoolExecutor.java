
package com.educacionit.java.threading.tasks.intermediate;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class StartupThreadPoolExecutor {

    public static void main(final String[] args) throws Exception {

        final ThreadPoolExecutor executor = new ThreadPoolExecutor (2, 3, 100, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<> (), new ThreadPoolExecutor.CallerRunsPolicy ());

        executor.execute (new Scanner("Java"));
        executor.execute (new Scanner("Scala"));
        executor.execute (new Scanner("C#"));
        System.out.println ("Old Max Pool Size:"+ executor.getMaximumPoolSize ());

        executor.setMaximumPoolSize (4);
        System.out.println ("New Max Pool Size:"+ executor.getMaximumPoolSize ());

        executor.shutdown();
    }
}


class Scanner implements Runnable {


    private String keyword;


    public Scanner (String keyword) {

        super ();

        this.keyword = keyword;
    }


    @Override
    public void run () {

        for (int i = 0; i<3; i++) {

            System.out.println ("Searching in internet the following topic: " + keyword);
        }
    }
}