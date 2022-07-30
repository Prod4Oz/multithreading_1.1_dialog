package homework;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        Thread.currentThread().setName(name);
        int count = 0;
        for (int i = 1; i <=4; i++, count++){
            Thread.sleep(3000);
            System.out.println("Hi ! " + Thread.currentThread().getName() + " - is work");
        }

        return count;
    }

    @Override
    public String toString() {
        return name;
    }
}
