package com.kodilla.rps;

public class RpsRunner {

    public static void main(String[] args) {
        while(!Game.getInstanceGame().isEnd()) {
            Game.getInstanceGame().start();
            Game.getInstanceGame().play();
        }
    }
}
