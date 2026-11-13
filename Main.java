package ProducerConsumerSystem;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final int CAPACITY = 5;
        final int ITEMS = 10;
        
        SharedBuffer buffer = new SharedBuffer(CAPACITY);
        
        Thread producer = new Thread(new Producer(buffer, ITEMS), "Producer");
        Thread consumer = new Thread(new Consumer(buffer, ITEMS), "Consumer");
        
        producer.start();
        consumer.start();
        
        producer.join();
        consumer.join();
        
        System.out.println("All done. Buffer closed cleanly.");
    }
}
