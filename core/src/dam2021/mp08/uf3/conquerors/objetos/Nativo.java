package dam2021.mp08.uf3.conquerors.objetos;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;

import dam2021.mp08.uf3.conquerors.soporte.AssetManager;
import dam2021.mp08.uf3.conquerors.utilidades.Configuracion;

public class Nativo extends Actor {

    private int anchura, altura, direccion;
    private Vector2 posicion;
    private boolean estaSaltando;

    public static final int IZQUIERDA =1; //Dalt
    public static final int DERECHA =2; //Baix
    public static final int QUIETO =0;

    private Random r = new Random();
    private float tiempo;

    public Nativo(int anchura, int altura, float x, float y){
        this.anchura = anchura;
        this.altura = altura;
        this.posicion = new Vector2(x,y);
        this.direccion = QUIETO;
        this.tiempo = r.nextFloat();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        //Coje la animacion del nativo
        super.draw(batch, parentAlpha);
        batch.draw((TextureRegion) AssetManager.animationPersonage.getKeyFrame(this.tiempo), this.getX(), this.getY(), this.getAnchura(), this.getAltura());

    }

    @Override
    public void act(float delta) {
        this.tiempo+=delta;
        //Movimiento nativo
        switch(this.direccion){
            case IZQUIERDA:
                if(this.posicion.y - Configuracion.VELOCIDAD_NATIVO * delta >= 0){
                    this.posicion.y -= Configuracion.VELOCIDAD_NATIVO * delta;
                }
                break;
            case DERECHA:
                if(this.posicion.y + this.altura + Configuracion.VELOCIDAD_NATIVO * delta <= Configuracion.ALTURA_JUEGO){
                    this.posicion.y += Configuracion.VELOCIDAD_NATIVO * delta;
                }
                break;
            case QUIETO:
                break;
        }

    }

    public int getAnchura() { return anchura; }
    public int getAltura() { return altura; }
    public float getX() {
        return posicion.x;
    }
    public float getY() {
        return posicion.y;
    }

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
