import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class mainClass {
    public static void main(String[] args) {
        int op = 99;
        List<Client> clientes = new ArrayList<Client>();
        List<Account> accounts = new ArrayList<Account>();
        List<Transaction> transactions = new ArrayList<Transaction>();

        String options = "1) Add client\n" +
                "2) Add account to client\n" +
                "3) Make a transaction\n" +
                "4) See all clients\n" +
                "5) See accounts of client\n" +
                "6) See transactions of account\n" +
                "7) Exit";
        while (op!=7){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(options);
            System.out.println("Enter a number: ");
            try {
                String opStr = reader.readLine();
                op = Integer.parseInt(opStr);
            } catch (Exception e) {
                op = 8;
            }

            if(op > 7 || op < 1) {
                System.out.println("Enter a valid number");
            } else {
                if (op == 1) {
                    try {
                        System.out.println("Enter the name:");
                        String name = reader.readLine();
                        Client cliente = new Client(name, clientes.size());
                        clientes.add(cliente);
                        System.out.println("New Client:");
                        System.out.println(cliente);
                    } catch (Exception e){
                        System.out.println("Enter a valid input");
                    }
                }
                if (op == 2) {
                    try {
                        System.out.println("Enter the client number:");
                        String clientNum = reader.readLine();
                        System.out.println("What kind of account:\n" +
                                "1) Saving Account\n" +
                                "2) Current Account\n" +
                                "3) Mortgage Account\n");
                        String accType = reader.readLine();
                        if (Objects.equals(accType, "1")) {
                            System.out.println("Enter money: ");
                            String money = reader.readLine();
                            Account cuenta = new SavingAccount(accounts.size(), Integer.parseInt(clientNum), 0.2f, Float.parseFloat(money));
                            accounts.add(cuenta);
                        }
                        if (Objects.equals(accType, "2")) {
                            System.out.println("Enter money: ");
                            String money = reader.readLine();
                            Account cuenta = new CurrentAccount(accounts.size(), Integer.parseInt(clientNum), Float.parseFloat(money));
                            accounts.add(cuenta);
                        }
                        if (Objects.equals(accType, "3")) {
                            System.out.println("Enter debt: ");
                            String money = reader.readLine();
                            Account cuenta = new MortgageAccount(accounts.size(), Integer.parseInt(clientNum), Float.parseFloat(money), 500, 0.2f);
                            accounts.add(cuenta);
                        } else {
                            System.out.println("Enter a valid number");
                        }
                    } catch (Exception e){
                        System.out.println("Enter a valid input");
                    }
                }
                if (op == 3) {
                    try {
                        System.out.println("What kind of transaction:\n" +
                                "1) Add money to Saving Account\n" +
                                "2) Send Money to Current Account\n" +
                                "3) Pay Mortgage Account\n");
                        String accType = reader.readLine();
                        if (Objects.equals(accType, "1")) {
                            System.out.println("Account number: ");
                            String sender = reader.readLine();
                            System.out.println("Quantity of money: ");
                            String money = reader.readLine();
                            int cuenta1 = -1;
                            for (Account cuenta : accounts) {
                                if (cuenta.getAccountNumber() == Integer.parseInt(sender) && cuenta.getAccountType().equals("Saving")){
                                    cuenta1 = cuenta.getAccountNumber();
                                }
                            }
                            if (cuenta1 == -1){
                                System.out.println("Account number is wrong");
                            } else {
                                Transaction transaction = new Transaction(transactions.size(), cuenta1, cuenta1, Float.parseFloat(money));
                                transactions.add(transaction);
                                SavingAccount acc1 = (SavingAccount) accounts.get(cuenta1);
                                System.out.println("Savings before transaction: " + acc1.getMoney());
                                acc1.addMoney(Float.parseFloat(money));
                                System.out.println("Savings after transaction: " + acc1.getMoney());
                                System.out.println(transaction);
                            }
                        }
                        if (Objects.equals(accType, "2")) {
                            System.out.println("Account that sends: ");
                            String sender = reader.readLine();
                            System.out.println("Account that receives: ");
                            String receives = reader.readLine();
                            System.out.println("Quantity of money: ");
                            String money = reader.readLine();
                            int cuenta1 = -1;
                            int cuenta2 = -1;
                            for (Account cuenta : accounts) {
                                if (cuenta.getAccountNumber() == Integer.parseInt(sender) && cuenta.getAccountType().equals("Current")){
                                    cuenta1 = cuenta.getAccountNumber();
                                }
                                if (cuenta.getAccountNumber() == Integer.parseInt(receives) && cuenta.getAccountType().equals("Current")){
                                    cuenta2 = cuenta.getAccountNumber();
                                }
                            }
                            if (cuenta1 == -1 || cuenta2 == -1){
                                System.out.println("One of the two accounts is wrong");
                            } else {
                                Transaction transaction = new Transaction(transactions.size(), cuenta1, cuenta2, Float.parseFloat(money));
                                transactions.add(transaction);
                                CurrentAccount acc1 = (CurrentAccount) accounts.get(cuenta1);
                                CurrentAccount acc2 = (CurrentAccount) accounts.get(cuenta2);
                                acc1.takeMoney(Float.parseFloat(money));
                                acc2.addMoney(Float.parseFloat(money));
                                System.out.println(transaction);
                            }
                        }
                        if (Objects.equals(accType, "3")) {
                            System.out.println("Account number: ");
                            String sender = reader.readLine();
                            int cuenta1 = -1;
                            for (Account cuenta : accounts) {
                                if (cuenta.getAccountNumber() == Integer.parseInt(sender) && cuenta.getAccountType().equals("Mortgage")){
                                    cuenta1 = cuenta.getAccountNumber();
                                }
                            }
                            if (cuenta1 == -1){
                                System.out.println("Account number is wrong");
                            } else {
                                Transaction transaction = new Transaction(transactions.size(), cuenta1, cuenta1, 500);
                                transactions.add(transaction);
                                MortgageAccount acc1 = (MortgageAccount) accounts.get(cuenta1);
                                System.out.println("Debt before payment: " + acc1.getDebt());
                                acc1.payDebt();
                                System.out.println("Debt after payment: " + acc1.getDebt());
                                System.out.println(transaction);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("try again");
                    }
                }
                if (op == 4) {
                    for(Client cliente : clientes){
                        System.out.println(cliente.toString());
                    }
                }

                if (op == 5) {
                    String clientNum="0";
                    try {
                        System.out.println("Enter the client number:");
                        clientNum = reader.readLine();
                    } catch (Exception e) {
                        System.out.println("Enter a valid number");
                    }
                    for(Account cuenta : accounts){
                        if (cuenta.getClientNum() == Integer.parseInt(clientNum)){
                            System.out.println(cuenta.toString());
                        }
                    }
                }
                if (op == 6) {
                    String clientNum="0";
                    try {
                        System.out.println("Enter the account number:");
                        clientNum = reader.readLine();
                    } catch (Exception e) {
                        System.out.println("Enter a valid number");
                    }
                    for(Transaction transaction : transactions){
                        if (transaction.getAccNum1() == Integer.parseInt(clientNum) || transaction.getAccNum2()  == Integer.parseInt(clientNum)){
                            System.out.println(transaction);
                        }
                    }
                }
                if (op == 7) {
                    break;
                }
            }
        }
    }
}
