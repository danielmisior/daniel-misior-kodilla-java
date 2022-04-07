package com.kodilla.good.patterns.challenges.store;

public class MailService implements InformationService {

    @Override
    public void sendMessage(User user) {
        System.out.println("The product has been ordered!");
    }
}
