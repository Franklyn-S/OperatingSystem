public class Main {
    public static void main(String[] args) {
        Corredor corredor1 = new Corredor("Hariamy", 10, 5);
        Corredor corredor2 = new Corredor("Franklyn", 15, 3);
        Corredor corredor3 = new Corredor("Igor", 20, 1);
        Corredor corredor4 = new Corredor("Brenda", 3, 4);

        corredor1.start();
        corredor2.start();
        corredor3.start();
        corredor4.start();
    }
}