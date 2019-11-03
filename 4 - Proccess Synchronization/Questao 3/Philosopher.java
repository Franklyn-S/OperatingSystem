public class Philosopher implements Runnable {

    // The forks on either side of this Philosopher
    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        // Yet to populate this method
    }

}