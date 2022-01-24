package com.java.dao;

import com.java.objects.Account;
import com.java.objects.Client;

import java.util.ArrayList;

public class ClientDAO {
    private ArrayList<Client> clients = new ArrayList<Client>();

    public void addClient(Client client){
        clients.add(client);
    }

    public void deleteClient(Client client){
        clients.remove(client);
    }

    public void updateClient(int clientNum, String name, String email){
        for (Client client : clients){
            if(client.getClientNumber() == clientNum){
                client.setClientName(name);
                client.setEmail(email);
            }
        }
    }

    public boolean findClient(String email){
        for (Client client : clients){
            if(client.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public Client findClient(Client client1){
        for (Client client : clients){
            if(client.getEmail().equals(client1.getEmail())){
                return client;
            }
        }
        return client1;
    }

    public void replaceClient(Client client1){
        for (Client client : clients){
            if(client.getClientNumber() == client1.getClientNumber()){
                client = client1;
            }
        }
    }

    public void updateAcc(Client client1, Account account1){
        for (Client client : clients){
            if(client.getClientNumber() == client1.getClientNumber()){
                client = client1;
                for (Account account : client.getAccounts()){
                    if(account.getAccountNumber() == account1.getAccountNumber()){
                        account = account1;
                    }
                }
            }
        }
    }

    public int getSize(){
        return clients.size();
    }
}
