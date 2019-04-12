package com.example.clickingsquares;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

class GameCanvas extends View {

    Canvas canvas;
    Paint paint;
    Model model;
    Controller controller;
    Random random;

    public GameCanvas(Context context) {
        super(context);
        paint = new Paint();
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setController(Controller controller) {
        this.controller = controller;
        this.setOnTouchListener(controller::handleTouched);
    }

    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);

        canvas.drawRect(100, 100,200, 200, paint);
    }
}
