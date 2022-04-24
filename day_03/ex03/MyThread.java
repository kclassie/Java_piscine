
public class MyThread extends Thread {

    @Override
    public void run() {
        String urlToDown;
        int currentUrl = 0;

        while ((urlToDown = ThreadDownloader.getNextUrl(currentUrl)) != null && currentUrl < 10) {
            ThreadDownloader.downloadImage(urlToDown);
            currentUrl++;
        }
    }
}
