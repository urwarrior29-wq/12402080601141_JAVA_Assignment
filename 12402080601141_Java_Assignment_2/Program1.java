//Program 1-> youFind prime numbers using multithreading (Thread, Runnable, Executor Framework) 


import java.util.concurrent.*;

// Utility class for prime checking
class PrimeUtil {

    // Function to check if a number is prime
    static boolean isPrime(int n) {
        if (n <= 1) return false;

        // loop till square root of n
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false; // not prime
        }
        return true; // prime
    }
}

// 1 Using Thread class
class PrimeThread extends Thread {

    int start, end;

    // constructor to initialize range
    PrimeThread(int s, int e) {
        start = s;
        end = e;
    }

    // run() is executed when thread starts
    public void run() {
        System.out.println("Thread Class Output:");

        for (int i = start; i <= end; i++) {
            if (PrimeUtil.isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println(); // for next line
    }
}

// 2 Using Runnable interface
class PrimeRunnable implements Runnable {

    int start, end;

    // constructor
    PrimeRunnable(int s, int e) {
        start = s;
        end = e;
    }

    // run method
    public void run() {
        System.out.println("Runnable Output:");

        for (int i = start; i <= end; i++) {
            if (PrimeUtil.isPrime(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

//Main class
public class Program1 {
    public static void main(String[] args) {

        // Using Thread class
        // create object of thread
        PrimeThread t1 = new PrimeThread(1, 50);

        // start thread (important)
        t1.start();

        // Using Runnable interface
        // create runnable object
        PrimeRunnable r1 = new PrimeRunnable(51, 100);

        // pass runnable to Thread
        Thread t2 = new Thread(r1);
        t2.start();

        // Using Executor Framework (modern way)
        // create thread pool of size 2
        ExecutorService ex = Executors.newFixedThreadPool(2);

        // execute tasks
        ex.execute(new PrimeRunnable(101, 150));
        ex.execute(new PrimeRunnable(151, 200));

        // shutdown executor (important)
        ex.shutdown();
    }
}