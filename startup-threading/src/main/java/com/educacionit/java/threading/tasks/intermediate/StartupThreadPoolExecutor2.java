
package com.educacionit.java.threading.tasks.intermediate;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class StartupThreadPoolExecutor2 {

    public static void main(final String[] args) throws Exception {

        final ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 100, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<> (), new ThreadFactoryTest (),
                new ThreadPoolExecutor.CallerRunsPolicy ());

        executor.execute(new Scanner ("Barcelona"));
        executor.execute(new Scanner ("Simpson"));
        executor.execute(new Scanner ("Bitcoin"));

        System.out.println ("Completed Task:"+ executor.getCompletedTaskCount ());
        System.out.println ("Old Core Pool Size:"+ executor.getCorePoolSize ());

        executor.setCorePoolSize (3);
        System.out.println("New Core Pool Size:"+ executor.getCorePoolSize ());
        executor.shutdown ();
    }
}


class ThreadFactoryTest implements ThreadFactory {


    @Override
    public Thread newThread (Runnable r) {

        Thread t = new Thread (r);
        t.setPriority(Thread.MAX_PRIORITY );

        System.out.println ("---Thread Created---");
        return t;
    }
}