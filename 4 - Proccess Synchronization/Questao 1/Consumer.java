import java.util.Random;

public class Consumer implements Runnable {
    private final Dropbox dropbox;
    private final boolean even;

    public Consumer(boolean even, Dropbox dropbox) {
        
        this.even = even;
        this.dropbox = dropbox;
    }

    public synchronized void run() {
        Random random = new Random();
        while (true) {
            try {
                dropbox.take(even);
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) { }
        }
    }
}