package com.game.pong;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class ScoreBoard extends Board {

    int[] scores;
    Vector2[] positions;

    public ScoreBoard(float x, float y, float width, float height, int numPlayers) {
        super(x, y, width, height);

        scores = new int[numPlayers];

        int rows = numPlayers / 2;
    }

    @Override
    public void draw(ShapeRenderer renderer) {

    }

    @Override
    public void update() {

    }

    public void incrementScore(int player) {
        scores[player]++;
    }
}
