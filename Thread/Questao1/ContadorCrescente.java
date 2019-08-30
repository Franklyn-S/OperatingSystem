public class ContadorCrescente implements Runnable {

    private int valor = 0;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " +  valor);
            valor++;
        }
    }   

}