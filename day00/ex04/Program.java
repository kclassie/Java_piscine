import java.util.Scanner;

public class Program {

    private static char[] findCharPlace(char[] base, char ch, int index) {

        char[] resultArray = new char[10];

        for (int i = 0; i < index; i++) {
            resultArray[i] = base[i];
        }

        resultArray[index] = ch;

        for (int i = index + 1; i < 10; i++) {
            resultArray[i] = base[i - 1];
        }

        return (resultArray);
    }

    public static char[] findTenMax(int[] intArray) {

        char[] sortedTen = new char[10];

        for (int i = 0; i < 65535; i++) {
            int charCount = intArray[i];
            if (charCount > 0) {
                for (int j = 0; j < 10; j++) {
                    if (intArray[sortedTen[j]] < charCount) {
                        sortedTen = findCharPlace(sortedTen, (char)i, j);
                        break ;
                    }
                }
            }
        }
        return (sortedTen);
    }

    public static void outputHistogram(char[] sotredTen, int[] countOfchar) {

        int max = countOfchar[sotredTen[0]];
        int maxHeight = max <= 10 ? max : 10;
        int totalLines = 2 + maxHeight;
        int[] histogram = new int[10];

        for (int i = 0; i < 10; i++) {
            if (max <= 10) {
                histogram[i] = countOfchar[sotredTen[i]];
            } else {
                histogram[i] = (countOfchar[sotredTen[i]] * 10 / max);
            }
        }
        System.out.println();
        for (int i = 0; i < totalLines; i++) {
            for (int j = 0; j < 10; j++) {
                if (sotredTen[j] != 0) {
                    if (i + histogram[j] + 2 == totalLines) {
                        System.out.printf("%3d", countOfchar[sotredTen[j]]);
                    } else if (i == totalLines - 1) {
                        System.out.printf("%3c", sotredTen[j]);
                    } else if (i + histogram[j] >= maxHeight) {
                        System.out.printf("%3c", '#');
                    }
                    if (j != 10 - 1 && sotredTen[j + 1] != 0 && i + histogram[j + 1] >= maxHeight) {
                        System.out.printf("%c", ' ');
                    }
                }
            }
            System.out.println();
        }
    }

    private static int[] countChars(String str) {

        int[]   resultArray = new int[65535];
        char[]  arrayOfChars = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            resultArray[arrayOfChars[i]]++;
        }
        return (resultArray);
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int[]   countOfChar = countChars(str);
        char[]  sortedTen = findTenMax(countOfChar);
        outputHistogram(sortedTen, countOfChar);
        in.close();
        System.exit(0);
    }
}
