
package com.educacionit.java.threading.tasks.basic;


import java.util.concurrent.*;


public class StartupSingleExecutor2 {


    public static void main(final String... args) throws InterruptedException, ExecutionException {

        final int num = 2;

        final ExecutorService exService = Executors.newFixedThreadPool (num);

        final Future<String> runFuture = exService.submit (new RunnableThread(), "done");

        final String runval = runFuture.get ();
        System.out.println ("Task:" + runval);

        final Future<Integer> callFuture = exService.submit (new CallableThread ());
        final int callval = callFuture.get ();
        System.out.println ("Return Value:" + callval);

        final boolean isTerminated = exService.isTerminated ();
        System.out.println (isTerminated);

        exService.awaitTermination (30, TimeUnit.SECONDS);
        exService.shutdown ();
    }
}


class CallableThread implements Callable<Integer> {


    @Override
    public Integer call () {

        int cnt = 1;

        for (; cnt < 3; cnt++) {

            System.out.println ("Callable:" + cnt);
        }

        return cnt;
    }
}


class RunnableThread implements Runnable {


    @Override
    public void run () {

        int cnt = 1;

        for (; cnt < 3; cnt++) {

            System.out.println ("Runnable:" + cnt);
        }
    }
}