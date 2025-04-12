public class MyThread extends Thread{
    private final int id;
    private final int time;

    public MyThread(int id, int time){
    this.id = id;
    this.time = time;
    }
    @Override
    public void run() {
        int step = 1;
        long sum = 0;
        long curr = 0;
        long components = 0;

        try {
            while (true) {
                if (Thread.interrupted()) {
                    break;
                }
                sum += curr;
                curr += step;
                components++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintResult(sum, components, time);
    }

    public void PrintResult(long sum, long comp ,int time){
        System.out.println("------" + Thread.currentThread().getName() + "------" +
                "\nid: " + id +
                "\nсума: " + sum +
                "\nкiлькiсть доданкiв: " + comp +
                "\nчас роботи: " + time/1000 + " ceкунд");

    }

}
