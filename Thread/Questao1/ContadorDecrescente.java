public class ContadorDecrescente extends Thread {

    private int valor = 100;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + valor);
            valor--;
        }
    }   

}