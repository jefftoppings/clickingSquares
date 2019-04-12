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

        if (model.squares.size() == 0) {
            makeNewSquare();
        }

        paint.setStyle(Paint.Style.FILL);

        for (Square s : model.squares) {
            paint.setColor(Color.rgb(s.r, s.g, s.b));
            canvas.drawRect(s.x, s.y,s.x+200, s.y+200, paint);
        }
    }

    private void makeNewSquare() {
        int x = random.nextInt(MainActivity.width-200);
        int y  = random.nextInt(MainActivity.height-200);
        Square square = new Square(x,y);
        model.squares.add(square);
    }
}
