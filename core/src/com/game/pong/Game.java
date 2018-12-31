package com.game.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.game.pong.network.NetworkManager;
import com.game.pong.screen.GameScreen;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Game extends com.badlogic.gdx.Game {
	ShapeRenderer shapeRenderer;

	Screen gameScreen;

	NetworkManager client;

	@Override
	public void create () {
	    client = new NetworkManager();
		try {
			client.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}

		shapeRenderer = new ShapeRenderer();

		gameScreen = new GameScreen();
		setScreen(gameScreen);
	}

	@Override
	public void render () {
		screen.render(Gdx.graphics.getDeltaTime());

		client.sendPacket();
	}

	@Override
	public void dispose () {
		shapeRenderer.dispose();

		gameScreen.dispose();
	}
}
