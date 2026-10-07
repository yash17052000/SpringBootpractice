package CreationOfThreads;


class SharedExample {
 
   public synchronized void waitExample() {
    System.out.println(Thread.currentThread().getName() + " Entering slepep...");

    try {
        System.out.println(Thread.currentThread().getName() + " Calling sleep...");
        Thread.sleep(2000);; // it will not release and thread has to wait

        System.out.println(Thread.currentThread().getName() + " sleep is over...");
    } catch (Exception e) {
        e.printStackTrace();
    }
}


}
public class SharedThreadSleep {
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

     


   
t1.start();;
t2.start();

    }
}
