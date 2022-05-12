import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;

public class Program {

    private static int arraySize;
    private static int threadsCount;
    private static final int MAX_RANDOM_NUM = 1000;
    private static final int MAX_ARRAY_SIZE = 2000000;
    private static List<Integer> array;

    public static void main(String[] args) throws NotValidArgumentException {

        parseArgs(args);
        array = makeRandomIntArray();
        outputSumOfArray();
        runThreads();
        System.out.printf("Sum by threads: %d\n", ThreadCounter.totalSum);
    }

    private static boolean isValidArgs() {

       return (arraySize <= MAX_ARRAY_SIZE && threadsCount <= arraySize);
    }

    private static void parseArgs(String[] args) {

        if (args.length != 2 || !args[0].startsWith("--arraySize=") || !args[1].startsWith("--threadsCount=")) {
            throw new NotValidArgumentException();
        }

        try {
            arraySize = Integer.parseInt(args[0].substring(12));
            threadsCount = Integer.parseInt(args[1].substring(15));
        } catch (Exception e) {
            throw new NotValidArgumentException();
        }
        if (!isValidArgs()) {
            throw new NotValidArgumentException();
        }
    }

    private static List<Integer> makeRandomIntArray() {

        List<Integer> array = new ArrayList<>(arraySize);

        for (int i = 0; i < arraySize; i++) {
            array.add(ThreadLocalRandom.current().nextInt(-(MAX_RANDOM_NUM), MAX_RANDOM_NUM + 1));
        }
        return (array);
    }

    private static void outputSumOfArray()
    {
        long sum = 0;

        for (int i = 0; i < arraySize; i++)
            sum += array.get(i);

        System.out.printf("Sum: %d\n", sum);
    }

    public static List<Integer> getArray() {

        return (array);
    }

    private static void runThreads() {

        int start = 0;
        int end = 0;
        int sectionLen = arraySize / (threadsCount - 1);
        for (int i = 1; i <= threadsCount; i++) {
            if (threadsCount != 1) {
                end += sectionLen;
            } else {
                end = arraySize - 1;
            }
            ThreadCounter counter = new ThreadCounter();
            counter.ThreadCounter(i, start, end - 1);
            Thread tCounter = new Thread(new Runnable() {

                @Override
                public void run() {

                    counter.countSum();
                    ThreadCounter.flag = false;
                }
            });
            tCounter.start();
            try {
                tCounter.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            start += sectionLen;
        }

    }

}

class NotValidArgumentException extends RuntimeException{

    public NotValidArgumentException(){

        System.out.println("Not valid argument");
    }
}
