package com.kodilla.rps;

import java.util.ArrayList;
import java.util.List;

public final class Paper implements Figure{

    private final String figureName;
    private final List<String> beats = new ArrayList<>();

    public Paper(final String figureName) {
        this.figureName = figureName;
    }

    @Override
    public String getFigureName() {
        return figureName;
    }

    @Override
    public List<String> beats() {
        beats.add(Figures.getRock());
        beats.add(Figures.getSpock());
        return beats;
    }
}
