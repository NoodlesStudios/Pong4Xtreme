package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.util.*;

//MULTIPLY X SPEED BY -1
public class Ball {
    //instance variables
    private Rectangle rect;
    private Vector2 velocity;
    private float side;
    private float angle;

    //ctor
    public Ball(Board board, float size) {
        velocity = new Vector2();
        angle = 0;
        side = size;
        rect = new Rectangle(board.getCen(), board.getCen(), side, side);
        velocity.setToRandomDirection();
    }

    public void updateAngle(Paddle paddle) {
        angle = (float) Math.asin((velocity.y - paddle.getY() + (paddle.getLength() / 2)) / (paddle.getLength() / 2));
    }

    public void updateSpeed() {
        velocity.rotateRad(angle);
    }



    public boolean hasHitWall(){

    }

    public void draw(ShapeRenderer renderer) {
        renderer.setColor(0, 1, 0, 1);
        renderer.rect(velocity.x, velocity.y, side, side); //ball is a square
    }

    public Rectangle getRect(){
        return rect;
    }
}
