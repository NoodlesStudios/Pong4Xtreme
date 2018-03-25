package com.game.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Game extends ApplicationAdapter {
	ShapeRenderer shapeRenderer;
	Paddle leftPaddle;
	
	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
		leftPaddle = new Paddle(Side.LEFT);

	}

	float x = 0;
	@Override
	public void render () {
		leftPaddle.update();


		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		leftPaddle.draw(shapeRenderer);
		shapeRenderer.end();
	}
	@Override
	public void dispose () {
		shapeRenderer.dispose();
	}
}
