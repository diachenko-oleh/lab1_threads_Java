import java.nio.channels.ScatteringByteChannel;

public class BreakThread implements Runnable{
    private boolean canBreak = false;
    @Override
    public void run(){
        try {
            Thread.sleep(30*1000);
        } catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }
        canBreak = true;
    }
    synchronized public boolean isCanBreak() {
        return canBreak;
    }

}
