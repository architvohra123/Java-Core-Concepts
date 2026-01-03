package multithreading;
/**
 * SYNCHRONIZATION - Interview & Practical Focus
 * 
 * What: Mechanism to control access of multiple threads to shared resources
 * Why: Prevents race conditions, data inconsistency, thread interference
 * 
 * Key Concept: Only ONE thread can execute synchronized code at a time
 */

// ============================================
// 1. RACE CONDITION - The Problem
// ============================================
/**
 * Race Condition: When multiple threads access shared data concurrently
 * and at least one modifies it, leading to unpredictable results
 * 
 * Example: Banking - Two threads withdrawing money simultaneously
 */

class Counter {
    private int count = 0;
    
    // WITHOUT synchronization - Race condition
    public void incrementUnsafe() {
        count++; // Not atomic! (read -> increment -> write)
    }
    
    // WITH synchronization - Thread safe
    public synchronized void incrementSafe() {
        count++;
    }
    
    public int getCount() {
        return count;
    }
}

// ============================================
// 2. SYNCHRONIZED METHOD
// ============================================
/**
 * synchronized keyword: Acquires lock on object/class
 * 
 * Instance method: Lock on 'this' object
 * Static method: Lock on Class object
 */

class BankAccount {
    private int balance = 1000;
    
    // Synchronized instance method - locks on 'this'
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + 
                             " withdrawing " + amount);
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + 
                             " completed. Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + 
                             " insufficient balance");
        }
    }
    
    public synchronized int getBalance() {
        return balance;
    }
}

// ============================================
// 3. SYNCHRONIZED BLOCK
// ============================================
/**
 * More flexible than synchronized method
 * Can synchronize on any object
 * Better performance - smaller critical section
 */

class SynchronizedBlockDemo {
    private int count = 0;
    private final Object lock = new Object(); // Custom lock object
    
    public void increment() {
        // Only critical section is synchronized
        synchronized(lock) {
            count++;
        }
    }
    
    public void incrementOnThis() {
        // Synchronize on 'this' object
        synchronized(this) {
            count++;
        }
    }
    
    public int getCount() {
        synchronized(lock) {
            return count;
        }
    }
}

// ============================================
// 4. OBJECT-LEVEL vs CLASS-LEVEL LOCKS
// ============================================
/**
 * Object-level lock: synchronized instance method/block
 * - Each object has its own lock
 * - Thread acquires lock on specific object instance
 * 
 * Class-level lock: synchronized static method/block
 * - One lock per class (not per object)
 * - All instances share same lock
 */

class LockLevels {
    private static int staticCount = 0;
    private int instanceCount = 0;
    
    // Object-level lock (on 'this')
    public synchronized void incrementInstance() {
        instanceCount++;
        System.out.println("Instance: " + instanceCount);
    }
    
    // Class-level lock (on LockLevels.class)
    public static synchronized void incrementStatic() {
        staticCount++;
        System.out.println("Static: " + staticCount);
    }
    
    // Class-level lock using block
    public void incrementStaticBlock() {
        synchronized(LockLevels.class) {
            staticCount++;
        }
    }
}

// ============================================
// 5. CRITICAL SECTION
// ============================================
/**
 * Critical Section: Code that accesses shared resources
 * Must be protected by synchronization
 * Keep it small for better performance
 */

class CriticalSectionDemo {
    private int sharedResource = 0;
    
    public void processData() {
        // Non-critical section - can run concurrently
        System.out.println("Preparing data...");
        doSomeWork();
        
        // Critical section - needs synchronization
        synchronized(this) {
            sharedResource++;
            System.out.println("Updated shared resource: " + sharedResource);
        }
        
        // Non-critical section - can run concurrently
        System.out.println("Cleaning up...");
    }
    
    private void doSomeWork() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// ============================================
// MAIN - PRACTICAL EXAMPLES
// ============================================
public class B_Synchronization {
    public static void main(String[] args) throws InterruptedException {
        
        // Example 1: Race Condition Demo
        System.out.println("=== Race Condition ===");
        Counter counter = new Counter();
        
        // Create 2 threads incrementing 1000 times each
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementUnsafe();
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementUnsafe();
            }
        });
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        System.out.println("Unsafe count (should be 2000): " + counter.getCount());
        
        // With synchronization
        Counter safeCounter = new Counter();
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeCounter.incrementSafe();
            }
        });
        
        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                safeCounter.incrementSafe();
            }
        });
        
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        
        System.out.println("Safe count: " + safeCounter.getCount());
        
        // Example 2: Bank Account - Synchronized Method
        System.out.println("\n=== Bank Account Withdrawal ===");
        BankAccount account = new BankAccount();
        
        Thread user1 = new Thread(() -> account.withdraw(600), "User1");
        Thread user2 = new Thread(() -> account.withdraw(600), "User2");
        
        user1.start();
        user2.start();
        user1.join();
        user2.join();
        
        System.out.println("Final balance: " + account.getBalance());
        
        // Example 3: Synchronized Block
        System.out.println("\n=== Synchronized Block ===");
        SynchronizedBlockDemo blockDemo = new SynchronizedBlockDemo();
        
        Thread tb1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                blockDemo.increment();
            }
        });
        
        Thread tb2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                blockDemo.increment();
            }
        });
        
        tb1.start();
        tb2.start();
        tb1.join();
        tb2.join();
        
        System.out.println("Block count: " + blockDemo.getCount());
        
        // Example 4: Object-level vs Class-level locks
        System.out.println("\n=== Lock Levels ===");
        LockLevels obj1 = new LockLevels();
        LockLevels obj2 = new LockLevels();
        
        // Object-level: Different objects, different locks (run parallel)
        Thread to1 = new Thread(() -> obj1.incrementInstance(), "Obj1-Thread");
        Thread to2 = new Thread(() -> obj2.incrementInstance(), "Obj2-Thread");
        
        to1.start();
        to2.start();
        to1.join();
        to2.join();
        
        // Class-level: Same lock for all objects (run sequential)
        Thread ts1 = new Thread(() -> LockLevels.incrementStatic(), "Static1");
        Thread ts2 = new Thread(() -> LockLevels.incrementStatic(), "Static2");
        
        ts1.start();
        ts2.start();
        ts1.join();
        ts2.join();
        
        // Example 5: Critical Section
        System.out.println("\n=== Critical Section ===");
        CriticalSectionDemo csDemo = new CriticalSectionDemo();
        
        Thread tc1 = new Thread(() -> csDemo.processData());
        Thread tc2 = new Thread(() -> csDemo.processData());
        
        tc1.start();
        tc2.start();
        tc1.join();
        tc2.join();
    }
}

/**
 * INTERVIEW KEY POINTS:
 * 
 * Q1: What is synchronization?
 * A: Mechanism to control access of multiple threads to shared resources,
 *    ensuring only one thread executes critical section at a time.
 * 
 * Q2: What is race condition?
 * A: When multiple threads access shared data concurrently and at least one
 *    modifies it, causing unpredictable results. Solved by synchronization.
 * 
 * Q3: synchronized method vs synchronized block?
 * A: Method: Locks entire method (less flexible, larger critical section)
 *    Block: Locks specific code section (more flexible, better performance)
 * 
 * Q4: Object-level vs Class-level lock?
 * A: Object-level: Lock on instance (this) - each object has own lock
 *    Class-level: Lock on Class object - shared across all instances
 * 
 * Q5: What is critical section?
 * A: Code segment that accesses shared resources and must be protected
 *    by synchronization. Keep it minimal for better performance.
 * 
 * Q6: Can two threads execute synchronized methods on same object?
 * A: No, if both methods lock on same object (this). Only one thread
 *    can hold the lock at a time.
 * 
 * Q7: Can two threads execute synchronized methods on different objects?
 * A: Yes, different objects have different locks (object-level locking).
 * 
 * Q8: What happens if thread tries to acquire already held lock?
 * A: Thread enters BLOCKED state and waits until lock is released.
 * 
 * Q9: Is synchronized keyword enough for thread safety?
 * A: Not always. Need proper design: minimize shared mutable state,
 *    use immutable objects, consider volatile for visibility.
 * 
 * BEST PRACTICES:
 * 1. Keep synchronized blocks small (minimize critical section)
 * 2. Never synchronize on null or mutable objects
 * 3. Avoid nested synchronization (deadlock risk)
 * 4. Use synchronized block over method when possible
 * 5. Consider higher-level constructs (ReentrantLock, atomic classes)
 * 6. Document thread safety guarantees
 */