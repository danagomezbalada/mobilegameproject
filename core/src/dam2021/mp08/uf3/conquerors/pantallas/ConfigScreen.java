package dam2021.mp08.uf3.conquerors.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import dam2021.mp08.uf3.conquerors.Game;
import dam2021.mp08.uf3.conquerors.soporte.AssetManager;
import dam2021.mp08.uf3.conquerors.utilidades.Configuracion;

public class ConfigScreen implements Screen {

    //TODO: Creada pantalla de configuracion (para elegir personaje)

    final Game game;
    private Stage stage;

    private Label tituloLabel;
    private Label personaje1Label;
    private Label personaje2Label;
    private Label personaje3Label;
    private Label personaje4Label;

    public ConfigScreen(final Game game){
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

        // temporary until we have asset manager in
        Skin skin = new Skin(Gdx.files.internal("skin/flat-earth-ui.json"));

       //Personaje1 enabled/disabled
        final CheckBox personaje1Checkbox = new CheckBox(null, skin);
        personaje1Checkbox.setChecked(true);
        personaje1Checkbox.getImage().setScaling(Scaling.fill);
        personaje1Checkbox.getImageCell().size(70,70);
        personaje1Checkbox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                boolean enabled = personaje1Checkbox.isChecked();
                Configuracion.setRutaActual("img/personaje.png");
                AssetManager.load();
                return false;
            }
        });

        //Personaje2 enabled/disabled
        final CheckBox personaje2Checkbox = new CheckBox(null, skin);
        personaje2Checkbox.getImage().setScaling(Scaling.fill);
        personaje2Checkbox.getImageCell().size(70,70);
        personaje2Checkbox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                boolean enabled = personaje2Checkbox.isChecked();
                Configuracion.setRutaActual("img/personaje2.png");
                AssetManager.load();
                return false;
            }
        });

        //Personaje3 enabled/disabled
        final CheckBox personaje3Checkbox = new CheckBox(null, skin);
        personaje3Checkbox.getImage().setScaling(Scaling.fill);
        personaje3Checkbox.getImageCell().size(70,70);
        personaje3Checkbox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                boolean enabled = personaje3Checkbox.isChecked();
                Configuracion.setRutaActual("img/personaje3.png");
                AssetManager.load();
                return false;
            }
        });

        //Personaje4 enabled/disabled
        final CheckBox personaje4Checkbox = new CheckBox(null, skin);
        personaje4Checkbox.getImage().setScaling(Scaling.fill);
        personaje4Checkbox.getImageCell().size(70,70);
        personaje4Checkbox.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                boolean enabled = personaje4Checkbox.isChecked();
                Configuracion.setRutaActual("img/personaje4.png");
                AssetManager.load();
                return false;
            }
        });

        //Grupo de botones
        ButtonGroup buttonGroup = new ButtonGroup(personaje1Checkbox, personaje2Checkbox, personaje3Checkbox, personaje4Checkbox);
        buttonGroup.setMaxCheckCount(1);
        buttonGroup.setMinCheckCount(1);
        buttonGroup.setUncheckLast(true);

        //Volver al MenuScreen
        final TextButton volverButton = new TextButton("Volver", skin);
        volverButton.getStyle().font.getData().setScale(2.66f);
        volverButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MenuScreen(game));
                dispose();
            }
        });

        tituloLabel = new Label( "Personaje", skin, "title");
        personaje1Label = new Label( "Normal", skin, "button" );
        personaje2Label = new Label( "Violeta", skin, "button" );
        personaje3Label = new Label( "Verde", skin, "button" );
        personaje4Label = new Label( "Azul", skin, "button" );

        tituloLabel.getStyle().font.getData().setScale(1.66f);
        tituloLabel.getStyle().fontColor.set(1,1,1,1);

        personaje1Label.getStyle().fontColor.set(1,1,1,1);
        personaje2Label.getStyle().fontColor.set(1,1,1,1);
        personaje3Label.getStyle().fontColor.set(1,1,1,1);
        personaje4Label.getStyle().fontColor.set(1,1,1,1);

        table.row().pad(40, 0, 60, 0).size(300,200);
        table.add(tituloLabel);
        table.row().size(300,200);
        table.add(personaje1Label);
        table.add(personaje1Checkbox);
        table.row().size(300,200);
        table.add(personaje2Label);
        table.add(personaje2Checkbox);
        table.row().size(300,200);
        table.add(personaje3Label);
        table.add(personaje3Checkbox);
        table.row().size(300,200);
        table.add(personaje4Label);
        table.add(personaje4Checkbox);
        table.row().pad(60, 0, 40, 0).size(400,200);
        table.add(volverButton).colspan(5);
    }

    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

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

    }
}
