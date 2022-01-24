package com.java;

import com.java.dao.AccountDAO;
import com.java.dao.ClientDAO;
import com.java.dao.TransactionDAO;
import com.java.objects.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class CustomerService {

    public static void main(String[] args) throws IOException {
        int op = 99;
        ClientDAO clientDAO = new ClientDAO();
        AccountDAO accountDAO = new AccountDAO();
        TransactionDAO transactionDAO = new TransactionDAO();
        Client clientActual = new Client("",-1, "");
        boolean login = false;
        String options1 = "1) Register client\n" +
                "2) Login\n" +
                "3) Exit";

        while (op!=3){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(options1);
            System.out.println("Enter a number: ");

            try {
                String opStr = reader.readLine();
                op = Integer.parseInt(opStr);
            } catch (Exception e) {
                op = 4;
            }
            if(op > 7 || op < 1) {
                System.out.println("Enter a valid number");
            } else {
                if (op == 1) {
                    try {
                        System.out.println("Enter the name:");
                        String name = reader.readLine();
                        System.out.println("Enter the email:");
                        String email = reader.readLine();
                        Client cliente = new Client(name, clientDAO.getSize(), email);
                        clientDAO.addClient(cliente);
                        System.out.println("New Client:");
                        System.out.println(cliente);
                    } catch (Exception e){
                        System.out.println("Enter a valid input");
                    }
                }
                if (op == 2){
                    System.out.println("Enter the email:");
                    String email = reader.readLine();
                    if(clientDAO.findClient(email)){
                        clientActual.setEmail(email);
                        clientActual = clientDAO.findClient(clientActual);
                        System.out.println("Welcome " + clientActual.getClientName());
                        login = true;
                    } else {
                        System.out.println("Client not found");
                    }
                }
                if (op == 3) {
                    break;
                }
                String options2 = "1) Add account to client\n" +
                        "2) Make a transaction\n" +
                        "3) See accounts of client\n" +
                        "4) See transactions of client\n" +
                        "5) Delete client\n" +
                        "6) Update info client\n" +
                        "7) Exit";
                if (login){
                    while(op!=7){
                        System.out.println(options2);
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
                                    System.out.println("What kind of account:\n" +
                                            "1) Saving Account\n" +
                                            "2) Current Account\n" +
                                            "3) Mortgage Account\n");
                                    String accType = reader.readLine();
                                    if (Objects.equals(accType, "1")) {
                                        System.out.println("Enter money: ");
                                        String money = reader.readLine();
                                        Account cuenta = new SavingAccount(accountDAO.getSize(), clientActual.getClientNumber(), 0.2f, Float.parseFloat(money));
                                        accountDAO.addAccount(cuenta);
                                        clientActual.addAccount(cuenta);
                                        clientDAO.replaceClient(clientActual);
                                    }
                                    if (Objects.equals(accType, "2")) {
                                        System.out.println("Enter money: ");
                                        String money = reader.readLine();
                                        Account cuenta = new CurrentAccount(accountDAO.getSize(), clientActual.getClientNumber(), Float.parseFloat(money));
                                        accountDAO.addAccount(cuenta);
                                        clientActual.addAccount(cuenta);
                                        clientDAO.replaceClient(clientActual);
                                    }
                                    if (Objects.equals(accType, "3")) {
                                        System.out.println("Enter debt: ");
                                        String money = reader.readLine();
                                        Account cuenta = new MortgageAccount(accountDAO.getSize(), clientActual.getClientNumber(), Float.parseFloat(money), 500, 0.2f);
                                        accountDAO.addAccount(cuenta);
                                        clientActual.addAccount(cuenta);
                                        clientDAO.replaceClient(clientActual);
                                    } else {
                                        System.out.println("Enter a valid number");
                                    }
                                } catch (Exception e){
                                    System.out.println("Enter a valid input");
                                }
                            }
                            if (op == 2) {
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
                                        for (Account cuenta : accountDAO.getAccounts()) {
                                            if (cuenta.getAccountNumber() == Integer.parseInt(sender) && cuenta.getAccountType().equals("Saving")){
                                                cuenta1 = cuenta.getAccountNumber();
                                            }
                                        }
                                        if (cuenta1 == -1){
                                            System.out.println("com.java.objects.Account number is wrong");
                                        } else {
                                            SavingAccount acc1 = (SavingAccount) accountDAO.getAccount(cuenta1);
                                            acc1.addMoney(Float.parseFloat(money));
                                            accountDAO.replaceAccount(acc1);
                                            LocalDateTime date = java.time.LocalDateTime.now();
                                            Transaction transaction = new Transaction(transactionDAO.getTransactionNum(), cuenta1, cuenta1, Float.parseFloat(money), date, "debit");
                                            transactionDAO.addTransaction(transaction);
                                            clientActual.addTransaction(transaction);
                                            clientDAO.replaceClient(clientActual);
                                            clientDAO.updateAcc(clientActual,acc1);
                                        }
                                    }
                                    if (Objects.equals(accType, "2")) {
                                        System.out.println("com.java.objects.Account that sends: ");
                                        String sender = reader.readLine();
                                        System.out.println("com.java.objects.Account that receives: ");
                                        String receives = reader.readLine();
                                        System.out.println("Quantity of money: ");
                                        String money = reader.readLine();
                                        int cuenta1 = -1;
                                        int cuenta2 = -1;
                                        for (Account cuenta : accountDAO.getAccounts()) {
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
                                            LocalDateTime date = java.time.LocalDateTime.now();
                                            Transaction transaction = new Transaction(transactionDAO.getTransactionNum(), cuenta1, cuenta1, Float.parseFloat(money), date, "debit");
                                            transactionDAO.addTransaction(transaction);
                                            clientActual.addTransaction(transaction);
                                            clientDAO.replaceClient(clientActual);
                                            CurrentAccount acc1 = (CurrentAccount) accountDAO.getAccount(cuenta1);
                                            CurrentAccount acc2 = (CurrentAccount) accountDAO.getAccount(cuenta2);
                                            acc1.takeMoney(Float.parseFloat(money));
                                            acc2.addMoney(Float.parseFloat(money));
                                            accountDAO.replaceAccount(acc1);
                                            accountDAO.replaceAccount(acc2);
                                            System.out.println(transaction);
                                            clientDAO.updateAcc(clientActual,acc1);
                                        }
                                    }
                                    if (Objects.equals(accType, "3")) {
                                        System.out.println("com.java.objects.Account number: ");
                                        String sender = reader.readLine();
                                        int cuenta1 = -1;
                                        for (Account cuenta :  accountDAO.getAccounts()) {
                                            if (cuenta.getAccountNumber() == Integer.parseInt(sender) && cuenta.getAccountType().equals("Mortgage")){
                                                cuenta1 = cuenta.getAccountNumber();
                                            }
                                        }
                                        if (cuenta1 == -1){
                                            System.out.println("com.java.objects.Account number is wrong");
                                        } else {
                                            LocalDateTime date = java.time.LocalDateTime.now();
                                            Transaction transaction = new Transaction(transactionDAO.getTransactionNum(), cuenta1, cuenta1, 500, date, "credit");
                                            transactionDAO.addTransaction(transaction);
                                            clientActual.addTransaction(transaction);
                                            clientDAO.replaceClient(clientActual);
                                            MortgageAccount acc1 = (MortgageAccount) accountDAO.getAccount(cuenta1);
                                            System.out.println("Debt before payment: " + acc1.getDebt());
                                            acc1.payDebt();
                                            accountDAO.replaceAccount(acc1);
                                            System.out.println("Debt after payment: " + acc1.getDebt());
                                            System.out.println(transaction);
                                            clientDAO.updateAcc(clientActual,acc1);
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println("try again");
                                }
                            }
                            if (op == 3) {
                                for (Account cuenta : clientActual.getAccounts()) {
                                    System.out.println(cuenta);
                                }
                            }
                            if (op == 4) {
                                for (Transaction transaction : clientActual.getTransactions()) {
                                    System.out.println(transaction);
                                }
                            }
                            if (op == 5) {
                                System.out.println("Are you sure to delete this client? YES or NO");
                                String answer = reader.readLine();
                                if(answer.equals("YES")){
                                    clientDAO.deleteClient(clientActual);
                                    login = false;
                                    break;
                                }
                            }
                            if (op == 6) {
                                System.out.println("Enter the name:");
                                String name = reader.readLine();
                                System.out.println("Enter the email:");
                                String email = reader.readLine();
                                clientDAO.updateClient(clientActual.getClientNumber(), name, email);
                                System.out.println("Updated Client");
                            }
                            if (op == 7){
                                login = false;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}
