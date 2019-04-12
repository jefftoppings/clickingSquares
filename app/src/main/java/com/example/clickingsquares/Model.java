package com.example.clickingsquares;

import java.util.ArrayList;

public class Model {

    GameCanvas gameCanvas;
    ArrayList<Square> squares;
    int score;
    Gameplay gameplay;
    long startTime;

    public Model(GameCanvas gameCanvas, Gameplay gameplay) {
        this.gameCanvas = gameCanvas;
        this.gameplay = gameplay;
        this.squares = new ArrayList<>();
        startTime = System.currentTimeMillis();
        score = 0;
    }

    public Square checkHit(float x, float y) {
        for (Square s : squares) {
            if (s.checkClicked(x,y)) {
                return s;
            }
        }
        return null;
    }
}
