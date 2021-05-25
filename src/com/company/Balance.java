package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Balance {

    private final List<Account> accounts;
    private final List<Operations> operations = new ArrayList<>();
    public Balance()
    {
        this.accounts = new ArrayList<>();
        accounts.add(new Account("41", "Товары", 0, 0));
        accounts.add(new Account("50", "Касса", 0, 10000));
        accounts.add(new Account("60", "Расчеты с поставщиками и подрядчиками", 0, 0));
        accounts.add(new Account("62", "Расчеты с покупателями и заказчиками", 0, 0));
        accounts.add(new Account("90", "Расчеты с персоналом по оплате труда", 0, 0));
    }

    public Balance(List<Account> accounts)
    {
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Operations> getOperations() {
        return operations;
    }

    public Operations createOperation(Account a, Account b, double money) {
        int number = 0;
        Operations operation = new Operations(number, a, b, money);
        operations.add(operation);
        return operation;
    }

    public void writeInTxtAccounts(){

        try(FileWriter writer = new FileWriter("Accounts.txt")) {
            for (Account account : accounts) {
                String number = account.getNumber();
                String name = account.getName();
                String quantity = String.valueOf(account.getQuantity());
                String balance = String.valueOf(account.getBalance());
                writer.write(number + ";" + name + ";" + quantity + ";" + balance + System.getProperty("line.separator"));

            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }



}
