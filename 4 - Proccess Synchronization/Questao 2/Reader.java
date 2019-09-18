public class Reader implements Runnable {
    private RWLock db;

    public Reader(RWLock db) {
        this.db = db;
    }

    public void run() {
        while (true) {
            //dorme por um tempo
            SleepUtilities.nap();

            db.acquireReadLock();
            //você tem acesso para ler do banco de dados
            SleepUtilities.nap();

            db.releaseReadLock();
        }
    }
}