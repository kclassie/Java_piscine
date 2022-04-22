package ex01;

public class UserIdsGenerator {

    private static Integer uniqueID = 0;
    private static final UserIdsGenerator instance = new UserIdsGenerator();

    private UserIdsGenerator(){
    }

    public Integer generateId() {

        return (this.uniqueID++);
    }

    public static UserIdsGenerator getInstance(){
        return (instance);
    }
}