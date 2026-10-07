package CreationOfThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
public class ReentrantLocking {
    private int counter=0;
    private final ReentrantLock reentrantLock= new ReentrantLock();
    public void inc(){
        reentrantLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"acuried lock");
            counter++;
            System.out.println("increment"+counter);
        } catch (Exception e) {
            // TODO: handle exception
        }
        finally{
              reentrantLock.unlock();
              System.out.println(Thread.currentThread().getName()+"comming outsude outside");
        }
    }
    public int getCounter(){
        return counter;
    }
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        ReentrantLocking reentrantLocking= new ReentrantLocking();
    for (int i = 0; i < 5; i++) {
        executorService.submit(()->reentrantLocking.inc());
    }

    executorService.shutdown();
try {
    executorService.awaitTermination(5, TimeUnit.SECONDS);
} catch (Exception e) {
    // TODO: handle exception
}
        System.out.println(reentrantLocking.getCounter()+"iii");
    }
}
