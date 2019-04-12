package com.example.clickingsquares;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;

public class Gameplay extends LinearLayout {

    public Gameplay(Context context) {
        super(context);
        setOrientation(VERTICAL);
        setBackgroundColor(Color.DKGRAY);
        setLayoutParams(new LayoutParams(MainActivity.width, MainActivity.height));

        // top section

    }
}
