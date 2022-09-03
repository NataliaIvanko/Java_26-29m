package com.company;

public class BankAccount {
    Person person;
    private String IBAN;
    private double balance;

    public BankAccount(Person person, String IBAN, double balance) {
        this.person = person;
        this.IBAN = IBAN;
        this.balance = balance;
    }

    public Person getPerson() {
        return person;
    }

    public String getIBAN() {
        return IBAN;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "BankAccount: " +
                 person +", "+
                 IBAN + ", " +
                 balance;
    }
}
