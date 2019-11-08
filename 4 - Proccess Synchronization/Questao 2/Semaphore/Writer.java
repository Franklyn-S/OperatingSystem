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
            System.out.println("Escrevendo " + Thread.currentThread().getName());
            //você tem acesso para ler do banco de dados
            SleepUtilities.nap();

            db.releaseWriteLock();
            System.out.println("Parei de Escrever " + Thread.currentThread().getName());
        }
    }
}