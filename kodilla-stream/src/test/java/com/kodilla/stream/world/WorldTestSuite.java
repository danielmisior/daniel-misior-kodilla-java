package com.kodilla.stream.world;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("World Test Suite")

public class WorldTestSuite {

    @Test
    void testGetPeopleQuantity() {
        //Given
        Country poland = new Country("Poland", new BigDecimal("37972348"));
        Country france = new Country("France", new BigDecimal("60976097"));
        Country germany = new Country("Germany", new BigDecimal("89493023"));
        Country russia = new Country("Russia", new BigDecimal("59094948"));
        Country japan = new Country("Japan", new BigDecimal("18920389"));
        Country brazil = new Country("Brazil", new BigDecimal("201993002"));
        Country argentina = new Country("Argentina", new BigDecimal("45923849"));
        Country chile = new Country("Chile", new BigDecimal("17929039"));
        Country ghana = new Country("Ghana", new BigDecimal("31039299"));
        Country senegal = new Country("Senegal", new BigDecimal("18923029"));

        List<Country> europeanCountries = new ArrayList<>();
        europeanCountries.add(poland);
        europeanCountries.add(france);
        europeanCountries.add(germany);

        List<Country> asiaCountries = new ArrayList<>();
        asiaCountries.add(russia);
        asiaCountries.add(japan);

        List<Country> southAmericanCountries = new ArrayList<>();
        southAmericanCountries.add(brazil);
        southAmericanCountries.add(argentina);
        southAmericanCountries.add(chile);

        List<Country> africanCountries = new ArrayList<>();
        africanCountries.add(ghana);
        africanCountries.add(senegal);

        Continent europe = new Continent("Europe", europeanCountries);
        Continent asia = new Continent("Asia", asiaCountries);
        Continent southAmerica = new Continent("South America", southAmericanCountries);
        Continent africa = new Continent("Africa", africanCountries);

        List<Continent> continents = new ArrayList<>();
        continents.add(europe);
        continents.add(asia);
        continents.add(southAmerica);
        continents.add(africa);

        World world = new World(continents);

        //When
        BigDecimal result = world.getPeopleQuantity();
        BigDecimal expectedResult = new BigDecimal("582265023");

        //Then
        assertEquals(expectedResult, result);
    }
}
