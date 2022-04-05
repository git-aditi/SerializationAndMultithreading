package synchronization;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlockingQueueExample {
    public static void main(String[] args) {
        //Creating BlockingQueue of size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        //starting producer to produce messages in queue
        new Thread(producer).start();
        //starting consumer to consume messages from queue
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started");
    }
}

class Message{
    private String message;

    public Message(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}

class Producer implements Runnable{

    private BlockingQueue<Message> queue;
    private final int produceCount = 50;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    private void produce(){
        for (int i=0; i<produceCount; i++){
            Message message = new Message(" "+ i);
            try {
                Thread.sleep(100);
                queue.put(message);
                System.out.println("Produced:"+ message.getMessage());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Message message = new Message("Exit");
        try {
            queue.put(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        produce();
    }
}


class Consumer implements Runnable{

    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    private void consume(){
        try {
            Message message;
            while ((message = queue.take()).getMessage() != "Exit"){
                Thread.sleep(1000);
                System.out.println("Consummed:"+message.getMessage());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        consume();
    }
}
