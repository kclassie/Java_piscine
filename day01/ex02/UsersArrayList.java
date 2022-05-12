package ex02;

public class UsersArrayList implements UsersList {

    public Integer arrayIndex = 0;
    public Integer arrayLen = 10;
    private User[] usersList;

    public UsersArrayList(){

        this.usersList = new User[arrayLen];
    }

    private User[] updateArray(User[] usersList) {

        User newArray[] = new User[arrayLen + arrayLen / 2];

        for (int i = 0; i < arrayLen; i++) {
            newArray[i] = usersList[i];
        }

        arrayLen += arrayLen / 2;
        return (newArray);
    }

    public void addUserToList(User newUser) {

        if (arrayIndex + 1 == 10) {
            usersList = updateArray(usersList);
        }

        usersList[arrayIndex] = newUser;
        arrayIndex++;
    }

    public User retrieveUserById(Integer id) throws UserNotFoundException{

        for (int i = 0; i < arrayIndex; i++){
            if (usersList[i].getIdentifier().equals(id)) {
                return (usersList[i]);
            }
        }

        throw new UserNotFoundException("User not found");
    }

    public User retrieveUserByIndex(Integer index) throws UserNotFoundException{

        if (index >= arrayIndex) {
            throw  new UserNotFoundException("User not found");
        }

        return (usersList[index]);
    }

    public Integer retrieveNumberOfUsers() {

        return (arrayIndex);
    }

}
