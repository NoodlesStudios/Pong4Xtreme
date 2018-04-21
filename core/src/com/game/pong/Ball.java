package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import static com.badlogic.gdx.Gdx.graphics;

//MULTIPLY X SPEED BY -1
public class Ball {
    //instance variables
    private GameBoard board;
    private Vector2 velocity;
    private Vector2 pos;
    private float side;
    private float angle;
    private Rectangle rect;

    //ctor
    public Ball(GameBoard board, float size, float x, float y) {
        velocity = new Vector2();
        pos = new Vector2(x,y);
        angle = 0;
        side = size;
        rect = new Rectangle(x, y, side, side);
        this.board = board;
        velocity.setToRandomDirection();
        velocity.setLength(100);
    }

    public void updateAngle(Paddle paddle) {
        angle = (float) Math.asin((velocity.y - paddle.getY() + (paddle.getLength() / 2)) / (paddle.getLength() / 2));
        velocity.rotateRad(angle);
    }

    public void updatePos() {
        rect.setPosition(pos.add(velocity.scl(Gdx.graphics.getDeltaTime())));
    }

    public boolean hasHitWall(){
        if (velocity.x > board.getSide() || velocity.x < 0){
            return true;
        }else if (velocity.y > board.getSide() || velocity.y < 0){
            return true;
        }else return false;
    }

    public void draw(ShapeRenderer renderer) {
        renderer.setColor(0, 1, 0, 1);
        Vector2 transformed = board.transformCoord(new Vector2(rect.getX(), rect.getY()));
        renderer.rect(transformed.x, transformed.y, rect.getWidth(), rect.getHeight());
    }

    public GameBoard getBoard(){
        return board;
    }

    public Rectangle getRect(){
        return rect;
    }
}
