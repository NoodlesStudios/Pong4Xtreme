package com.game.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.game.pong.screen.GameScreen;

public class Game extends com.badlogic.gdx.Game {
	ShapeRenderer shapeRenderer;

	Screen gameScreen;

	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();

		gameScreen = new GameScreen();
		setScreen(gameScreen);
	}

	@Override
	public void render () {
		screen.render(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void dispose () {
		shapeRenderer.dispose();

		gameScreen.dispose();
	}
}
