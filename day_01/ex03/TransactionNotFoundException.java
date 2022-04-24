package ex03;

class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException(String message) {

        System.out.println(message);
    }
}