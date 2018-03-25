package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Paddle {
    private Vector2 pos;
    private float width;
    private float height;
    private Side side;
    private float speed;

    Paddle(Side side) {
        this.side = side;
        speed = 300;

        switch (side) {
            case LEFT:
                height = 15;
                width = 5;
                pos = new Vector2(0, Gdx.app.getGraphics().getHeight() / 2 + height / 2);
                break;
            case RIGHT:
                height = 15;
                width = 5;
                pos = new Vector2(Gdx.app.getGraphics().getWidth() - width, Gdx.app.getGraphics().getHeight() / 2 + height / 2);
                break;
            default:
                System.out.println("StufF");
        }
    }

    public void draw(ShapeRenderer renderer) {
        renderer.setColor(0, 1, 0, 1);
        renderer.rect(pos.x, pos.y, width, height);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            float newPos = pos.y + speed * Gdx.graphics.getDeltaTime();
            if (newPos > Gdx.app.getGraphics().getHeight() - height) {
                newPos = Gdx.app.getGraphics().getHeight() - height;
            }
            pos.y = newPos;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            float newPos = pos.y - speed * Gdx.graphics.getDeltaTime();
            if (newPos < 0) {
                newPos = 0;
            }
            pos.y = newPos;
        }
    }
}
