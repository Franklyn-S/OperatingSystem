package circularQueue;

import process.Process;

import java.util.ArrayList;

/**
 * CircularQueue
 */
public class CircularQueue {
    ArrayList<Process> ready;

    public CircularQueue() {
        this.ready = new ArrayList<>();
    }

    private synchronized void addProcess(Process process) {
        ready.add(process);
    }

    private synchronized Process popProcess() {
        if (!ready.isEmpty()) {
            Process process = ready.get(0);
            ArrayList<Process> newReady = new ArrayList<>();
            for (Process p : ready) {
                if (p != process)
                    newReady.add(p);
            }

            ready = newReady;
            return process;
        }
        return null;
    }

    public synchronized Process modify(Process process) {
        if (process != null) {
            addProcess(process);
            return null;
        }
        return popProcess();
    }

    public int size() {
        return ready.size();
    }
}