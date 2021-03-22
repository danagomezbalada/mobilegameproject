package dam2021.mp08.uf3.conquerors.objetos;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Nativo extends Actor {

    //Atributos del nativo
    private int anchura, altura, direccion;
    private Vector2 posicion;
    private boolean estaSaltando;

    //Direcciones del nativo
    public static final int IZQUIERDA =1;
    public static final int DERECHA =2;
    public static final int QUIETO =0;

    public Nativo(int anchura, int altura, float x, float y){
        //Inicializamos los parametros del nativo
        this.anchura = anchura;
        this.altura = altura;
        this.posicion = new Vector2(x,y);

        //Marcamos la direccion inicial
        this.direccion = QUIETO;

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    //Getters de los atributos principales
    public int getAnchura() { return anchura; }
    public int getAltura() { return altura; }
    public float getX() {
        return posicion.x;
    }
    public float getY() {
        return posicion.y;
    }

    //Cambios de direccion
    public void irIzquierda() {
        this.direccion = IZQUIERDA;
    }
    public void irDerecha() {
        this.direccion = DERECHA;
    }
    public void noMover() {
        this.direccion = QUIETO;
    }
}
