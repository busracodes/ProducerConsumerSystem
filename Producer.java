package ProducerConsumerSystem;

import java.util.Random;

public class Producer implements Runnable {

    private final SharedBuffer buffer;
    private final int totalItems;
    private final Random random = new Random();

    public Producer(SharedBuffer buffer, int totalItems) {
        this.buffer = buffer;
        this.totalItems = totalItems;
    }

    @Override
    public void run() {
        for (int item = 1; item <= totalItems; item++) {
            try {
                Thread.sleep(200 + random.nextInt(600));   // simulate production time

                buffer.put(item);                          // blocks if full

                System.out.println("[Producer] Produced item " + item + " "
                        + bar(buffer.size(), buffer.capacity())
                        + " | produced: " + item + "/" + totalItems);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Producer] Interrupted, stopping.");
                return;
            }
        }
        System.out.println("[Producer] Done, all " + totalItems + " items produced.");
    }

    private static String bar(int size, int capacity) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < capacity; i++) {
            sb.append(i < size ? "#" : "-");
        }
        return sb.append("] ").append(size).append("/").append(capacity).toString();
    }
}
