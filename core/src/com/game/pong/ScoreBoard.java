package com.game.pong;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.game.pong.screen.GameScreen;

public class ScoreBoard extends Board {
    private static final int NUM_SCORES = 4;

    private GameScreen screen;
    private int[] scores;
    private Vector2[] pos;

    public ScoreBoard(float x, float y, float width, float height, GameScreen screen) {
        super(x, y, width, height);

        this.screen = screen;
        scores = new int[NUM_SCORES];
        pos = new Vector2[NUM_SCORES];
        for (int i = 0; i < NUM_SCORES; i++) {
            pos[i] = new Vector2(30, getHeight() - ((i + 1) * 60));
        }
    }

    @Override
    public void draw(ShapeRenderer renderer) {
        screen.font.setColor(Color.WHITE);
        for(int i = 0; i < NUM_SCORES; i++) {
            Vector2 scorePos = transformCoord(pos[i]);
            screen.font.draw(screen.batch, "Player " + (i + 1), scorePos.x, scorePos.y);
            screen.font.draw(screen.batch, "" + scores[i], scorePos.x, scorePos.y - 30);
        }
    }

    @Override
    public void update() {

    }
}
