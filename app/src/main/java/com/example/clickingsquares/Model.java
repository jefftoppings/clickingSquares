package com.example.clickingsquares;

import java.util.ArrayList;

public class Model {

    GameCanvas gameCanvas;
    ArrayList<Square> squares;

    public Model(GameCanvas gameCanvas) {
        this.gameCanvas = gameCanvas;
        this.squares = new ArrayList<>();
    }
}
