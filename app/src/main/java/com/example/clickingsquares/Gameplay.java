package com.example.clickingsquares;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Gameplay extends LinearLayout {

    TextView score, timeRemaining;

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
        score = new TextView(context);
        topSection.addView(score);
        score.setText("Score: 0");
        score.setTextColor(Color.WHITE);
        score.setTextSize(20);
        score.setLayoutParams(new LayoutParams(MainActivity.width/2, MainActivity.height/10));

        // Time Remaining
        timeRemaining = new TextView(context);
        topSection.addView(timeRemaining);
        timeRemaining.setText("Time Remaining: 60");
        timeRemaining.setTextColor(Color.WHITE);
        timeRemaining.setTextSize(20);
        timeRemaining.setLayoutParams(new LayoutParams(MainActivity.width/2, MainActivity.height/10));

        // Canvas
        GameCanvas gameCanvas = new GameCanvas(context);
        gameCanvas.setModel(new Model(gameCanvas));
        gameCanvas.setController(new Controller());
        addView(gameCanvas);
        gameCanvas.setLayoutParams(new LayoutParams(MainActivity.width, (int) (MainActivity.height*0.9)));
        gameCanvas.invalidate();
    }
}
