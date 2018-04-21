package com.game.pong;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

//MULTIPLY X SPEED BY -1
public class Ball {
    //instance variables
    private GameBoard board;
    private Vector2 velocity;
    private float side;
    private float angle;

    //ctor
    public Ball(GameBoard board, float size) {
        velocity = new Vector2();
        angle = 0;
        side = size;
        this.board = board;
        velocity.setToRandomDirection();
    }

    public void updateAngle(Paddle paddle) {
        angle = (float) Math.asin((velocity.y - paddle.getY() + (paddle.getLength() / 2)) / (paddle.getLength() / 2));
    }

    public void updateSpeed() {
        velocity.rotateRad(angle);
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
        renderer.rect(velocity.x, velocity.y, side, side); //ball is a square
    }

    public GameBoard getBoard(){
        return board;
    }
}
