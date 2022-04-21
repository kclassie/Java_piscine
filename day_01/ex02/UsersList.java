package ex02;

interface UsersList {

    public void addUserToList(User newUser);
    public User retrieveUserByIndex(Integer index);
    public Integer retrieveNumberOfUsers();

}