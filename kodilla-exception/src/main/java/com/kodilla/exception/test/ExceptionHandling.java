package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {

        SecondChallenge secondChallenge = new SecondChallenge();

        try{
            String temp = secondChallenge.probablyIWillThrowException(4, 1.5);
            System.out.println(temp);
        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            System.out.println("8.3. Throw and Throws");
        }
    }
}
