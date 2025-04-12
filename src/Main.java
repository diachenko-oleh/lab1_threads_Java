import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введiть кiлькiсть потокiв: ");
        int threadsAmount = Integer.parseInt(scanner.nextLine());
        MyThread[] threads = new MyThread[threadsAmount];
        int[] timer = new int[threadsAmount];
        boolean[] canStop = new boolean[threadsAmount];
        System.out.println("Введiть час роботи для " + threadsAmount +" потокiв: ");
        String[] times = scanner.nextLine().trim().split("\\s+");

        for (int i = 0; i < threadsAmount; i++) {
            canStop[i] = false;
            timer[i] = Integer.parseInt(times[i])*1000;
            threads[i] = new MyThread(i,timer[i]);
            threads[i].start();
        }

        BreakThread breakThread = new BreakThread(canStop, timer, threads);
        new Thread(breakThread).start();
        scanner.close();
    }
}
