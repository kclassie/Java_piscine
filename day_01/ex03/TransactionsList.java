package ex03;

public interface TransactionsList extends RuntimeException{

    public void addTransaction(Transaction newTransaction);
    public void removeTransaction(String transactionId);
    public Transaction[] toArray();
}