import java.util.concurrent.Semaphore;

public class Database implements RWLock {
    private int readerCount;
    private Semaphore mutex;
    private Semaphore db;

    public Database() {
        readerCount = 0;
        mutex = new Semaphore(1);
        db = new Semaphore(1);
    }

    public void acquireReadLock() {
        try{
            mutex.acquire();
        }catch(InterruptedException e) {
            System.out.println(e);
        }
        ++readerCount;

        if (readerCount == 1) {
            try{
                db.acquire();
            }catch(InterruptedException e) {
                System.out.println(e);
            }
        }

        mutex.release();
    }
    public void releaseReadLock(){
        try{
            mutex.acquire();
        }catch(InterruptedException e) {
            System.out.println(e);
        }
        --readerCount;
        
        if (readerCount == 1) {
            try{
                db.acquire();
            }catch(InterruptedException e) {
                System.out.println(e);
            }
        }
        
        mutex.release();
    }
    
    public void acquireWriteLock(){
        try{
            db.acquire();
        }catch(InterruptedException e) {
            System.out.println(e);
        }
    }
    public void releaseWriteLock(){
        db.release();
    }
}