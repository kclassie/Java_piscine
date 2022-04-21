package ex02;

public class Program {

    public static void main(String[] args){

        UsersArrayList userList = new UsersArrayList();

        User john = new User("John", 0);
        User petya = new User("Petya", 1000000000);
        User vasya = new User("Vasya", -1000000);

        userList.addUserToList(john);
        userList.addUserToList(petya);
        userList.addUserToList(vasya);
        userList.addUserToList(john);
        userList.addUserToList(petya);
        userList.addUserToList(vasya);
        userList.addUserToList(john);
        userList.addUserToList(petya);
        userList.addUserToList(vasya);
        userList.addUserToList(john);
        userList.addUserToList(petya);
        userList.addUserToList(vasya);

        System.out.printf("User 1: %s\nUser 2: %s\nUser 3: %s\n", userList.retrieveUserByIndex(0).getName(), userList.retrieveUserByIndex(1).getName(), userList.retrieveUserByIndex(2).getName());
        System.out.printf("Count of users: %d\n", userList.retrieveNumberOfUsers());
        System.out.printf("User by index: %s\n", userList.retrieveUserByIndex(11).getName());
        System.out.printf("User by ID: %s\n", userList.retrieveUserById(1).getName());
    }
}