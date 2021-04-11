package dam2021.mp08.uf3.conquerors.soporte;

import com.badlogic.gdx.InputProcessor;

import dam2021.mp08.uf3.conquerors.objetos.Nativo;
import dam2021.mp08.uf3.conquerors.pantallas.GameScreen;

public class InputHandler implements InputProcessor {

    private Nativo nativo;
    private GameScreen pantalla;
    private int previaX = 0;

    public InputHandler(GameScreen pantalla){
        this.pantalla = pantalla;
        this.nativo = this.pantalla.getNativo();
    }


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) { ;
        this.previaX = screenX;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        System.out.println(screenX + " : " + previaX);
        if (this.previaX < screenX){
            this.nativo.irDerecha();
        }
        //Abajo - Derecha
        else{
            this.nativo.irIzquierda();
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
