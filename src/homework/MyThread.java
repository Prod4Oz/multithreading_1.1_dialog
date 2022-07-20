package homework;

class MyThread extends Thread {

    public MyThread(ThreadGroup mainGroup, String s) {
        super(mainGroup, s);
        start();
    }

    @Override
    public void run() {
        try {
            while(!isInterrupted()) {
                Thread.sleep(2500);
                System.out.println("Всем привет!"+ "Я - " + getName());
            }
        } catch (InterruptedException err) {

        } finally{
            System.out.printf("%s завершен\n", getName());
        }
    }
}