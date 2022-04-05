package synchronization;

public class DeadlockExample {
    public static void main(String[] args) {

        String resource1 = "resource 1";
        String resource2 = "resource 2";

        Thread t1 = new Thread() {

            @Override
            public void run() {
                super.run();
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " locked Resource 1 . . .");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resource2) {
                        System.out.println(Thread.currentThread().getName() + " locked Resource 2 . . .");
                    }
                }
            }
        };

        Thread t2 = new Thread() {

            @Override
            public void run() {
                super.run();
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " locked Resource 2 . . .");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (resource1) {
                        System.out.println(Thread.currentThread().getName() + " locked Resource 1 . . .");
                    }
                }
            }
        };

        t1.setName("Thread - 1");
        t2.setName("Thread - 2");

        t1.start();
        t2.start();

    }
}
