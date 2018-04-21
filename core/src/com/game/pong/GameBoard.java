package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.game.pong.input.KeyboardInput;

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

        ball = new Ball(this, 10, this.getCen(), this.getCen());
        KeyboardInput leftInput = new KeyboardInput(Input.Keys.W, Input.Keys.S);
        KeyboardInput rightInput = new KeyboardInput(Input.Keys.UP, Input.Keys.DOWN);
        KeyboardInput upInput = new KeyboardInput(Input.Keys.D, Input.Keys.A);
        KeyboardInput downInput = new KeyboardInput(Input.Keys.RIGHT, Input.Keys.LEFT);

        leftPaddle = new Paddle(Side.LEFT, this, leftInput, 49, 7.5f, 400, 35);
        rightPaddle = new Paddle(Side.RIGHT, this, rightInput, 49, 7.5f, 400, 35);
        upPaddle = new Paddle(Side.UP, this, upInput, 49, 7.5f, 400, 35);
        downPaddle = new Paddle(Side.DOWN, this, downInput, 49, 7.5f, 400, 35);
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
        ball.updatePos();

//        if (leftPaddle.intersects(ball.getBoard().getRect())) {
//            ball.updateAngle(leftPaddle);
//        }else if (rightPaddle.intersects(ball.getBoard().getRect())) {
//            ball.updateAngle(rightPaddle);
//        }else if (upPaddle.intersects(ball.getBoard().getRect())) {
//            ball.updateAngle(upPaddle);
//        }else if (downPaddle.intersects(ball.getBoard().getRect())) {
//            ball.updateAngle(downPaddle);
//        }
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
