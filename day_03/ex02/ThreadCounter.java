import java.util.List;

public class ThreadCounter {

    private int start;
    private int end;
    private int threadNum;
    private static List<Integer> array;
    public static long totalSum = 0;
    public static boolean flag;

    public void ThreadCounter(int threadNum, int start, int end) {
        this.start = start;
        this.end = end;
        this.threadNum = threadNum;
        array = Program.getArray();
    }

    public synchronized void countSum() {
        long sum = 0;
        while (flag) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        for (int i = start; i <= end; i++) {
            try {
                sum += array.get(i);
            } catch (Exception e) {
                break ;
            }
        }
        flag = true;
        System.out.printf("Thread %d: from %d to %d sum is %d\n", threadNum, start, end, sum);
        totalSum += sum;
    }
}
