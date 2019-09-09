public class Main {
    public static void main(String[] args) {
        ContadorCrescente contadorCrescente1 = new ContadorCrescente();
        ContadorCrescente contadorCrescente2 = new ContadorCrescente();

        ContadorDecrescente contadorDecrescente1 = new ContadorDecrescente();
        ContadorDecrescente contadorDecrescente2 = new ContadorDecrescente();

        Thread threadContadorCrescente1 = new Thread(contadorCrescente1);
        Thread threadContadorCrescente2 = new Thread(contadorCrescente2);

        contadorDecrescente1.start();
        contadorDecrescente2.start();
        threadContadorCrescente1.start();
        threadContadorCrescente2.start();


    }
    
}