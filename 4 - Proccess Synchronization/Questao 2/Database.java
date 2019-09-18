public class Database implements RWLock {
    private int readerCounter;
    private Semaphore mutex;
    private Semaphore db;

    public Database() {
        readerCount = 0;
        mutex = new Semaphore(1);
        db = new Semaphore(1);
    }

    public void acquireReadLock(){
        mutex.acquire();
        ++readerCount;

        if (readerCount == 1) {
            db.acquire();
        }

        mutex.release();
    }
    public void releaseReadLock(){
        mutex.acquire();
        --readerCount;
        
        if (readerCount == 1) {
            db.acquire();
        }
        
        mutex.release();
    }
    
    public void acquireWriteLock(){
        db.acquire();
    }
    public void releaseWriteLock(){
        db.release();
    }
}