
import java.util.concurrent.Semaphore;

    
public class DiningPhilosophers {
    static int philosophersNumber = 5;
    static Philosopher philosophers[] = new Philosopher[philosophersNumber];
    static Fork forks[] = new Fork[philosophersNumber];

    public static void main(String argv[]) {
        System.out.println("Dining philosophers problem.");

        for (int i = 0; i < philosophersNumber; i++) {
            forks[i] = new Fork();
        }

        for (int i = 0; i < philosophersNumber; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % philosophersNumber]);
            philosophers[i].start();
        }

        while (true) {
            try {
                // sleep 1 sec
                Thread.sleep(1000);

                // check for deadlock
                boolean deadlock = true;
                for (Fork f : forks) {
                    if (f.isFree()) {
                        deadlock = false;
                        break;
                    }
                }
                if (deadlock) {
                    Thread.sleep(1000);
                    System.out.println("Deadlock!");
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

        System.out.println("Bye!");
        System.exit(0);
    }
}