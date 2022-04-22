package ex02;

public interface UsersList {

    public void addUserToList(User newUser);
    public User retrieveUserByIndex(Integer index);
    public Integer retrieveNumberOfUsers();

}