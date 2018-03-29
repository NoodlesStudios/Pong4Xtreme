package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import java.util.*;

//MULTIPLY X SPEED BY -1
public class Ball{
    //instance variables
    private Vector2 pos;
    private Random random;
    private float side;
    private float angle;
    private float xSpeed;
    private float ySpeed;

    //ctor
    public Ball(){
        vector2 = new Vector2();
        //random = new Random();
        angle = 0;
        xSpeed = 10000;
        ySpeed = 0;
    }

    public void updateAngle(Paddle paddle){
        angle = (float)Math.asin((pos.y-paddle.getYPos() + (paddle.getLength()/2)) / (paddle.getLength()/2));
    }

    public void updateSpeed(Paddle paddle){
        xSpeed;
        ySpeed;
    }

    public boolean hasHitPaddle(Paddle paddle){
        if (ball.x + ball.length() > paddle.x && ball.x < paddle.x + paddle.length()){
            updateAngle(paddle);
            return true;
        }else return false;
    }

    public void draw(ShapeRenderer renderer){
        renderer.setColor(0,1,0,1);
        renderer.rect(pos.x,pos.y,side,side); //ball is a square
    }


}