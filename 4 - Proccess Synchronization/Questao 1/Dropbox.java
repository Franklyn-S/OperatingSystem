public class Dropbox {

    private int number;
    private boolean evenNumber = false;
    private boolean avaiable = true;
    private boolean canProduce = true;
    
    
    private boolean checkNumberParity() {
        return this.number % 2 == 0;
    }

    private synchronized void changeAvaibility(boolean availability) {
        avaiable = availability;
    }

    public synchronized int take(final boolean even) throws InterruptedException {

        if( avaiable && checkNumberParity() == even) {
            System.out.format("%s CONSUMIDOR obtem %d.%n", even ? "PAR" : "IMPAR", number);
            changeAvaibility(false);
            canProduce = true;
        } else {
            wait();
        }

        return number;
    }

    public synchronized void put(int number) throws InterruptedException {
        if (canProduce) {
            this.number = number;
            evenNumber = number % 2 == 0;
            System.out.format("PRODUTOR gera %d.%n", number);

            changeAvaibility(true);
            canProduce = false;
            notifyAll();
        }
    }
}