public class MyThread extends Thread{
    private final int id;
    private final BreakThread breakThread;

    public MyThread(int id, BreakThread breakThread){
    this.id = id;
    this.breakThread = breakThread;
    }
    @Override
    public void run(){
        int step = 2;                                           //<---крок
        long sum = 0;
        long curr = 0;
        long components = 0;                                    //<---кількість елементів послідовності
        boolean isStop = false;

        do{
            sum += curr;
            curr += step;
            components++;
            isStop = breakThread.isCanBreak();
        }while (!isStop);
        PrintResult(sum,components);
    }

    public void PrintResult(long sum, long comp){
        System.out.println("------" + Thread.currentThread().getName() + "------" +
                "\nid: " + id +
                "\nсума: " + sum +
                "\nкiлькiсть доданкiв: " + comp);

    }

}
