package com.example.clickingsquares;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class Gameplay extends LinearLayout {

    TextView scoreLabel;
    GameCanvas gameCanvas;
    Random random;
    Model model;
    Controller controller;
    long startTime;

    public Gameplay(Context context) {
        super(context);
        this.random = new Random();
        setOrientation(VERTICAL);
        setBackgroundColor(Color.DKGRAY);
        setLayoutParams(new LayoutParams(MainActivity.width, MainActivity.height));

        // top section
        LinearLayout topSection = new LinearLayout(context);
        addView(topSection);
        topSection.setLayoutParams(new LayoutParams(MainActivity.width, MainActivity.height/10));

        // Score
        scoreLabel = new TextView(context);
        topSection.addView(scoreLabel);
        scoreLabel.setText("Score: 0");
        scoreLabel.setTextColor(Color.WHITE);
        scoreLabel.setTextSize(20);
        scoreLabel.setLayoutParams(new LayoutParams(MainActivity.width/2, MainActivity.height/10));

        // Canvas, set references
        gameCanvas = new GameCanvas(context);
        model = new Model(gameCanvas, this);
        gameCanvas.setModel(model);
        controller = new Controller();
        gameCanvas.setController(controller);
        controller.setModel(model);
        addView(gameCanvas);
        gameCanvas.setLayoutParams(new LayoutParams(MainActivity.width, (int) (MainActivity.height*0.9)));
    }

    public void makeNewSquare() {
        int x = random.nextInt(MainActivity.width-200);
        int y  = random.nextInt(MainActivity.height-200);
        Square square = new Square(x,y);
        square.setColor(random.nextInt(254)+1, random.nextInt(254)+1,
                random.nextInt(254)+1);
        model.squares.add(square);
    }

    public void setScoreLabel(int score) {
        scoreLabel.setText("Score: " + score);
    }

}
