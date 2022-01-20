public class Transaction {
    private int transactionNum;
    private int accNum1;
    private int accNum2;
    private float qty;

    public Transaction(int transactionNum, int accNum1, int accNum2, float qty) {
        this.transactionNum = transactionNum;
        this.accNum1 = accNum1;
        this.accNum2 = accNum2;
        this.qty = qty;
    }

    public int getAccNum1() {
        return accNum1;
    }

    public int getAccNum2() {
        return accNum2;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionNum=" + transactionNum +
                ", Sending Account=" + accNum1 +
                ", Receiver Account=" + accNum2 +
                ", Quantity=" + qty +
                '}';
    }
}
