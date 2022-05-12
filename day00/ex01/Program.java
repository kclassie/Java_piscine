import java.util.Scanner;

public class Program {

    public static void  checkValue(int val) {

        if (val <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {

        int numOfIter = 1;
        int i = 0;

        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        checkValue(num);

        if (num % 2 == 0) {
            System.out.printf("false %d\n", 1);
            System.exit(0);
        }
        for (i = 3; i * i <= num && num % i != 0; i += 2) {
            numOfIter++;
        }
        if (i * i > num) {
            System.out.printf("true %d\n", numOfIter);
        } else {
            System.out.printf("false %d\n", numOfIter);
        }
        in.close();
        System.exit(0);
    }
}