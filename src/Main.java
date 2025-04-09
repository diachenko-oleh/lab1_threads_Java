
public class Main {

    public static void main(String[] args) {
        BreakThread breakThread = new BreakThread();
        int threadsAmount = 2;                           //<---кількість потоків
        MyThread[] threads = new MyThread[threadsAmount];
        for (int i = 0; i < threads.length; i++)
        {
            new MyThread(i, breakThread).start();
        }
        new Thread(breakThread).start();
    }
}