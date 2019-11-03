package algorithms;

import java.util.concurrent.TimeUnit;

import circularQueue.CircularQueue;
import process.Process;
import simulator.Simulator;

public class RoundRobin {
    public void simulate() {
        System.out.println("---- Round Robin simulation ----\n");
        final CircularQueue ready = new CircularQueue();

        int quantum = (int) (Math.random() * (500 - 100) + 100);

        Simulator s1 = new Simulator(100, ready);
        Simulator s2 = new Simulator(200, ready);
        Simulator s3 = new Simulator(300, ready);
        Simulator s4 = new Simulator(400, ready);
        Simulator s5 = new Simulator(500, ready);

        s1.start();
        s2.start();
        s3.start();
        s4.start();
        s5.start();

        int counter = 0;
        int insideCounter = 0;
        while (counter < ready.size()) {
            Process p = ready.modify(null);
            if (p != null) {
                try {
                    if (p.getStarted())
                        p.resume();
                    else
                        p.start();
                    insideCounter++;
                    System.out.println("Running QUANTUM " + quantum + " on " + insideCounter + " step");

                    TimeUnit.MILLISECONDS.sleep(quantum);
                    if (p.isAlive()) {
                        p.suspend();
                        ready.modify(p);
                    }
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
        System.out.println("\nFinished");
        Process p1 = s1.getProcess();
        Process p2 = s2.getProcess();
        Process p3 = s3.getProcess();
        Process p4 = s4.getProcess();
        Process p5 = s5.getProcess();
        System.out.println(p1 + " Turn Around: " + p1.turnAround());
        System.out.println(p2 + " Turn Around: " + p2.turnAround());
        System.out.println(p3 + " Turn Around: " + p3.turnAround());
        System.out.println(p4 + " Turn Around: " + p4.turnAround());
        System.out.println(p5 + " Turn Around: " + p5.turnAround());

    }
}