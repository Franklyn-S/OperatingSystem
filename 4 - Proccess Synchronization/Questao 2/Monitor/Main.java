import java.util.concurrent.locks.ReentrantReadWriteLock;
public class Main {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        Reader reader = new Reader("1", lock);
        Writer writer = new Writer("1", lock);
        writer.start();
        reader.start();
    }
} 

      

    


        

        