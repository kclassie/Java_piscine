import java.util.Scanner;

public class Program {

    public static void outputError() {

        System.out.println("IllegalArgument");
        System.exit(-1);
    }

    public static int getNumOfWeek(int numOfWeek, int tmpNumOfWeek) {

        int maxNumOfWeeks = 18;

        if (tmpNumOfWeek != numOfWeek + 1 || tmpNumOfWeek > maxNumOfWeeks) {
            outputError();
        }
        return (tmpNumOfWeek);
    }

    public static void checkScore(long newScore) {

        long minScore = 1;
        long maxScore = 9;

        if (newScore < minScore || newScore > maxScore) {
            outputError();
        }
    }

    public static long makeScoreStore(long scoreStore,  long score, int numOfWeek) {

        if (numOfWeek == 1)
            return (score);
        for (int i = 1; i < numOfWeek; i++) {
            score *= 10;
        }
        scoreStore += score;
        return (scoreStore);
    }

    public static void outputRating(long scoreStore)
    {
        int numOfWeek = 1;
        long tmpScore;

        for (long i = scoreStore; i > 0; i /= 10) {
            tmpScore = i % 10;
            System.out.print("Week ");
            System.out.print(numOfWeek);
            System.out.print(" ");
            for (long j = tmpScore; j > 0; j--){
                System.out.print("=");
            }
            System.out.println(">");
            numOfWeek++;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String inputMessage;
        int numOfWeek = 0;
        long scoreStore = 0;

        inputMessage = in.next();
        while (true) {
            if (inputMessage.equals("42")) {
                break;
            }
            if (inputMessage.equals("Week")) {
                numOfWeek = getNumOfWeek(numOfWeek, in.nextInt());
                long score = 9;
                for (int i = 0; i < 5; i++) {
                    long newScore = in.nextInt();
                    checkScore(newScore);
                    if (newScore < score) {
                        score = newScore;
                    }
                }
                scoreStore = makeScoreStore(scoreStore, score, numOfWeek);
            }
            else
                outputError();
            inputMessage = in.next();
        }
        outputRating(scoreStore);
        in.close();
        System.exit(0);
    }
}