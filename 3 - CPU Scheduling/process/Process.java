package process;

/**
 * Process
 */
public class Process extends Thread {
    private int number;
    private boolean started;
    private long startTime;
    private long endTime;

    public Process(int number) {
        this.number = number;
        this.started = false;
    }

    private void await() {
        try {
            sleep(5);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public long turnAround() {
        return (endTime - startTime);
    }

    public boolean getStarted() {
        return started;
    }

    public void setStartTime() {
        this.startTime = System.nanoTime();
    }

    @Override
    public void run() {
        this.started = true;
        System.out.println("\nPROCESS N° " + number + " STARTED");
        for (int i = 0; i < number; i++) {
            await();
        }
        this.endTime = System.nanoTime();
    }

    @Override
    public String toString() {
        return "PROCESS " + number;
    }

}
