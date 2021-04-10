package dam2021.mp08.uf3.conquerors.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import java.util.ArrayList;

import dam2021.mp08.uf3.conquerors.Game;
import dam2021.mp08.uf3.conquerors.objetos.Nativo;
import dam2021.mp08.uf3.conquerors.objetos.Obstaculo;
import dam2021.mp08.uf3.conquerors.objetos.ScrollHandler;
import dam2021.mp08.uf3.conquerors.objetos.obstaculos.Agujero;
import dam2021.mp08.uf3.conquerors.objetos.obstaculos.Bomba;
import dam2021.mp08.uf3.conquerors.objetos.obstaculos.Rama;
import dam2021.mp08.uf3.conquerors.soporte.AssetManager;
import dam2021.mp08.uf3.conquerors.soporte.InputHandler;
import dam2021.mp08.uf3.conquerors.utilidades.Configuracion;


public class GameScreen implements Screen {

    private Nativo nativo;
    private ScrollHandler scrollHandler;
    private Stage stage;

    private ShapeRenderer renderizadorDeFiguras;
    private Batch conjunto;

    final Game game;

    public GameScreen(final Game game) {
        this.game = game;

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


        this.stage.addActor(this.scrollHandler);
        this.stage.addActor(this.nativo);

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

        //TODO: Al chocar devuelve al menu principal
        //Si choca, vuelve al MenuScreen
        if(scrollHandler.hayColision(this.nativo)) {
            Gdx.app.log("TOUCH", "NATIVO MUERTO");
            game.setScreen(new MenuScreen(game));
            dispose();
        }
        dibujarElementos();

        //Incrementa la velocidad
        scrollHandler.aumentarVelocidad();
        scrollHandler.aumentarVelocidad();
    }
    private void dibujarElementos() {

        renderizadorDeFiguras.setProjectionMatrix(
                conjunto.getProjectionMatrix());
        renderizadorDeFiguras.begin(ShapeRenderer.ShapeType.Filled);

        //Dibujamos los obstaculos
        ArrayList<Obstaculo> obstaculos = this.scrollHandler.getObstaculos();
        Obstaculo obstaculo;

        for (int i = 0; i < obstaculos.size(); i++){
            obstaculo = obstaculos.get(i);
            //TODO: Cambiar colores de obstaculos por imagenes
            if (obstaculo instanceof Agujero){
                renderizadorDeFiguras.setColor(1, 1, 1, 1);
                renderizadorDeFiguras.circle(
                        obstaculo.getX() + obstaculo.getAnchura()/2,
                        obstaculo.getY() + obstaculo.getAltura()/2,
                        obstaculo.getAnchura()/2);
            }

            else if (obstaculo instanceof Bomba){
                renderizadorDeFiguras.setColor(0, 0, 1, 1);
                renderizadorDeFiguras.circle(
                        obstaculo.getX() + obstaculo.getAnchura()/2,
                        obstaculo.getY() + obstaculo.getAltura()/2,
                        obstaculo.getAnchura()/2);
            }

            else if (obstaculo instanceof Rama){
                renderizadorDeFiguras.setColor(1, 0, 0, 1);
                renderizadorDeFiguras.rect(obstaculo.getX(), obstaculo.getY(),
                        obstaculo.getAnchura(), obstaculo.getAltura());
            }
        }

        //TODO: Muestra los puntos actuales por pantalla durante el juego
        //Muestra los puntos actuales por pantalla
        BitmapFont puntos = game.assets.fuente;
        conjunto.begin();
        puntos.draw(conjunto,
                "PUNTOS: " + scrollHandler.getPuntos(), 5,
                stage.getViewport().getScreenY() + stage.getHeight() - puntos.getLineHeight());
        conjunto.end();
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
