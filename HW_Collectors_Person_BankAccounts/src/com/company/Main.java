package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        // Даны следующие классы: Person {String name;}, BankAccountWithOwner{Person owner;String ibann;}
        // и данс писок банковских счетов List<BankAccountWithOwner> accounts.
        // Написать функцию, которая вернет List<PersonWithBankAccounts> persons (PersonWithBankAccount{String name; List<String> ibanns;})
        // такой, что к каждому человеку прилагается список ibanns его банковских счетов.


        Person p1 = new Person("Jack");
        Person p2 = new Person("Ann");
        Person p3 = new Person("Luke");

        List<BankAccountWithOwner> accounts = List.of(new BankAccountWithOwner(p1, "123456"),
                (new BankAccountWithOwner(p2, "46789")),
                (new BankAccountWithOwner(p3, "951753")));


        System.out.println(getListPersonsWithBankAccount(accounts));


    }


    public static List<PersonWithBankAccounts> getListPersonsWithBankAccount(List<BankAccountWithOwner> list) {
        return list.stream()
                .collect(Collectors.groupingBy(ac -> ac.getOwner().getName(),
                        Collectors.mapping(ac -> ac.getIban(), Collectors.toList())))
                .entrySet().stream()
                .map(p -> new PersonWithBankAccounts(p.getKey(), p.getValue()))
                .collect(Collectors.toList());

        //Свой коллектор я долго пыталась написать, но я застряла...
    }

}


