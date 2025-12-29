package multithreading;

/**
 * MULTITHREADING FUNDAMENTALS
 * 
 * Thread: Lightweight subprocess, independent path of execution
 * Why: Better CPU utilization, concurrent task execution
 */

// ============================================
// 1. CREATING THREADS - Two Ways
// ============================================

// Method 1: Extend Thread (Less preferred because of single inheritance limitation)
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}

// Method 2: Implement Runnable (PREFERRED because of better OOP practices i.e. we can extend other classes as well) 
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable running: " + Thread.currentThread().getName());
    }
}

// ============================================
// 2. THREAD LIFECYCLE - 6 States (Interview Question)
// ============================================
/**
 * 1. NEW - Created but not started - means that thread object is created but start() not called
 * 2. RUNNABLE - Ready to run or running - means that start() is called, waiting for CPU scheduling
 * 3. BLOCKED - Waiting for monitor lock - means that thread is blocked waiting for a lock
 * 4. WAITING - wait() called, waiting for notify() - means that thread is waiting indefinitely for another thread to perform a particular action
 * 5. TIMED_WAITING - sleep(), wait(timeout) - waiting for specified time - means that thread is waiting for a specified period
 * 6. TERMINATED - Execution completed - means that thread has finished execution
 */

class ThreadLifecycleDemo extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(1000); // TIMED_WAITING
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ============================================
// 3. SLEEP vs WAIT (Common Interview Question)
// ============================================
/**
 * sleep():
 * - Static method of Thread class
 * - Doesn't release lock
 * - Used for time-based delays
 * 
 * wait():
 * - Method of Object class
 * - Releases lock (must be in synchronized block)
 * - Used for inter-thread communication
 */

// ============================================
// 4. JOIN METHOD (Important)
// ============================================
class JoinDemo extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Child: " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// ============================================
// 5. DAEMON THREADS (Interview Question)
// ============================================
/**
 * Daemon: Background thread (e.g., Garbage Collector)
 * JVM exits when only daemon threads remain
 * Must call setDaemon(true) BEFORE start()
 */

class DaemonDemo extends Thread {
    @Override
    public void run() {
        System.out.println("Daemon: " + isDaemon());
    }
}

// ============================================
// MAIN - PRACTICAL EXAMPLES
// ============================================
public class A_Fundamentals {
    public static void main(String[] args) {
        
        // Example 1: Thread vs Runnable (Interview: Why prefer Runnable?)
        System.out.println("=== Thread vs Runnable ===");
        MyThread t1 = new MyThread();
        t1.start();

        // can we do MyThread tn = new MyThread(new MyRunnable()); ?

        // yes, we need to do this:
        /*
        class MyThread extends Thread {
            public MyThread(Runnable target) {
                super(target);
            }
            
            @Override
            public void run() {
                super.run(); // Execute Runnable's run()
                System.out.println("Additional MyThread logic");
            }
        }        
        */
        
        
        Thread t2 = new Thread(new MyRunnable());
        t2.start();
        
        // Lambda (Java 8+) - Modern way
        Thread t3 = new Thread(() -> {
            System.out.println("Lambda: " + Thread.currentThread().getName());
        });
        t3.start();
        
        // Example 2: Thread States
        System.out.println("\n=== Thread States ===");
        ThreadLifecycleDemo t4 = new ThreadLifecycleDemo();
        System.out.println("NEW: " + t4.getState());
        t4.start();
        System.out.println("RUNNABLE: " + t4.getState());
        try {
            Thread.sleep(100);
            System.out.println("TIMED_WAITING: " + t4.getState());
            t4.join();
            System.out.println("TERMINATED: " + t4.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Example 3: JOIN - Main waits for child
        System.out.println("\n=== JOIN Method ===");
        JoinDemo t5 = new JoinDemo();
        t5.start();
        try {
            t5.join(); // Main waits here
            System.out.println("Main continues after child completes");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Example 4: Daemon Thread
        // this is used for background tasks like garbage collection
        // how daemon thread is different from normal thread?
        // when only daemon threads are remaining, jvm exits, does this mean this is the main thread? no, main thread is a normal thread, daemon threads are background threads
        System.out.println("\n=== Daemon Thread ===");
        DaemonDemo daemon = new DaemonDemo();
        daemon.setDaemon(true); // Before start()
        daemon.start();
        
        System.out.println("Main thread ends");
    }
}

/**
 * INTERVIEW KEY POINTS:
 * 
 * Q1: Thread vs Runnable?
 * A: Runnable preferred because:
 *    - Java single inheritance limitation
 *    - Better OOP (composition over inheritance)
 *    - Can implement multiple interfaces
 *    - Thread class can still accept Runnable
 * 
 * Q2: start() vs run()?
 * A: - start(): Creates new thread, JVM calls run()
 *    - run(): Just method call in current thread (NO multithreading)
 * 
 * Q3: sleep() vs wait()?
 * A: - sleep(): Thread class, doesn't release lock, time-based
 *    - wait(): Object class, releases lock, needs notify/notifyAll
 * 
 * Q4: What is join()?
 * A: Makes current thread wait until the thread on which join() is called completes
 * 
 * Q5: Daemon thread?
 * A: Background thread that doesn't prevent JVM from exiting
 *    Must set before start(), Example: GC
 * 
 * Q6: Thread lifecycle states?
 * A: NEW → RUNNABLE → RUNNING → (BLOCKED/WAITING/TIMED_WAITING) → TERMINATED
 * 
 * Q7: How to create thread?
 * A: 1. Extend Thread class
 *    2. Implement Runnable (preferred)
 *    3. Lambda expression (Java 8+)
 */