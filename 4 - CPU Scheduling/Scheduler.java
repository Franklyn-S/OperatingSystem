import java.util.Random;

public class Scheduler {
    public static void main(String[] args) {
        /* 
        TODO:
        implement scheduling algorithms: FCFS(preemptive) and RoundRobin
        */

        int lenght = 5;
        Object[] readyList = new Object(lenght);
        int quantum = 100;
        Random generator =  new Randon();


        int[] randomTimes = new int[5];
        for (int i = 0; i < 5; i++){
            randomTimes[i] = generator.nextInt(10000);
        }

        Contador t1 =  new Contador(100);
        Contador t2 =  new Contador(200);
        Contador t3 =  new Contador(300);
        Contador t4 =  new Contador(400);
        Contador t5 =  new Contador(500);

        Thread[] threads = {t1, t2, t3, t4, t5};

        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < 10; j++) {
                threads[i].run();
            }
        }

    }
}