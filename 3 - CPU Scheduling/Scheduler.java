import java.util.concurrent.TimeUnit;

import algorithms.FCFS;
import algorithms.RoundRobin;

public class Scheduler {
    public static void await() {
        try {
            TimeUnit.MILLISECONDS.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        RoundRobin roundRobin1 = new RoundRobin();

        FCFS fcfs1 = new FCFS();

        roundRobin1.simulate();

        fcfs1.simulate();

    }
}