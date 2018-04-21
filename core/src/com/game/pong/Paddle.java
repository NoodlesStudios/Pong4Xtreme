package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.game.pong.input.PaddleInput;

public class Paddle {
    private Board board;
    private PaddleInput input;

    private Rectangle rect;
    private Side side;

    // Movement
    private final float maxSpeed;
    private float velocity;
    private float accel;

    Paddle(Side side, Board board, PaddleInput input, float length, float thickness, float maxSpeed, float accel) {
        this.board = board;
        this.input = input;

        this.side = side;

        this.maxSpeed = maxSpeed;
        this.accel = accel;

        float x;
        float y;
        float width;
        float height;

        switch (side) {
            case LEFT:
                height = length;
                width = thickness;
                x = 0;
                y = board.getHeight() / 2 - height / 2;
                break;
            case RIGHT:
                height = length;
                width = thickness;
                x = board.getWidth() - width;
                y = board.getHeight() / 2 - height / 2;
                break;
            default:
                x = 0;
                y = 0;
                width = 0;
                height = 0;
                System.err.println("Error: Invalid Paddle Side");
        }

        rect = new Rectangle(x, y, width, height);
    }

    public void draw(ShapeRenderer renderer) {
        renderer.setColor(0, 1, 0,1);
        Vector2 pos = board.transformCoord(new Vector2(rect.getX(), rect.getY()));
        renderer.rect(pos.x, pos.y, rect.getWidth(), rect.getHeight());
    }

    public void update() {
        // If we are pressing a key, change the velocity
        if (input.isForwardPressed()) {
            velocity += accel;
            if (velocity > maxSpeed) {
                velocity = maxSpeed;
            }
        } else if (input.isBackwardsPressed()) {
            velocity -= accel;
            if (velocity < -maxSpeed) {
                velocity = -maxSpeed;
            }
        } else {
            if (velocity - accel > 0) {
                velocity -= accel;
            } else if (velocity + accel < 0) {
                velocity += accel;
            } else {
                velocity = 0;
            }
        }

        // Calculate new position based on new velocity
        float newPos = rect.getY() + (velocity * Gdx.graphics.getDeltaTime());

        // Check for wall collisions
        if (newPos > Gdx.app.getGraphics().getHeight() - rect.getHeight()) {
            newPos = Gdx.app.getGraphics().getHeight() - rect.getHeight();

            // Makes moving off walls much more natural
            velocity = 0;
        } else if (newPos < 0) {
            newPos = 0;

            // Makes moving off walls much more natural
            velocity = 0;
        }
        rect.setY(newPos);

    }

    public float getLength() {
        if (side == Side.LEFT || side == Side.RIGHT){
            return rect.getHeight();
        }

        if (side == Side.UP || side == Side.DOWN){
            return rect.getWidth();
        }

        return 0;
    }

    public float getX() {
        return rect.getX();
    }

    public float getY() {
        return rect.getY();
    }

    public boolean intersects(Ball ball) {
        Vector2 pos = new Vector2(ball.getPos());
        switch (side) {
            case LEFT:
                break;
            case RIGHT:
                pos.x += ball.getSide();
                break;
            case UP:
                pos.y += ball.getSide();
                break;
            case DOWN:
                break;
        }
        return this.rect.contains(pos);
    }

    public Side getSide() {
        return side;
    }
}
