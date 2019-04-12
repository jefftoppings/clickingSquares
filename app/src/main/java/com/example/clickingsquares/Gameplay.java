package com.example.clickingsquares;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Gameplay extends LinearLayout {

    TextView scoreLabel, timeRemaining;

    public Gameplay(Context context) {
        super(context);
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

        // Time Remaining
        timeRemaining = new TextView(context);
        topSection.addView(timeRemaining);
        timeRemaining.setText("Time Remaining: 60");
        timeRemaining.setTextColor(Color.WHITE);
        timeRemaining.setTextSize(20);
        timeRemaining.setLayoutParams(new LayoutParams(MainActivity.width/2, MainActivity.height/10));

        // Canvas
        GameCanvas gameCanvas = new GameCanvas(context);
        Model model = new Model(gameCanvas, this);
        gameCanvas.setModel(model);
        Controller controller = new Controller();
        gameCanvas.setController(controller);
        controller.setModel(model);
        addView(gameCanvas);
        gameCanvas.setLayoutParams(new LayoutParams(MainActivity.width, (int) (MainActivity.height*0.9)));
        gameCanvas.invalidate();
    }

    public void setScoreLabel(int score) {
        scoreLabel.setText("Score: " + score);
    }
}
