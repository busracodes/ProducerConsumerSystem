
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.concurrent.Semaphore;

public class bufferT {
	

	class Buffer {
	    private final Queue<Integer> queue = new LinkedList<>();
	    private final Semaphore empty = new Semaphore(5);
	    private final Semaphore full = new Semaphore(0);
	    private final Semaphore mutex = new Semaphore(1);

	    public void produce(int item) throws InterruptedException {
	        empty.acquire();
	        mutex.acquire();

	        queue.add(item);
	        System.out.println("Produced: " + item);

	        mutex.release();
	        full.release();
	    }

	    public int consume() throws InterruptedException {
	        full.acquire();
	        mutex.acquire();

	        int item = queue.remove();
	        System.out.println("Consumed: " + item);

	        mutex.release();
	        empty.release();

	        return item;
	    }
	}
}
