package ThreadRevisionDemo;

import java.util.Calendar;
import java.util.concurrent.*;

public class ScheduledExecutorExample {

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        Task task = new Task();

//        executorService.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        executorService.scheduleWithFixedDelay(task, 1, 3, TimeUnit.SECONDS);

    }

}
class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Task name : " + Thread.currentThread().getName()
                + " Current time : " + Calendar.getInstance().get(Calendar.SECOND));
    }
}