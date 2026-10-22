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
