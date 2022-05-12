package ex02;

class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){

        System.out.println(message);
    }
}
