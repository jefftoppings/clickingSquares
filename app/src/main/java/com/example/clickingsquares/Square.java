package com.example.clickingsquares;

class Square {

    int x, y;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean checkClicked(float xClick, float yClick) {
        if ((x < xClick && xClick < x + 200) && (y < yClick && yClick < y + 200)) {
            return true;
        }
        return false;
    }
}
