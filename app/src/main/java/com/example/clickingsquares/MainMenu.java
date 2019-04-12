package com.example.clickingsquares;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

public class MainMenu extends LinearLayout {

    TextView title;
    Button startButton;

    public MainMenu(Context context) {
        super(context);
        setBackgroundColor(Color.CYAN);
        setLayoutParams(new LayoutParams(MainActivity.width, MainActivity.height));
        setOrientation(VERTICAL);

        // container
        LinearLayout container = new LinearLayout(context);
        container.setOrientation(VERTICAL);
        addView(container);

        // title of Main Menu
        title = new TextView(context);
        title.setText("CLICKING\nSQUARES\n");
        title.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        title.setTextSize(50);
        title.setWidth(MainActivity.width);
        container.addView(title);

        // Add a start button
        startButton = new Button(context);
        startButton.setText("Start");
        startButton.setTextSize(30);
        startButton.setBackgroundColor(Color.DKGRAY);
        startButton.setTextColor(Color.WHITE);
        startButton.setOnClickListener(this::startGame);
        container.addView(startButton);

        // adjust size and positioning of button
        startButton.setLayoutParams(new LinearLayout.LayoutParams(MainActivity.width/2, 300));
        LinearLayout.LayoutParams linearLayoutParams = (LinearLayout.LayoutParams)startButton.getLayoutParams();
        linearLayoutParams.gravity = Gravity.CENTER;
        startButton.setLayoutParams(linearLayoutParams);

        // adjust size and positioning of container
        LinearLayout.LayoutParams containerLayoutParams = (LinearLayout.LayoutParams)container.getLayoutParams();
        containerLayoutParams.gravity = Gravity.CENTER;
        container.setLayoutParams(containerLayoutParams);
    }

    private void startGame(View view) {
        System.out.println("Game Starts");
    }
}
