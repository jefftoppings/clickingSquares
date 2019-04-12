package com.example.clickingsquares;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EndGame extends LinearLayout {

    public EndGame(Context context, Model model) {
        super(context);
        setOrientation(VERTICAL);
        setBackgroundColor(Color.CYAN);
        setLayoutParams(new LayoutParams(MainActivity.width, MainActivity.height));

        TextView scoreTop = new TextView(context);
        addView(scoreTop);
        scoreTop.setText("\nYou got 100 points in\n");
        scoreTop.setTextSize(30);
        scoreTop.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        scoreTop.setWidth(MainActivity.width);

        TextView scoreTime = new TextView(context);
        addView(scoreTime);
        scoreTime.setTextSize(50);
        long totalTime = System.currentTimeMillis() - model.startTime;
        double seconds = (double) totalTime / 1000;
        String time = seconds + "";
        scoreTime.setText(time);
        scoreTime.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        scoreTime.setWidth(MainActivity.width);

        TextView scoreBottom = new TextView(context);
        addView(scoreBottom);
        scoreBottom.setText("\nseconds\n");
        scoreBottom.setTextSize(30);
        scoreBottom.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        scoreBottom.setWidth(MainActivity.width);

        // Add a start button
        Button playAgain = new Button(context);
        playAgain.setText("Play Again");
        playAgain.setTextSize(30);
        playAgain.setBackgroundColor(Color.DKGRAY);
        playAgain.setTextColor(Color.WHITE);
        playAgain.setOnClickListener(this::playAgain);
        addView(playAgain);

        // adjust size and positioning of button
        playAgain.setLayoutParams(new LinearLayout.LayoutParams(MainActivity.width/2, 300));
        LinearLayout.LayoutParams linearLayoutParams = (LinearLayout.LayoutParams)playAgain.getLayoutParams();
        linearLayoutParams.gravity = Gravity.CENTER;
        playAgain.setLayoutParams(linearLayoutParams);
    }

    private void playAgain(View view) {
        MainActivity.root.removeAllViews();
        MainActivity.root.addView(new MainMenu(getContext()));
    }
}
