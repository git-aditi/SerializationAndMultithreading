package synchronization;

import com.sun.deploy.net.proxy.ProxyUnavailableException;

public class SynchronizedBlockExample {
    public static void main(String[] args) {
        Table1 table1 = new Table1();

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                table1.printTable(3);
            }
        };
        thread1.start();

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                table1.printTable(7);
            }
        };
        thread2.start();

        Thread thread3 = new Thread(){
            @Override
            public void run() {
                table1.printTable(10);
            }
        };
        thread3.start();

    }

}

class Table1{
    void printTable(int n){

        System.out.println("Thread: " + Thread.currentThread().getName());
        synchronized (this){
                    for (int i=1; i<=10; i++){
                        System.out.println(n + "X" + i + "=" + (n*i));
                        try {
                            Thread.sleep(400);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
        }
    }
}

class Thread3 extends Thread{
    private Table1 table1;

    Thread3(Table1 table1){
        this.table1 = table1;
    }
    @Override
    public void run() {
        table1.printTable(3);
    }
}
class Thread4 extends Thread{
    private Table1 table1;

    Thread4(Table1 table1){
        this.table1 = table1;
    }
    @Override
    public void run() {
        table1.printTable(7);
    }
}