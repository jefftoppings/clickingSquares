package com.jeff.clickingsquares;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    static LinearLayout root;
    static int width, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get width and height
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;

        root = findViewById(R.id.root);
        MainMenu mainMenu = new MainMenu(this);
        root.addView(mainMenu);

    }
}
