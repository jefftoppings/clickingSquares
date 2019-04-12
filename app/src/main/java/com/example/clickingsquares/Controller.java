package com.example.clickingsquares;

import android.view.MotionEvent;
import android.view.View;

class Controller {

    Model model;
    int squaresToAdd;

    public Controller() {
        squaresToAdd = 1;
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
                }
                else {
                    model.score--;
                    model.gameplay.setScoreLabel(model.score);
                }

                // add more squares
                if (model.squares.size() < 40) {
                    for (int i = 0; i < 5; i++) {
                        model.gameplay.makeNewSquare();
                    }
                }

                // redraw
                view.invalidate();

                // check for end game condition
                if (model.score >= 100) {
                    MainActivity.root.removeAllViews();
                    MainActivity.root.addView(new EndGame(model.gameplay.getContext(), model));
                }

                return false;
        }

        return false;
    }
}
