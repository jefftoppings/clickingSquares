package com.example.clickingsquares;

import android.view.MotionEvent;
import android.view.View;

class Controller {

    Model model;

    public Controller() {
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public boolean handleTouched(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Square hit = model.checkHit(motionEvent.getX(), motionEvent.getY());
                if (hit != null) {
                    // increment score
                    model.score++;
                    model.gameplay.setScoreLabel(model.score);

                    // remove selected square
                    model.squares.remove(hit);

                    // redraw
                    view.invalidate();
                }
                else {
                    model.score--;
                    model.gameplay.setScoreLabel(model.score);
                }
                return false;
        }

        return false;
    }
}
