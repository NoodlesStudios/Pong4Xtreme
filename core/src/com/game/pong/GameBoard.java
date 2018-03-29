package com.game.pong;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameBoard extends Board {
    private Ball ball;
    private Paddle leftPaddle;

    public GameBoard(float x, float y, float side){
        super(x, y, side, side);
        ball = new Ball(this, 10);
        leftPaddle = new Paddle(Side.LEFT, 49, 7.5f, 400, 35);
    }

    @Override
    public void draw(ShapeRenderer renderer){
        renderer.setColor(Color.BLACK);
        renderer.rect()
    }

    @Override
    public void update(){
        if (leftPaddle.intersects(ball.getRect())) {
            ball.updateAngle(leftPaddle);
            ball.updateSpeed();
        }
    }
}
