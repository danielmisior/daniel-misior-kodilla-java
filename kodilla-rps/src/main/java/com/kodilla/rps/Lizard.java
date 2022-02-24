package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public final class Lizard implements Figure {

    private final String figureName;
    private final List<String> beats = new ArrayList<>();

    public Lizard(final String figureName) {
        this.figureName = figureName;
    }

    @Override
    public String getFigureName() {
        return figureName;
    }

    @Override
    public List<String> beats() {
        beats.add(Figures.getSpock());
        beats.add(Figures.getPaper());
        return beats;
    }
}
