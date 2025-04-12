import java.util.Arrays;

public class BreakThread implements Runnable {
    private boolean[] canBreak;
    private final int[] stopTime;
    private final Thread[] threads;
    private int mainTime;
    private int currentTime = 0;

    public BreakThread(boolean[] canBreak, int[] stopTime, Thread[] threads) {
        this.canBreak = canBreak;
        this.stopTime = stopTime;
        this.threads = threads;
        this.mainTime = Arrays.stream(stopTime).max().getAsInt() * 1000;
    }

    @Override
    public void run() {
        while (currentTime <= mainTime) {

            for (int i = 0; i < threads.length; i++) {
                if (currentTime >= stopTime[i]) {
                    canBreak[i] = true;
                    threads[i].interrupt();
                }
            }

            boolean allTrue = true;
            for (boolean isWorking : canBreak) {
                if (!isWorking) {
                    allTrue = false;
                    break;
                }
            }
            if (allTrue) {
                break;
            }

            try {
                Thread.sleep(1000);
                currentTime += 1000;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
