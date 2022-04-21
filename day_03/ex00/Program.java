public class Program{

    public static int count;

    public static void main(String[] args) throws NotValidArgumentException {

        if (args.length != 1 || !args[0].startsWith("--count=")) {
            throw new NotValidArgumentException();
        }

        count = Integer.parseInt(args[0].substring(8));

        Runnable eggR  = new EggThread(count);
        Runnable henR  = new HenThread(count);
        Thread egg = new Thread(eggR);
        Thread hen = new Thread(henR);

        egg.start();
        hen.start();

        try {
            egg.join();
            hen.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < count; i++)
            System.out.println("Human");
    }
}

class NotValidArgumentException extends RuntimeException{

    public NotValidArgumentException(){

        System.out.println("Not valid argument");
    }
}

