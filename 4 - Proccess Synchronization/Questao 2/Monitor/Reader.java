import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Reader extends Thread {
    private ReentrantReadWriteLock lock;
    

    public Reader(String name, ReentrantReadWriteLock lock) {
        super(name);
        this.lock = lock;
    } 
            
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                 lock.readLock().lock();
                System.out.println("Reader is reading " + i);
            } finally {
                lock.readLock().unlock();
            }
            
        }

    }
}