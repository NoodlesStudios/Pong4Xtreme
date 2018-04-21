package com.game.pong.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game.pong.GameBoard;

public class GameScreen implements Screen {

    ShapeRenderer renderer;

    GameBoard gameBoard;


    public GameScreen() {
        renderer = new ShapeRenderer();

        gameBoard = new GameBoard(0, 0, 600);
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        gameBoard.update();

        Gdx.gl20.glClearColor(0, 0, 0, 0);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        gameBoard.draw(renderer);
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
    }
}
