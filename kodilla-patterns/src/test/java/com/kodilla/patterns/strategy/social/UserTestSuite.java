package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User anna = new Millenials("Anna Smith");
        User arthur = new YGeneration("Arthur Jobs");
        User john = new ZGeneration("John Spielberg");

        //When
        String annaSharedOn = anna.sharePost();
        System.out.println("Anna: " + annaSharedOn);
        String arthurSharedOn = arthur.sharePost();
        System.out.println("Arthur: " + arthurSharedOn);
        String johnSharedOn = john.sharePost();
        System.out.println("John: " + johnSharedOn);

        //Then
        assertEquals("Share post on Facebook", annaSharedOn);
        assertEquals("Share post on Twitter", arthurSharedOn);
        assertEquals("Share post on Snapchat", johnSharedOn);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User anna = new Millenials("Anna Smith");

        //When
        String annaSharedOn = anna.sharePost();
        System.out.println("Anna: " + annaSharedOn);
        anna.setPublisherStrategy(new TwitterPublisher());
        annaSharedOn = anna.sharePost();
        System.out.println("Now Anna: " + annaSharedOn);

        //Then
        assertEquals("Share post on Twitter", annaSharedOn);
    }
}
