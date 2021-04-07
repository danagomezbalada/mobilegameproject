package dam2021.mp08.uf3.conquerors.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import java.util.ArrayList;

import dam2021.mp08.uf3.conquerors.objetos.Nativo;
import dam2021.mp08.uf3.conquerors.objetos.Obstaculo;
import dam2021.mp08.uf3.conquerors.objetos.ScrollHandler;
import dam2021.mp08.uf3.conquerors.soporte.InputHandler;
import dam2021.mp08.uf3.conquerors.utilidades.Configuracion;


public class GameScreen implements Screen {

    private Nativo nativo;
    private ScrollHandler scrollHandler;
    private Stage stage;

    private ShapeRenderer renderizadorDeFiguras;
    private Batch conjunto;


    public GameScreen() {
        this.renderizadorDeFiguras = new ShapeRenderer();
        OrthographicCamera camara = new OrthographicCamera(
                Configuracion.ANCHURA_JUEGO, Configuracion.ALTURA_JUEGO);

        //True para que haga servir la Y
        camara.setToOrtho(true);

        //Viewport para ver que hay en pantalla
        StretchViewport viewport = new StretchViewport(
                Configuracion.ANCHURA_JUEGO, Configuracion.ALTURA_JUEGO, camara);

        //Crear Stage i Actores
        this.stage = new Stage(viewport);
        this.conjunto = stage.getBatch();

        this.nativo = new Nativo(Configuracion.ANCHURA_NATIVO, Configuracion.ALTURA_NATIVO,
                Configuracion.X_INICIAL_NATIVO, Configuracion.Y_INICIAL_NATIVO);
        this.scrollHandler = new ScrollHandler();

        this.stage.addActor(this.nativo);
        this.stage.addActor(this.scrollHandler);

        //Gestor de entrada por pantalla
        Gdx.input.setInputProcessor(new InputHandler(this));

    }

    public Nativo getNativo() {
        return nativo;
    }

    public ScrollHandler getScrollHandler() {
        return scrollHandler;
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        this.stage.draw();
        this.stage.act(delta);
        //TODO: Añadir textura y eliminar dibujo de rectángulos
        if(scrollHandler.hayColision(nativo)) {
            Gdx.app.log("TOUCH", "NATIVO MUERTO");
        }
        dibujarElementos();
    }

    private void dibujarElementos() {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderizadorDeFiguras.setProjectionMatrix(
                conjunto.getProjectionMatrix());
        renderizadorDeFiguras.begin(ShapeRenderer.ShapeType.Filled);

        //Dibujamos al nativo
        renderizadorDeFiguras.setColor(new Color(1, 0, 0, 1));
        renderizadorDeFiguras.rect(nativo.getX(), nativo.getY(),
                nativo.getAnchura(), nativo.getAltura());

        //Dibujamos los obstaculos
        renderizadorDeFiguras.setColor(1, 1, 1, 1);
        ArrayList<Obstaculo> obstaculos = this.scrollHandler.getObstaculos();
        Obstaculo obstaculo;

        for (int i = 0; i < obstaculos.size(); i++){
            obstaculo = obstaculos.get(i);
            renderizadorDeFiguras.circle(
                    obstaculo.getX() + obstaculo.getAnchura()/2,
                    obstaculo.getY() + obstaculo.getAltura()/2,
                    obstaculo.getAnchura()/2);
        }
        renderizadorDeFiguras.end();
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

    }
}
