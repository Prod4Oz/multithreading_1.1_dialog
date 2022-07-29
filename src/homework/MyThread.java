package homework;

class MyThread extends Thread {

    public MyThread(ThreadGroup mainGroup, String s) {
        super(mainGroup, s);
        start(); // при передече конструктору вызываем старт
    }

    @Override
    public void run() {
//        System.out.println("Hello!!! I am - " + Thread.currentThread().getName() );
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