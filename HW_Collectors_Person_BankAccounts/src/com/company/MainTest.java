package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void testGetMap(){
        Person p1 = new Person("Jack");
        Person p2 = new Person("Ann");
        Person p3 = new Person("Luke");

        List<BankAccountWithOwner> accounts = List.of(new BankAccountWithOwner(p1, "123456"),
                (new BankAccountWithOwner(p2, "46789")),
                (new BankAccountWithOwner(p3, "951753")));
      //  PersonWithBankAccount{String name; List<String> ibanns;
        Person p4 = new Person("Jack");
        Person p5 = new Person("Ann");
        Person p6 = new Person("Luke");


        List<PersonWithBankAccounts>list = List.of(new PersonWithBankAccounts("Ann", List.of("46789")),
                                           new PersonWithBankAccounts("Luke", List.of("951753")),
                                           new PersonWithBankAccounts("Jack", List.of("123456")));
        assertEquals(list, Main.getListPersonsWithBankAccount(accounts));

    }

}
