package ThreadRevisionDemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {

    public static void main(String[] args) {

        final int N = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for(int i=0; i<N; i++){
            FixedThreadPool ftp = new FixedThreadPool("Task#: " + i);
            executorService.execute(ftp);
        }
    }

}

class FixedThreadPool implements Runnable{

    private String taskName;

    public FixedThreadPool(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        if(taskName.contains("10")) {
            throw new ArrayIndexOutOfBoundsException();
        }
        System.out.println("Thread: " + Thread.currentThread().getName() + " Task Name: " + taskName);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}