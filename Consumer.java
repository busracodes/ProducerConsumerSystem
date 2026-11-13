package ProducerConsumerSystem;

public class Consumer implements Runnable {

    private final SharedBuffer buffer;
    private final int totalItems;

    public Consumer(SharedBuffer buffer, int totalItems) {
        this.buffer = buffer;
        this.totalItems = totalItems;
    }

    @Override
    public void run() {
        // TODO: Retrieve items from the shared buffer.
        // TODO: Process each item.
        // TODO: Handle thread interruptions.
    }
}
package ProducerConsumerSystem;
import java.util.Random;
public class Consumer implements Runnable {
    private final SharedBuffer buffer;
    private final int totalItems;
    private final Random random = new Random();
    public Consumer(SharedBuffer buffer, int totalItems) {
        this.buffer = buffer;
        this.totalItems = totalItems;
    }
    @Override
    public void run() {
        for (int i = 1; i <= totalItems; i++) {
            try {
                int item = buffer.take();                  // blocks if empty
                System.out.println("[Consumer] Consumed item " + item + " "
                        + bar(buffer.size(), buffer.capacity())
                        + " | consumed: " + i + "/" + totalItems);
    Thread.sleep(300 + random.nextInt(800));   // simulate 
processing time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Consumer] Interrupted, stopping.");
                return;
            }
        }
        System.out.println("[Consumer] Done, all " + totalItems + " items 
consumed.");
    }
    private static String bar(int size, int capacity) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < capacity; i++) {
            sb.append(i < size ? "#" : "-");
        }
        return sb.append("] 
").append(size).append("/").append(capacity).toString();
    }
}
