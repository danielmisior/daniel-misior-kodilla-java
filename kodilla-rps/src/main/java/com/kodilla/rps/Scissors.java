package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public final class Scissors  implements Figure{

    private final String figureName;
    private final List<String> beats = new ArrayList<>();

    public Scissors(final String figureName) {
        this.figureName = figureName;
    }

    @Override
    public String getFigureName() {
        return figureName;
    }

    @Override
    public List<String> beats() {
        beats.add(Figures.getPaper());
        beats.add(Figures.getLizard());
        return beats;
    }
}
