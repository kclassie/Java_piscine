package ex03;

public class TransactionsLinkedList {

    private TransactionNode first =  null;
    private TransactionNode last = null;

    public TransactionsLinkedList() {
        first = null;
        last = null;
    }

    public void addTransaction(Transaction newTransaction) {
        TransactionNode tNode = new TransactionNode(newTransaction);
        if (isEmpty()) {
            last = tNode;
        } else {
            first.previous = tNode;
        }
        tNode.next = first;
        first = tNode;
        System.out.println("Transaction added successfully");
    }

    public void removeTransaction(String transactionId) throws TransactionNotFoundException {
        if (isEmpty()) {
            throw new TransactionNotFoundException("Transaction list is empty");
        }
        if (first != null && first.transaction.getIdentifier().equals(transactionId)) {
            first = deleteFirst();
            outputDelMessage(transactionId);
            return ;
        }
        if (last != null && last.transaction.getIdentifier().equals(transactionId)) {
            last = deleteLast();
            outputDelMessage(transactionId);
            return ;
        }
        TransactionNode current = first;
        while (!current.transaction.getIdentifier().equals(transactionId)) {
            if (current.next == null) {
                throw new TransactionNotFoundException("Transaction not found");
            }
            current = current.next;
        }
        current.previous.next = current.next;
        outputDelMessage(transactionId);
    }

    public Transaction[] toArray() throws TransactionNotFoundException {

        if (isEmpty()) {
            throw new TransactionNotFoundException("Transaction list is empty");
        }

        Transaction[] transactionArray = new Transaction[countListLen()];
        TransactionNode current = first;
        Integer index = 0;

        while (current.next != null) {
            transactionArray[index] = current.transaction;
            current = current.next;
            index++;
        }
        transactionArray[index++] = current.transaction;
        return (transactionArray);
    }

    public TransactionNode deleteFirst() {
        TransactionNode tmp = first;
        if (first.next == null) {
            last =null;
        } else {
            first.next.previous = null;
        }
        first = tmp.next;
        return (tmp);
    }

    public TransactionNode deleteLast() {
        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }
        last = last.previous;
        return (last);
    }

    public Integer countListLen() {

        TransactionNode current = first;
        Integer count = 0;

        if (isEmpty()) {
            return (0);
        }

        while (current.next != null) {
            count++;
            current = current.next;
        }
        return (count + 1);
    }

    public void outputDelMessage(String transactionId) {

        System.out.printf("Transaction %s deleted successfully\n", transactionId);
    }

    public boolean isEmpty() {
        return (first == null);
    }
}

class TransactionNode {

    public Transaction transaction;
    public TransactionNode next;
    public TransactionNode previous;

    public TransactionNode(Transaction transaction) {
        this.transaction = transaction;
    }

    public void display() {
        System.out.println(transaction.getIdentifier());
    }
}