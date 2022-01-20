public class Client {
    private String clientName;
    private int clientNumber;

    public Client(String clientName, int clientNumber) {
        this.clientName = clientName;
        this.clientNumber = clientNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientName='" + clientName + '\'' +
                ", clientNumber=" + clientNumber +
                '}';
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }
}
