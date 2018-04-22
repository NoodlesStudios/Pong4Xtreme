package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

//MULTIPLY X SPEED BY -1
public class Ball {
    //instance variables
    private GameBoard board;
    private Vector2 velocity;
    private Vector2 pos;
    private float size;
    private float angle;

    //ctor
    public Ball(GameBoard board, float size, float x, float y) {
        velocity = new Vector2();
        pos = new Vector2(x,y);
        angle = 0;
        this.size = size;
        this.board = board;
        velocity.setToRandomDirection();
        velocity.setLength(100);
    }

    public void reset() {
        pos = new Vector2(board.getWidth() / 2 - getSize() / 2, board.getHeight() / 2 - getSize() / 2);
        velocity.setToRandomDirection();
        velocity.setLength(100);
    }

    public void updateAngle(Paddle paddle) {
        float ballY = pos.y;
        if (ballY < paddle.getY()) {
            ballY += size;
        }
        angle = (float) Math.asin((ballY - (paddle.getY() + (paddle.getLength() / 2))) / (paddle.getLength() / 2));

        if (paddle.getSide() == Side.RIGHT) {
            angle += Math.PI;
        }
        velocity.setAngleRad(angle);
    }

    public void updatePos() {
        Vector2 scaledVel = new Vector2(this.velocity);
        scaledVel.scl(Gdx.graphics.getDeltaTime());
        pos.add(scaledVel);
    }

    public boolean hasHitWall(){
        if (velocity.x > board.getSize() || velocity.x < 0){
            return true;
        }else if (velocity.y > board.getSize() || velocity.y < 0){
            return true;
        }else return false;
    }

    public void draw(ShapeRenderer renderer) {
        renderer.setColor(0, 1, 0, 1);
        Vector2 transformed = board.transformCoord(pos);
        renderer.rect(transformed.x, transformed.y, size, size);
    }

    public Vector2 getPos() {
        return pos;
    }

    public float getSize() {
        return size;
    }
}
