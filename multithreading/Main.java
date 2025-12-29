package multithreading;

public class Main {
    public static void main(String[] args) {
        // first we need to understand:
        // in OS we have many concepts:

        // in older times cpu only had one core
        // so it could only execute one task at a time

        // lets understand according to evolution:
        // single tasking: only one task can be executed at a time
            // example: MS-DOS
        
        // multitasking: multiple tasks can be executed at the same time
            // example: Windows, Linux
        
        // multiprogramming: multiple programs running at the same time
            // this means multiple programs are loaded in memory and cpu switches between them to give the illusion of parallelism

        // multiprocessing: multiple processors (CPUs) in a system
            // example: servers, high end systems
    
        // does this mean multiprocessing and multitasking are same?
        // no, multiprocessing is about having multiple CPUs
        // multitasking is about executing multiple tasks at the same time

        // does this mean multitasking and multiprogramming are same?
        // no, multitasking is about executing multiple tasks at the same time
        // multiprogramming is about having multiple programs in memory and switching between them to give the illusion of parallelism

        // concurreny vs parallelism:
        // concurrency: multiple tasks making progress, but not necessarily at the same time
        // parallelism: multiple tasks executing at the same time

        // parallelism is achieved using multiple cores in a CPU which is called multithreading

        // multithreading: multiple threads within a single process executing concurrently
        // thread: a lightweight process, the smallest unit of execution within a process

        // example of multithreading in java:
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 1 - Count: " + i);
                try {
                    Thread.sleep(500); // sleep for 500 milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread 2 - Count: " + i);
                try {
                    Thread.sleep(500); // sleep for 500 milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

        // what is happening here?
        // both threads are started and they run concurrently
        // thread1 runs for 5 times and thread2 runs for 5 times

        // Note: in total we can have these many threads: cpu core count * 2
        // why is a core has 2 threads:
        // because of hyper-threading technology which allows a single core to run multiple threads

    }
}
