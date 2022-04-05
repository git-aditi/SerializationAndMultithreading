package ThreadRevisionDemo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.*;

public class ThreadPoolExecutorCallableExample {

    public static void main(String[] args) {

        final int N = 25;

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        int[][] tables = new int[N][10];

        for (int i=0; i<N; i++){
            Tables t = new Tables(i+1);
            Future future = (Future) executorService.submit(t);
            try {
                int[] table = (int[])future.get();
                tables[i] = table;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();

        System.out.println("Table: " + Arrays.deepToString(tables));

    }
}
