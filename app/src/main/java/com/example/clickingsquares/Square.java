package com.example.clickingsquares;

import android.graphics.Color;

class Square {

    int x, y, r, g, b;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setColor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public boolean checkClicked(float xClick, float yClick) {
        if ((x < xClick && xClick < x + 200) && (y < yClick && yClick < y + 200)) {
            return true;
        }
        return false;
    }
}
