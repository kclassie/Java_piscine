package ex03;

public interface TransactionsList {

    public void addTransaction(Transaction newTransaction);
    public void removeTransaction(String transactionId);
    public Transaction[] toArray();
}