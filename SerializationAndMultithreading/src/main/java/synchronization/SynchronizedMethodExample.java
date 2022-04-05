package synchronization;

public class SynchronizedMethodExample {

    public static void main(String[] args) {

        Table table = new Table();

        Thread1 thread1 = new Thread1(table);
        Thread2 thread2 = new Thread2(table);
        thread1.start();;
        thread2.start();

    }

}

class Table{
   synchronized void printTable(int n){

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

class Thread1 extends Thread{

    private Table table;

    Thread1(Table table){
        this.table = table;
    }

    @Override
    public void run() {
        table.printTable(5);
    }
}

class Thread2 extends Thread{

    private Table table;

    Thread2(Table table){
        this.table = table;
    }

    @Override
    public void run() {
        table.printTable(10);
    }
}