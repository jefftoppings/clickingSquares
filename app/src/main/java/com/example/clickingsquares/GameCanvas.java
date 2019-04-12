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
        random = new Random();
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

        int x = random.nextInt(MainActivity.width-200);
        int y  = random.nextInt(MainActivity.height-200);
        makeNewSquare(x,y);
        canvas.drawRect(x, y,x+200, y+200, paint);
    }

    private void makeNewSquare(int x, int y) {
        Square square = new Square(x,y);
        model.squares.add(square);
    }
}
