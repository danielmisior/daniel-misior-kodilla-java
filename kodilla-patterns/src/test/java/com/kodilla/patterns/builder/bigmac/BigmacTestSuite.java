package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {

    @Test
    void testBigmacBulider() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBulider()
                .bun("With sesame")
                .burgers(1)
                .sauce("Standard")
                .ingredients("Onion")
                .ingredients("Cheese")
                .build();
        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();
        int howManyBurgers = bigmac.getBurgers();
        String whichSauce = bigmac.getSauce();
        String whichBun = bigmac.getBun();

        //Then
        assertEquals(2, howManyIngredients);
        assertEquals(1, howManyBurgers);
        assertEquals("Standard", whichSauce);
        assertEquals("With sesame", whichBun);
    }
}
