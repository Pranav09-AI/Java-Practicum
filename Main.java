// Multithreaded Producer–Consumer using Thread Synchronization

class Buffer {
    private int item;
    private boolean available = false;

    // Produce method
    synchronized void produce(int value) {
        while (available) {
            try {
                wait(); // wait if buffer is full
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted while waiting");
                return;
            }
        }
        item = value;
        available = true;
        System.out.println("Producer produced: " + item);
        notifyAll(); // notify consumer
    }

    // Consume method
    synchronized int consume() {
        while (!available) {
            try {
                wait(); // wait if buffer is empty
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted while waiting");
                return -1; // return safely to avoid missing return error
            }
        }
        int val = item;
        available = false;
        System.out.println("Consumer consumed: " + val);
        notifyAll(); // notify producer
        return val; // return value to satisfy compiler
    }
}

// Producer Thread
class Producer extends Thread {
    private final Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
            try {
                Thread.sleep(300); // simulate production delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Producer interrupted during sleep");
                break;
            }
        }
    }
}

// Consumer Thread
class Consumer extends Thread {
    private final Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            int val = buffer.consume(); // fixed: always returns int
            if (val == -1) break;
            try {
                Thread.sleep(400); // simulate consumption delay
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Consumer interrupted during sleep");
                break;
            }
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("     Multithreaded Producer–Consumer Demo     ");
        System.out.println("==============================================");

        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted");
        }

        System.out.println("==============================================");
        System.out.println("Program Execution Completed Successfully");
        System.out.println("==============================================");
    }
}
