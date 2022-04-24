import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;

public class ThreadDownloader {

    public static int currentUrl;
    private static List<String> urlsList = Program.getUrlsList();;

    public static synchronized String getNextUrl(int urlNum) {
        String url;
        currentUrl = urlNum;
        if ((url = urlsList.get(currentUrl)) != null && currentUrl < 10) {
            currentUrl++;
            return (url);
        }
        return (null);
    }

    public static void downloadImage(String url) {

        try {
            URL link = new URL(url);
            Path file = Paths.get(url);
            if (Files.exists(file.getFileName())) {
                System.out.println("File " + file.getFileName() + " already exist");
                return;
            }
            int fileNum;
            synchronized (ThreadDownloader.class) {
                fileNum = currentUrl;
            }
            System.out.printf("%s start download file number %d\n", Thread.currentThread().getName(), fileNum);
            InputStream input = link.openStream();
            Files.copy(input, file.getFileName());
            System.out.printf("%s finish download file number %d\n", Thread.currentThread().getName(), fileNum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
