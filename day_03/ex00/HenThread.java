public class HenThread implements Runnable {

    int count;

    public HenThread(int count) {

        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.count; i++) {
            System.out.println("Hen");
        }
    }
}
