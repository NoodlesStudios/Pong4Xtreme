package com.game.pong;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Paddle {
    private Vector2 pos;
    private float width;
    private float height;

    public void draw(ShapeRenderer renderer) {
        renderer.setColor(0, 1, 0, 1);
        renderer.rect(pos.x, pos.y, width, height);
    }
}
