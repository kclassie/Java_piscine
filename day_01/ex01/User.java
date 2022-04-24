package ex01;

public class User {

    private Integer identifier;
    private String name;
    private Integer balance;

    public User(String name, Integer balance) {

        this.identifier = UserIdsGenerator.getInstance().generateId();
        this.name = name;

        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.printf("User %s: Not valid balance value.\n", this.name);
        }
    }

    public String getName() {

        return (name);
    }

    public Integer getIdentifier() {

        return (identifier);
    }

    public Integer getBalance() {

        return (balance);
    }
}