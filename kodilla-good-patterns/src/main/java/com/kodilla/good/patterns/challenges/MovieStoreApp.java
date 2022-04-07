package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class MovieStoreApp {

    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();
        String result = movieStore.getMovies().values()
                .stream()
                .flatMap(strings -> strings.stream())
                .collect(Collectors.joining("! "));
        System.out.println(result);
    }
}
