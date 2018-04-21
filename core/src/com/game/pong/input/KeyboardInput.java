package com.game.pong.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

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
