
public class Program{

    public static int count;

    public static void main(String[] args) throws NotValidArgumentException {

        if (args.length != 1 || !args[0].startsWith("--count=")) {
            throw new NotValidArgumentException();
        }

        try {
            count = Integer.parseInt(args[0].substring(8));
        } catch (Exception e) {
            throw new NotValidArgumentException();
        }

        EggHenPrinter printer = new EggHenPrinter(count);
        Thread egg = new Thread(new Runnable() {
            @Override
            public void run() {

                printer.printEgg();
            }
        });

        Thread hen = new Thread(new Runnable() {
            @Override
            public void run() {

                printer.printHen();
            }
        });

        egg.start();
        hen.start();
    }
}

class NotValidArgumentException extends RuntimeException{

    public NotValidArgumentException(){

        System.out.println("Not valid argument");
    }
}
