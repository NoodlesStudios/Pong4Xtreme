package com.game.pong;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Board {
    protected Rectangle rect;

    public Board(float x, float y, float width, float height) {
        rect = new Rectangle(x, y, width, height);
    }

    public Vector2 transformCoord(Vector2 vec) {
        return new Vector2(vec.x + rect.getX(), vec.y + rect.getY());
    }

    public abstract void draw(ShapeRenderer renderer);

    public abstract void update();

    public float getWidth() {
        return rect.getWidth();
    }

    public float getHeight() {
        return rect.getHeight();
    }
}
