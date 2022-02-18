package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {

    List<Integer> ListOfNumbers;

    public OddNumbersExterminator() {
        ListOfNumbers = new ArrayList<>();
    }

    public List<Integer> exterminate(List<Integer> numbers) {
        for(Integer number: numbers) {
            if(number % 2 == 0) {
                ListOfNumbers.add(number);
            }
        }
        return ListOfNumbers;
    }

    public List<Integer> getListOfNumbers() {
        return ListOfNumbers;
    }
}
