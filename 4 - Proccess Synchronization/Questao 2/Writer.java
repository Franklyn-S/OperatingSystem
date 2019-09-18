public class Writer implements Runnable {
    private RWLock db;

    public Writer(RWLock db) {
        this.db = db;
    }

    public void run() {
        while (true) {
            //dorme por um tempo
            SleepUtilities.nap();

            db.acquireWriteLock();
            //você tem acesso para ler do banco de dados
            SleepUtilities.nap();

            db.releaseWriteLock();
        }
    }
}