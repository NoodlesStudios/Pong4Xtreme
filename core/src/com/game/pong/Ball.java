package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

//MULTIPLY X SPEED BY -1

/**
 * <>Ball.java</>
 * @author David Baum, Kairui Zhou
 * @version alpha
 * @since 5.22.2018
 */
public class Ball {
    //instance variables
    private GameBoard board;
    private Vector2 velocity;
    private Vector2 pos;
    private float size;
    private float angle;

    /**
     *
     * @param board
     * @param size
     * @param x
     * @param y
     */
    public Ball(GameBoard board, float size, float x, float y) {
        velocity = new Vector2();
        pos = new Vector2(x,y);
        angle = 0;
        this.size = size;
        this.board = board;
        velocity.setToRandomDirection();
        velocity.setLength(100);
    }

    /**
     * Resets the position of the ball back to the center and sets a random
     * velocity and direction.
     */
    public void reset() {
        pos = new Vector2(board.getWidth() / 2 - getSize() / 2, board.getHeight() / 2 - getSize() / 2);
        velocity.setToRandomDirection();
        velocity.setLength(100);
    }

    /**
     * Changes the angle of the paddle based on each collision with a paddle.
     * @param paddle
     */
    public void updateAngle(Paddle paddle) {
        float ballY = pos.y;
        float ballX = pos.x;
        if (ballY < paddle.getY()) {
            ballY += size;
        }
        if (ballX < paddle.getX()) {
            ballX += size;
        }
        if (paddle.getSide() == Side.LEFT) {
            angle = (float) Math.asin((ballY - (paddle.getY() + (paddle.getLength() / 2))) / (paddle.getLength() / 2));
        } else if (paddle.getSide() == Side.RIGHT) {
            angle = (float) (-(Math.asin((ballY - (paddle.getY() + (paddle.getLength() / 2))) / (paddle.getLength() / 2))) + Math.PI);
        } else if (paddle.getSide() == Side.UP){
            angle = (float) (Math.asin((ballX - (paddle.getX() + (paddle.getLength() / 2))) / (paddle.getLength() / 2)) + (3*Math.PI) / 2);
        } else if (paddle.getSide() == Side.DOWN){
            angle = (float) (-(Math.asin((ballX - (paddle.getX() + (paddle.getLength() / 2))) / (paddle.getLength() / 2))) + (Math.PI) / 2);
        }
        velocity.setAngleRad(angle);
    }

    /**
     * TODO
     */
    public void updatePos() {
        Vector2 scaledVel = new Vector2(this.velocity);
        scaledVel.scl(Gdx.graphics.getDeltaTime());
        pos.add(scaledVel);
    }

    /**
     * TODO
     * @return
     */
    public boolean hasHitWall(){
        if (velocity.x > board.getSize() || velocity.x < 0){
            return true;
        }else if (velocity.y > board.getSize() || velocity.y < 0){
            return true;
        }else return false;
    }

    /**
     * TODO
     * @param renderer
     */
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
