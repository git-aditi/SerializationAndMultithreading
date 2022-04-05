package synchronization;

public class StaticSynchronizationExample {

    public static void main(String[] args) {
        Thread5 t1 = new Thread5();
        Thread5 t4 = new Thread5();
        Thread6 t2 = new Thread6();
        Thread7 t3 = new Thread7();
        t1.start();
        t4.start();
        t2.start();
        t3.start();
    }

}

class CalculateTables{
    synchronized static void printTable(int number){
        for (int i=1; i<11; i++){
            System.out.println(number + " X " + i + ": " + number*i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}

class Thread5 extends Thread{
    @Override
    public void run() {
        super.run();
        CalculateTables.printTable(7);
    }
}

class Thread6 extends Thread{
    @Override
    public void run() {
        super.run();
        CalculateTables.printTable(3);
    }
}

class Thread7 extends Thread{
    @Override
    public void run() {
        super.run();
        CalculateTables.printTable(4);
    }
}
