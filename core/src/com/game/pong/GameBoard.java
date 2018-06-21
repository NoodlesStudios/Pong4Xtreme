package com.game.pong;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.game.pong.input.KeyboardInput;
import com.game.pong.screen.GameScreen;

public class GameBoard extends Board {
    GameScreen screen;
    private float size;
    private Ball ball;
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private Paddle upPaddle;
    private Paddle downPaddle;

    /**
     * TODO
     * @param x
     * @param y
     * @param size
     * @param screen
     */
    public GameBoard(float x, float y, float size, GameScreen screen){
        super(x, y, size, size);
        this.screen = screen;
        this.size = size;

        ball = new Ball(this, 10, this.getCen(), this.getCen());
        KeyboardInput leftInput = new KeyboardInput(Input.Keys.W, Input.Keys.S);
        KeyboardInput rightInput = new KeyboardInput(Input.Keys.UP, Input.Keys.DOWN);
        KeyboardInput upInput = new KeyboardInput(Input.Keys.D, Input.Keys.A);
        KeyboardInput downInput = new KeyboardInput(Input.Keys.RIGHT, Input.Keys.LEFT);

        leftPaddle = new Paddle(Side.LEFT, this, leftInput, 73, 7.5f, 400, 35);
        rightPaddle = new Paddle(Side.RIGHT, this, rightInput, 73, 7.5f, 400, 35);
        upPaddle = new Paddle(Side.UP, this, upInput, 73, 7.5f, 400, 35);
        downPaddle = new Paddle(Side.DOWN, this, downInput, 73, 7.5f, 400, 35);
    }

    /**
     * TODO
     * @param renderer
     */
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

    /**
     * TODO
     */
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

        boolean offScreen = false;
        if (ball.getPos().x + ball.getSize() < 0) { // LEFT
            screen.scoreBoard.incrementScore(0);
            offScreen = true;
        } else if (ball.getPos().x > getWidth()) { // RIGHT
            screen.scoreBoard.incrementScore(1);
            offScreen = true;
        } else if (ball.getPos().y + ball.getSize() < 0) { // DOWN
            screen.scoreBoard.incrementScore(2);
            offScreen = true;
        } else if (ball.getPos().y  > getHeight()) { // UP
            screen.scoreBoard.incrementScore(3);
            offScreen = true;
        }

        if (offScreen) {
            // Restart game
            ball.reset();
            leftPaddle.reset();
            rightPaddle.reset();
            upPaddle.reset();
            downPaddle.reset();
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
