package streams.entities;

import java.util.Objects;

public class Transaction {
    private double amount;
    private String receiverName;
    private String senderName;
    private boolean isSuccess;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public boolean getSuccessStatus() {
        return isSuccess;
    }

    public void setSuccessStatus(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Transaction(double amount, String receiverName, String senderName, boolean isSuccess) {
        this.amount = amount;
        this.receiverName = receiverName;
        this.senderName = senderName;
        this.isSuccess = isSuccess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(amount, that.amount) == 0 && isSuccess == that.isSuccess && Objects.equals(receiverName, that.receiverName) && Objects.equals(senderName, that.senderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, receiverName, senderName, isSuccess);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", receiverName='" + receiverName + '\'' +
                ", senderName='" + senderName + '\'' +
                ", isSuccess=" + isSuccess +
                '}';
    }
}
