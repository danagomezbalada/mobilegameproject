package dam2021.mp08.uf3.conquerors.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import javax.swing.event.ChangeEvent;

import dam2021.mp08.uf3.conquerors.Game;
import dam2021.mp08.uf3.conquerors.soporte.AssetManager;

public class MenuScreen implements Screen {

    //TODO: Creada pantalla del menu principal (botones funcionales y background)

    final Game game;
    private Stage stage;

    public MenuScreen(final Game game) {
        this.game = game;

        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void show() {
        //Crea una tabla que llena la pantalla
        Table table = new Table();
        table.setBackground(new TextureRegionDrawable(new TextureRegion(new Texture("img/background.png"))));
        table.setFillParent(true);
        //table.setDebug(true);
        stage.addActor(table);

        Skin skin = new Skin(Gdx.files.internal("skin/flat-earth-ui.json"));

        //Crea los botones i los añade a la tabla
        TextButton nuevaPartida = new TextButton("Nueva Partida", skin);
        TextButton configuracion = new TextButton("Configuracion", skin);
        TextButton salir = new TextButton("Salir", skin);

        nuevaPartida.getStyle().font.getData().setScale(2.66f);
        configuracion.getStyle().font.getData().setScale(2.66f);
        salir.getStyle().font.getData().setScale(2.66f);

        table.row().size(600,200);
        table.add(nuevaPartida).fillX().uniformX();
        table.row().pad(40, 0, 40, 0).size(600,200);
        table.add(configuracion).fillX().uniformX();
        table.row().size(600,200);
        table.add(salir).fillX().uniformX();

        //Funciones de los botones
        nuevaPartida.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new GameScreen(game));
                dispose();
            }
        });

        configuracion.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new ConfigScreen(game));
                dispose();
            }
        });

        salir.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();

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
        stage.dispose();
    }
}

