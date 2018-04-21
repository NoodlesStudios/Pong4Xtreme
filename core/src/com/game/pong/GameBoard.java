package com.game.pong;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.game.pong.input.KeyboardInput;

public class GameBoard extends Board {
    private float size;
    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private Paddle upPaddle;
    private Paddle downPaddle;

    public GameBoard(float x, float y, float size){
        super(x, y, size, size);
        this.size = size;

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
        upPaddle.draw(renderer);
        downPaddle.draw(renderer);
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

        if (leftPaddle.intersects(ball)) {
            ball.updateAngle(leftPaddle);
        } else if (rightPaddle.intersects(ball)) {
            ball.updateAngle(rightPaddle);
        } else if (upPaddle.intersects(ball)) {
            ball.updateAngle(upPaddle);
        } else if (downPaddle.intersects(ball)) {
            ball.updateAngle(downPaddle);
        }
    }

    /**Getter methods for the class GameBoard
     * Get sides, centers, or the entire rectangle itself
     * @return float, Rectangle(libgdx)
     */
    public float getSize(){
        return size;
    }

    public float getCen(){
        return size /2;
    }

    public Rectangle getRect(){
        return rect;
    }
}
