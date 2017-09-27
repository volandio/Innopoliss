package Date_25_09_17.SimpleSemaphore;

public class SimpleSemaphore {
    boolean taken = false;

    public synchronized void take() {
        this.taken = true;
        this.notify();
    }

    public synchronized void release() throws InterruptedException {
        while (!this.taken) wait();
        this.taken = false;
    }
}
