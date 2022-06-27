package com.company;

import java.util.Arrays;
import java.util.Iterator;

public class MyPersonArray implements Iterable<Person> {

    private Person[] person;

    public MyPersonArray(Person[] person) {
        this.person = person;
    }

    @Override
    public String toString() {
         return "Person =" + Arrays.toString(person);
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator();
    }

    class PersonIterator implements Iterator<Person>{
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index< person.length; //check if we exceed the array length
        }

        @Override
        public Person next() {
            int temp = index;
            index++; // return element, increment index. //++index - increment and then return element
            return person[temp]; //
        }
    }
}
