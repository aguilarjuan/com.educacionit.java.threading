
package com.educacionit.java.threading.tasks.basic;


import java.util.concurrent.*;


public class StartupSingleExecutor1 {


    public static void main(final String... args) throws Exception {

        final ExecutorService exService = Executors.newSingleThreadExecutor ();

        final Future<Integer> callFuture1 = exService.submit (new StartupSingleExecutor1 ().new MyCallable ());
        final Future<Integer> callFuture2 = exService.submit (new StartupSingleExecutor1 ().new MyCallable ());

        final int callval1 = callFuture1.get();
        System.out.println ("Callable:" + callval1);

        final int callval2 = callFuture2.get();
        System.out.println ("Callable:" + callval2);

        final boolean isTerminated = exService.isTerminated ();
        System.out.println (isTerminated);

        exService.awaitTermination(30, TimeUnit.SECONDS);
        exService.shutdownNow ();
        System.out.println ("Finished !!!");
    }


    class MyCallable implements Callable<Integer> {


        @Override
        public Integer call () {

            int cnt = 0;


            for (; cnt < 5; cnt++) {

                System.out.println ("Call:" + cnt);
            }

            return cnt;
        }
    }
}