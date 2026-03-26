//Program:2 -> Producer–Consumer problem using synchronization and inter-thread communication
// Shared resource (Buffer)
class Buffer {

    int data;
    boolean hasValue = false; // check if buffer is full or empty

    // Produce method
    synchronized void produce(int value) {
        try {
            // if buffer already has value → wait
            while (hasValue) {
                wait();
            }

            // produce data
            data = value;
            System.out.println("Produced: " + data);

            hasValue = true; // now buffer is full

            notify(); // notify consumer
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Consume method
    synchronized void consume() {
        try {
            // if buffer is empty → wait
            while (!hasValue) {
                wait();
            }

            // consume data
            System.out.println("Consumed: " + data);

            hasValue = false; // now buffer is empty

            notify(); // notify producer
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

//Producer Thread
class Producer extends Thread {
    Buffer buffer;

    Producer(Buffer b) {
        buffer = b;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
        }
    }
}

//Consumer Thread
class Consumer extends Thread {
    Buffer buffer;

    Consumer(Buffer b) {
        buffer = b;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
        }
    }
}

//Main Class
public class Program2 {
    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        // create threads
        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);

        // start threads
        p.start();
        c.start();
    }
}