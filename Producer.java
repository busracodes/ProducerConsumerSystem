package ProducerConsumerSystem;


public class Producer implements Runnable {

    private final SharedBuffer buffer;
    private final int totalItems;

    public Producer(SharedBuffer buffer, int totalItems) {
        this.buffer = buffer;
        this.totalItems = totalItems;
    }

    @Override
    public void run() {
        // TODO: Generate items.
        // TODO: Insert items into the shared buffer.
        // TODO: Handle thread interruptions.
    }
}
