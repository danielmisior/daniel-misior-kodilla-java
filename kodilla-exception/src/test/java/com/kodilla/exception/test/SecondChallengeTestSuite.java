package com.kodilla.exception.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondChallengeTestSuite {

    @Test
    void testProbablyIWillTrowException() {
        //Given
        SecondChallenge secondChallenge = new SecondChallenge();

        //When & then
        assertAll(
                //Program nie powinien wyświetlić błędu, x i y poza zakresami.
                () -> assertDoesNotThrow(() -> secondChallenge.probablyIWillThrowException(1.01, 1.49)),

                //Program powinien wyświetlić błąd, x w zakresie
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 1.51)),

                //y w zakresie
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(1.99, 1.5)),

                //x i y w zakresie
                () -> assertThrows(Exception.class, () -> secondChallenge.probablyIWillThrowException(2, 1.5))
        );
    }
}
