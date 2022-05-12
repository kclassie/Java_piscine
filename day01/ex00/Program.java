package ex00;

public class Program {

    public static void main(String[] args) {

        User john = new User("John", 0);
        User petya = new User("Petya", 1000000000);
        User vasya = new User("Vasya", -1000000);

        System.out.printf("User %s has id %d and his balance %d.\n", john.getName(), john.getIdentifier(), john.getBalance());
        System.out.printf("User %s has id %d and his balance %d.\n", petya.getName(), petya.getIdentifier(), petya.getBalance());
        System.out.printf("User %s has id %d and his balance %d.\n", vasya.getName(), vasya.getIdentifier(), vasya.getBalance());

        Transaction one = new Transaction(john, petya, "INCOME", 1000);
        User sender = one.getSender();
        User recipient = one.getRecipient();
        System.out.printf("User %s -> User %s, %d, %s, %s\n", sender.getName(),
                recipient.getName(), one.getTransferAmount(),  one.getTransfer(), one.getIdentifier());
        Transaction two = new Transaction(john, petya, "fff", 1000);
        Transaction three = new Transaction(john, petya, "INCOME", -1);
    }
}