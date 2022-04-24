public class HenThread implements Runnable {

    int count;
    OutputMessage output;

    public HenThread(int count, OutputMessage output) {

        this.count = count;
        this.output = output;
    }

    @Override
    public void run() {
        synchronized (output) {
//            for (int i = 0; i < this.count; i++) {
                try {
                    output.wait();
                    output.outputHen();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            }
        }
    }
}
