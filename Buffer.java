package ProducerConsumerSystem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class SharedBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;
    private final Semaphore emptySlots;
    private final Semaphore fullSlots = new Semaphore(0);
    private final Semaphore mutex = new Semaphore(1);

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
        this.emptySlots = new Semaphore(capacity);
    }

    public void put(int item) throws InterruptedException {
        emptySlots.acquire(); // wait if buffer is full
        mutex.acquire();
        queue.add(item);
        mutex.release();
        fullSlots.release();
    }

    public int take() throws InterruptedException {
        fullSlots.acquire(); // wait if buffer is empty
        mutex.acquire();
        int item = queue.remove();
        mutex.release();
        emptySlots.release();
        return item;
    }

    public int size() throws InterruptedException {
        mutex.acquire();
        try {
            return queue.size();
        } finally {
            mutex.release();
        }
    }

    public int capacity() {
        return capacity;
    }
}
