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
            System.out.println("Lendo " + Thread.currentThread().getName());
            //você tem acesso para ler do banco de dados
            SleepUtilities.nap();

            db.releaseReadLock();
            System.out.println("Parei de Ler " + Thread.currentThread().getName());
        }
    }
}