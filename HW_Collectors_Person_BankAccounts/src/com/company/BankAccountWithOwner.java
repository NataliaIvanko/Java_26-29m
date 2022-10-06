package com.company;

public class BankAccountWithOwner {
    Person owner;
    private String iban;

    public BankAccountWithOwner(Person owner, String iban) {
        this.owner = owner;
        this.iban = iban;
    }

    public Person getOwner() {
        return owner;
    }

    public String getIban() {
        return iban;
    }

    @Override
    public String toString() {
        return  owner + " "+
                 iban;
    }
}
