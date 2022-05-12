package ex03;
import java.util.UUID;

public class Transaction {

    private String identifier;
    private User recipient;
    private User sender;
    private String transfer;
    private Integer transferAmount;

    public Transaction(User recipient, User sender, String transfer, Integer transferAmount) {

        this.identifier = UUID.randomUUID().toString();
        this.recipient = recipient;
        this.sender = sender;

        if (!transfer.equals("OUTCOME") && !transfer.equals("INCOME")) {
            System.out.println("Not valid transfer value");
            return ;
        } else {
            this.transfer = transfer;
        }

        if (transfer.equals("OUTCOME") && transferAmount < 0) {
            this.transferAmount = transferAmount;
        } else if (transfer.equals("INCOME") && transferAmount > 0) {
            this.transferAmount = transferAmount;
        } else {
            System.out.println("Not valid transferAmount");
            return ;
        }
    }

    public String getIdentifier() {

        return identifier;
    }

    public User getRecipient() {

        return recipient;
   }

    public User getSender() {

        return sender;
    }

    public String getTransfer() {

        return transfer;
    }

    public Integer getTransferAmount() {

        return transferAmount;
    }

}