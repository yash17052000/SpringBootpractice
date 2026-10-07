package CreationOfThreads;


class SharedExample {
 
   public synchronized void waitExample() {
    System.out.println(Thread.currentThread().getName() + " Entering wait...");

    try {
        System.out.println(Thread.currentThread().getName() + " Calling wait...");
        wait(); // lock release karta hai aur WAITING state me chala jata hai

        System.out.println(Thread.currentThread().getName() + " wait is over...");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public synchronized void notifyOne() {
    System.out.println(Thread.currentThread().getName() + " calling notify...");
    notify();
}
}
public class SharedThreadWait {
    public static void main(String[] args) {
       final SharedExample sharedExample= new SharedExample();
       Thread t1 = new Thread(
        ()->sharedExample.waitExample(),
        "Thread1"
       );
       Thread t2 = new Thread(
        ()->sharedExample.waitExample(),
        "Thread2"
       );

       // A notifier thread that will wake them up one by one
Thread notifier = new Thread(() -> {

    try {
        // Give t1 and t2 time to call wait() first
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    sharedExample.notifyOne(); // Wakes one waiting thread

    try {
        // Wait a bit more, then notify again
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    sharedExample.notifyOne(); // Wakes the other waiting thread

}, "Notifier");
// t1.start();;
// t2.start();
// notifier.start();
    }
}
