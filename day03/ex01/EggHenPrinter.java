public class EggHenPrinter {

    private final int count;
    private boolean flag;

    public EggHenPrinter(int count) {
        this.count = count;
        flag = false;
    }

    public synchronized void printEgg() {
        for (int i = 0; i < count; ++i) {
            while (flag) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("Egg");
            flag = true;
            notify();
        }
    }

    public synchronized void printHen() {
        for (int i = 0; i < count; ++i) {
            while (!flag) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("Hen");
            flag = false;
            notify();
        }
    }

}
