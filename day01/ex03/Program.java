package ex03;

public class Program {

    public static void main(String[] args) {

        User john = new User("John", 0);
        User petya = new User("Petya", 1000000000);
        User vasya = new User("Vasya", -1000000);

        Transaction tr1 = new Transaction(petya, john, "OUTCOME", 100);
        Transaction tr2 = new Transaction(petya, vasya, "OUTCOME", 100);
        Transaction tr3 = new Transaction(petya, john, "OUTCOME", 100);
        Transaction tr4 = new Transaction(petya, vasya, "OUTCOME", 100);

        TransactionsLinkedList trlist = new TransactionsLinkedList();
        System.out.println("empty list size is : " + trlist.countListLen());

        trlist.addTransaction(tr1);
        trlist.addTransaction(tr2);
        trlist.addTransaction(tr3);
        trlist.addTransaction(tr4);

        System.out.println("full(after add trs) list size is : " + trlist.countListLen());
        trlist.removeTransaction(tr1.getIdentifier());
        System.out.println("(after delete one tr) list size is : " + trlist.countListLen());

        Transaction[] arr = trlist.toArray();
        for (int i = 0; i < trlist.countListLen(); i++)
            System.out.printf("Transaction %d ID: %s\n", i, arr[i].getIdentifier());

    }
}