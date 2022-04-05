package ThreadRevisionDemo;

import java.util.concurrent.*;

public class CallableAndFutureTaskExample {
    private static int number = 5;

    public static void main(String[] args) {

        FutureTask[] futureTasks = new FutureTask[number]; // Creating new FutureTask objects array

        for (int i=0; i<number; i++){

            Callable call = new Tables(i+1);  // Creating class objects which implemetns Callable
            futureTasks[i] = new FutureTask(call); // Assigning Callable object to FutureTask
            Thread t = new Thread(futureTasks[i]); // Creating new Thread with FutureTask Object
            t.start(); // Starting Thread

        }
        // Printing results
        int i=1;
        for(FutureTask ft : futureTasks){
            Object o = null;
            try {
                o = ft.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            int[] table = (int[]) o;

            System.out.print("Table of " + i + ": " );
            for (int j : table){
                System.out.print(j + ", ");
            }
            System.out.println();
            i++;
        }
    }
}

class Tables implements Callable {

    private int number;

    public Tables(int number) {
        this.number = number;
    }

    @Override
    public Object call() throws Exception {
        return calculateTable(this.number);
    }

    public int[] calculateTable(int number){
        int[] result = new int[10];
        for (int i=1; i<11; i++){
            result[i-1] = number * i;
        }
        return result;
    }

}