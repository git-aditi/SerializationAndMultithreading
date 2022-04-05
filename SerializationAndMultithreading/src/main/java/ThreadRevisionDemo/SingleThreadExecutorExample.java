package ThreadRevisionDemo;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class SingleThreadExecutorExample {

    public static void main(String[] args) {

        final int n = 25;

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i=0; i<n; i++) {
            SingleThreadExecutorClass stec = new SingleThreadExecutorClass("Task#:" + i);
            executor.execute(stec);
        }

    }
}

class SingleThreadExecutorClass implements Runnable{

    private String taskName;

    public SingleThreadExecutorClass(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

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
