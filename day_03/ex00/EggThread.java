public class EggThread implements Runnable {

    int count;

    public EggThread(int count) {

        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.count; i++) {
            System.out.println("Egg");
        }
    }
}
