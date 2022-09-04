package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        BankAccount ba1 = new BankAccount(new Person("Jack", "Johnson", "jack@gmail.com"), "DE89 3704 0044 0532 0130 00", 105280.82);
        BankAccount ba2 = new BankAccount(new Person("Ray", "Sanders", "ray@gmail.com"), "DE84 5028 0058 0412 1285 48", 158560.44);
        BankAccount ba3 = new BankAccount(new Person("Mary", "Smith", "mary@gmail.com"), "DE85 5028 0058 0412 1285 73", 85.26);
        BankAccount ba4 = new BankAccount(new Person("Liza", "Williams", "liza@gmail.com"), "DE85 5028 0058 0412 1285 73", 858524.26);
        List<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(ba1);
        bankAccounts.add(ba2);
        bankAccounts.add(ba3);
        bankAccounts.add(ba4);

        System.out.println(printAccountSumLessThanGiven(bankAccounts, 100));
        System.out.println(sortedBankAccountList(bankAccounts, 100000));


    }
    // Дан список  BankAccount {Peroson person, String IBAN, double balance). Используя stream необходимо вывести на экран все аккаунты,
    // баланс которых составляет менее 100.

    public static List<BankAccount> printAccountSumLessThanGiven(List<BankAccount> accounts, double balance) {
        return accounts.stream()
                .filter(ba -> ba.getBalance() < balance)
                .collect(Collectors.toList());
    }
    //Дан список  BankAccount {Peroson person, String IBAN, double balance), Person{String fName, String lName String email)
    // Используя stream,  сформировать отсортированный по lName лист строк вида “Lennon J.;IBAN: DE19************43;lennon@gmail.com”
    // (т.е. ФИО; замаскированный счет, в котором открыты только первые 2 и последние 2 символа; email)  для всех клиентов,
    // чей баланс более 100000

    public static List<String> sortedBankAccountList(List<BankAccount> accounts, double balance) {
        return accounts.stream()

                .filter(ba -> ba.getBalance() > balance)
                .sorted(Comparator.comparing(o -> o.getPerson().getlName()))
                .map(s -> s.person.getlName()
                        + " " + s.person.getfName().substring(0, 1) + ".; "
                        + "IBAN: " + s.getIBAN().trim().substring(0, 4) +"*".repeat(s.getIBAN().replace(" ","").length() - 6)+s.getIBAN().trim().substring(s.getIBAN().length() - 2,s.getIBAN().length()) + "; "
                        + s.person.getEmail())
                .collect(Collectors.toList());

    }

}
