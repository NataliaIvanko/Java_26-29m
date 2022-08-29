package com.company;

@FunctionalInterface
public interface MyFunction<A, B> {
    B apply (A object); //вернуть В, приходит А
}
