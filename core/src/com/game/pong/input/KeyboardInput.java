package com.game.pong.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

/**
 * <>KeyboardInput.java</>
 * Takes inputs from the keyboard and interprets the method of the paddles.
 * @author David Baum
 * @version alpha
 * @since 5.22.2018
 */
public class KeyboardInput implements PaddleInput {
    private int forwards;
    private int backwards;

    public KeyboardInput(int forwards, int backwards) {
        this.forwards = forwards;
        this.backwards = backwards;
    }

    @Override
    public boolean isForwardPressed() {
        return Gdx.input.isKeyPressed(forwards);
    }

    @Override
    public boolean isBackwardsPressed() {
        return Gdx.input.isKeyPressed(backwards);
    }
}
