package org.example;

//imports
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
//end of imports

/**
 * Class person represents a user. Every Person has balances, transactions and an username
 * @author manan
 */
public final class Person {

    private final String user; //this users username
    private double balance1; //this users checking account balance
    private double balance2; //this users saving account balance
    LinkedHashMap<LocalDateTime,Double> transactions1; //this users checking account transactions
    LinkedHashMap<LocalDateTime,Double> transactions2; //this users checking savings transactions


    public Person(String user, double balance1, double balance2, LinkedHashMap<LocalDateTime,Double> transactions1, LinkedHashMap<LocalDateTime,Double> transactions2) {
        this.user = user;
        this.balance1 = balance1;
        this.balance2 = balance2;
        this.transactions1 = transactions1;
        this.transactions2 = transactions2;
    }
    public Person(String user){
        this.user = user;
        balance1 = 0;
        balance2 = 0;
        transactions1 = new LinkedHashMap<>();
        transactions2 = new LinkedHashMap<>();
    }
    public Person(){
        user = "";
        balance1 = 0;
        balance2 = 0;
        transactions1 = new LinkedHashMap<>();
        transactions2 = new LinkedHashMap<>();
    }

    /**
     * used for writing users info into database
     * @return
     */
    @Override
    public String toString(){
        String out = user + " " + balance1 + " " + balance2 + " " + transactions1.size() + " ";

        for(LocalDateTime x : transactions1.keySet()){
            out += x + " " + transactions1.get(x) + " ";
        }

        out += " " + transactions2.size() + " ";

        for(LocalDateTime x : transactions2.keySet()){
            out += x + " " + transactions2.get(x) + " ";
        }



        return out;

    }

    //get methods

    public String getUser(){
        return user;
    }

    public double getBalance1(){
        return Math.round(balance1 * 100.0) / 100.0;
    }

    public double getBalance2(){
        return Math.round(balance2 * 100.0) / 100.0;
    }



    /**
     * used for depositing money into this person's accounts
     * creates a key date and puts the key and amount into appropriate hashMap and adds it to balance
     * @param amount
     * @param account
     */
    public void deposit(double amount, int account){
        if(account == 1){
            balance1 += amount;
            transactions1.put(LocalDateTime.now(),amount);

        }
        else{
            balance2 += amount;
            transactions2.put(LocalDateTime.now(),amount);
        }
    }

    /**
     * used for withdrawing money from this person's accounts
     * returns true and subtracts amount if sufficient balance
     * return false otherwise
     * @param amount
     * @param account
     * @return
     */
    public boolean withdraw(double amount, int account){
        if(account == 1) {
            if(balance1 >= amount){
                balance1 -= amount;
                transactions1.put(LocalDateTime.now(),amount*-1);

                return true;
            }
        }
        else if(account == 2) {
            if(balance2 >= amount){
                balance2 -= amount;
                transactions2.put(LocalDateTime.now(),amount*-1);

                return true;
            }
        }

        return false;
    }

    /**
     * returns transactions hashMap
     * @param account
     * @return
     */
    public HashMap<LocalDateTime, Double> getTransactions(int account) {
        if(account == 1)
            return transactions1;
        return transactions2;
    }


    /**
     * returns only transactions amounts as an arrayList
     * @param account
     * @return
     */
    public ArrayList<Double> getTrans(int account){
        ArrayList<Double> ret = new ArrayList<>();

        if(account == 1){
            for(LocalDateTime x : transactions1.keySet()){
                ret.add(transactions1.get(x));
            }
            return ret;}
        for(LocalDateTime x : transactions2.keySet()){
            ret.add(transactions2.get(x));
        }
        return ret;
    }
}
