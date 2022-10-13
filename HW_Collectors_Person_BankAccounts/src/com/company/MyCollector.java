package com.company;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MyCollector implements Collector<BankAccountWithOwner, Map<String, List<String>>, List<PersonWithBankAccounts>>{


    @Override
    public Supplier<Map<String, List<String>>> supplier() {
        return HashMap:: new;
    }



    @Override
    public BiConsumer<Map<String, List<String>>, BankAccountWithOwner> accumulator() {
        return (map, obj) -> {
            List<String> list = new ArrayList<>();
            list.add(obj.getIban());
            map.put(obj.getOwner().getName(), list); // Будет ошибка? Будет создаваться каждый раз новый лист?
        };
    }

    @Override
    public BinaryOperator<Map<String, List<String>>> combiner() { //what do we combine here?
        return null;
    }

    @Override
    public Function<Map<String, List<String>>, List<PersonWithBankAccounts>> finisher() {
         return  (map)->{
            List<PersonWithBankAccounts> res = new ArrayList<>();
            map.entrySet().forEach(p ->res.add(new PersonWithBankAccounts(p.getKey(), p.getValue())));
           return res;
        };
         //map.forEach((key, value) -> res.add(new PersonWithBankAccounts(key, value)));

    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}


