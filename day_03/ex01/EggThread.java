public class EggThread implements Runnable {

    int count;
    OutputMessage output;

    public EggThread(int count, OutputMessage output) {

        this.count = count;
        this.output = output;
    }

    @Override
    public void run() {
        synchronized (output) {
            output.outputEgg();
            output.notify();
        }
    }
}

