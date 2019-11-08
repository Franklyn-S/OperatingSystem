import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Writer extends Thread {
    private ReentrantReadWriteLock lock;

    public Writer(String name, ReentrantReadWriteLock lock) {
        super(name);
        this.lock = lock;
    }
 
    public void run() {
        for (int j = 0; j < 10; j++) {
            try{
                lock.writeLock().lock();
                            System.out.println("Writer is writing " + j);
            } finally {
                lock.writeLock().unlock();
            }
        }

    }
}
