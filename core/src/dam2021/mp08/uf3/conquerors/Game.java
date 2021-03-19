package dam2021.mp08.uf3.conquerors;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dam2021.mp08.uf3.conquerors.pantallas.GameScreen;
import dam2021.mp08.uf3.conquerors.soporte.AssetManager;

public class Game extends com.badlogic.gdx.Game {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		AssetManager.load();

		setScreen(new GameScreen());

	}

	@Override
	public void render () {

	}
	
	@Override
	public void dispose () {
		super.dispose();
		AssetManager.dispose();
	}


	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
