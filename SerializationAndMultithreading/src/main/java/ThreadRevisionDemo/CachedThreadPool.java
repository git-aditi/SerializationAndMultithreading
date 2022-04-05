package ThreadRevisionDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

    public static void main(String[] args) {
        final int N = 25;

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=0; i<N; i++){
            FixedThreadPool ftp = new FixedThreadPool("Task#: " + i);
            executorService.execute(ftp);
        }

    }

}


