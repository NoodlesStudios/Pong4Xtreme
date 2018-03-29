package com.game.pong;

import com.badlogic.gdx.math.Rectangle;

public abstract class Board {
    private Rectangle rect;

    public Board(float x, float y, float width, float height) {
        rect = new Rectangle(x, y, width, height);
    }

    public abstract void draw();

    public abstract void update();
}
