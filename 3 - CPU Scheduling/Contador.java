public class Contador extends Thread {
    
    private int countUntil;

    Contador(int countUntil) {
        this.countUntil = countUntil;
    }

    public void run(){
        for (int i = 0; i < countUntil; i++) {
            try {
                Contador.sleep(5);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }   
    }

}