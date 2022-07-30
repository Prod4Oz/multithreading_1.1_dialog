package homework;

import java.util.Arrays;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        Callable<Integer> myCallable1 = new MyCallable("Поток 1 ");
        Callable<Integer> myCallable2 = new MyCallable("Поток 2 ");
        Callable<Integer> myCallable3 = new MyCallable("Поток 3 ");
        Callable<Integer> myCallable4 = new MyCallable("Поток 4 ");

        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Future<Integer> future1 = executorService.submit(myCallable1);
        Future<Integer> future2 = executorService.submit(myCallable2);
        Future<Integer> future3 = executorService.submit(myCallable3);
        Future<Integer> future4 = executorService.submit(myCallable4);

        try {
            System.out.println(myCallable1 + "workTask ->" + future1.get());
            System.out.println(myCallable2 + "workTask ->" + future2.get());
            System.out.println(myCallable3 + "workTask ->" + future3.get());
            System.out.println(myCallable4 + "workTask ->" + future4.get());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        try {
            Integer result = executorService.invokeAny(Arrays.asList(myCallable1, myCallable2, myCallable3, myCallable4));
            System.out.println("Result" + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Finish");
        executorService.shutdown();


    }
}
