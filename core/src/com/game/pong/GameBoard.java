package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class GameBoard extends Board {
    private float side;
    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private Paddle upPaddle;
    private Paddle downPaddle;

    public GameBoard(float x, float y, float side){
        super(x, y, side, side);
        this.side = side;
        ball = new Ball(this, 10);
        leftPaddle = new Paddle(Side.LEFT, this, 49, 7.5f, 400, 35);
        rightPaddle = new Paddle(Side.RIGHT, this, 49, 7.5f, 400, 35);
        upPaddle = new Paddle(Side.UP, this, 49, 7.5f, 400, 35);
        downPaddle = new Paddle(Side.DOWN, this, 49, 7.5f, 400, 35);
    }

    @Override
    public void draw(ShapeRenderer renderer) {
        renderer.begin(ShapeRenderer.ShapeType.Filled);

        leftPaddle.draw(renderer);
        rightPaddle.draw(renderer);
        ball.draw(renderer);

        renderer.end();
    }

    @Override
    public void update(){
        leftPaddle.update();
        rightPaddle.update();
        upPaddle.update();
        downPaddle.update();


        if (leftPaddle.intersects(ball.getBoard().getRect())) {
            ball.updateAngle(leftPaddle);
            ball.updateSpeed();
        }else if (rightPaddle.intersects(ball.getBoard().getRect())) {
            ball.updateAngle(rightPaddle);
            ball.updateSpeed();
        }else if (upPaddle.intersects(ball.getBoard().getRect())) {
            ball.updateAngle(upPaddle);
            ball.updateSpeed();
        }else if (downPaddle.intersects(ball.getBoard().getRect())) {
            ball.updateAngle(downPaddle);
            ball.updateSpeed();
        }
    }

    /**Getter methods for the class GameBoard
     * Get sides, centers, or the entire rectangle itself
     * @return float, Rectangle(libgdx)
     */
    public float getSide(){
        return side;
    }

    public float getCen(){
        return side/2;
    }

    public Rectangle getRect(){
        return rect;
    }
}
