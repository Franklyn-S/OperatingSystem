public class Main {
    public static void main(String[] args) {
        Database db = new Database();
 
        (new Thread(new Reader(db))).start();
        (new Thread(new Reader(db))).start();
        (new Thread(new Writer(db))).start();

    }
}
