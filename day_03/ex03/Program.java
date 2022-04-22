import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static int threadsCount;
    private static List<String> urlsList;
    public static int urlsNum;
    public final static String FILE_PATH = "files_urls.txt";

    public static void main(String[] args) {

        urlsList = new ArrayList<>();
        if (args.length != 1 || !args[0].startsWith("--threadsCount=")) {
            throw new NotValidArgumentException();
        }

        try {
            threadsCount = Integer.parseInt(args[0].substring(15));
        } catch (Exception e) {
            throw new NotValidArgumentException();
        }
        readImgUrls();
        for (int i = 0 ; i < threadsCount; i++)
            new MyThread().start();
    }

    private static void readImgUrls() {

        try {
            File file = new File(FILE_PATH);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                urlsList.add(line);
                urlsNum++;
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getUrlsList() {
        return (urlsList);
    }
}

class NotValidArgumentException extends RuntimeException{

    public NotValidArgumentException(){

        System.out.println("Not valid argument");
    }
}
