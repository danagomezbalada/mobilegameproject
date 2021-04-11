package dam2021.mp08.uf3.conquerors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import dam2021.mp08.uf3.conquerors.pantallas.MenuScreen;
import dam2021.mp08.uf3.conquerors.soporte.AssetManager;

public class Game extends com.badlogic.gdx.Game {
	public SpriteBatch batch;
	public Texture img;
	public BitmapFont font;
	public AssetManager assets;
	
	@Override
	public void create () {
		AssetManager.load();

		batch = new SpriteBatch();
		font = new BitmapFont();
		setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
		AssetManager.dispose();
		batch.dispose();
		font.dispose();
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
