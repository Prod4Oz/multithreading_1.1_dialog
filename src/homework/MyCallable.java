package homework;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        int count = 0;
        for (int i = 1; i <=10; i++, count++){
            Thread.sleep(200);
        }

        return count;
    }
}
