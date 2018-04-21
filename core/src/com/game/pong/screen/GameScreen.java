package com.game.pong.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game.pong.GameBoard;
import com.game.pong.ScoreBoard;

public class GameScreen implements Screen {

    ShapeRenderer renderer;
    public SpriteBatch batch;
    public BitmapFont font;

    GameBoard gameBoard;
    ScoreBoard scoreBoard;


    public GameScreen() {
        renderer = new ShapeRenderer();
        batch = new SpriteBatch();
        font = new BitmapFont();

        gameBoard = new GameBoard(0, 0, 600);
        scoreBoard = new ScoreBoard(600, 0, 200, 600, this);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        gameBoard.update();
        scoreBoard.update();

        Gdx.gl20.glClearColor(0, 0, 0, 0);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);



        gameBoard.draw(renderer);

        batch.begin();
        scoreBoard.draw(renderer);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        renderer.dispose();
        batch.dispose();
        font.dispose();
    }
}
