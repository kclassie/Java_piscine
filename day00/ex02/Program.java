import java.util.Scanner;

public class Program {

    public static int findSumOfNum(int num)
    {
        int result = 0;

        while (num > 0) {
            result += num % 10;
            num /= 10;
        }

        return (result);
    }

    public static boolean isPrime(int num)
    {
        int i = 0;

        if (num % 2 == 0) {
            return (false);
        }

        for (i = 3; i * i <= num && num % i != 0; i += 2) {
            ;
        }

        if (i * i > num) {
            return (true);
        } else {
            return (false);
        }
    }

    public static void main(String[] args) {

        int countOfPrime = 0;
        int num = 0;
        int sumOfNum = 0;

        Scanner in = new Scanner(System.in);

        while (num != 42) {
            num = in.nextInt();
            sumOfNum = findSumOfNum(num);
            if (isPrime(sumOfNum)) {
                countOfPrime++;
            }
        }
        System.out.printf("Count of coffee - request - %d\n", countOfPrime);
        in.close();
        System.exit(0);
    }
}