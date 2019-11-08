package simulator;

import circularQueue.CircularQueue;
import process.Process;

public class Simulator extends Thread {
    Process process;
    int value;
    CircularQueue ready;

    public Simulator(int time, CircularQueue ready) {
        this.process = new Process(time);
        this.value = (int) (Math.random() * (500 - 100) + 100);
        System.out.println("Entered in time " + value + " on Ready Queue of process " + time);
        this.ready = ready;
    }

    private void await() {
        try {
            sleep(value);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public Process getProcess() {
        return this.process;
    }

    @Override
    public void run() {
        await();
        process.setStartTime();
        ready.modify(process);
    }
}
