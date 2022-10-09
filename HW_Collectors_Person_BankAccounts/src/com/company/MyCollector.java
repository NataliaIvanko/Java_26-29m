package com.company;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MyCollector implements Collector<List<Object>, Map<String, List<String>>,List<Object> > {

    @Override
    public Supplier<Map<String, List<String>>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<Person, List<String>>, BankAccountWithOwner> accumulator() {//accepts two input arguments and returns no result
      return (map, ac) -> {
          List<String> list = new ArrayList<>();
          list.add(ac.getIban());
          map.put(ac.getOwner().getName(), list);
      } ;
    }

    @Override
    public BinaryOperator<Map<String, List<String>>> combiner() {
        return null;
    }

    @Override
    public Function<Map<String, List<String>>, List<Object>> finisher() {
        return null;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return null;
    }
}
