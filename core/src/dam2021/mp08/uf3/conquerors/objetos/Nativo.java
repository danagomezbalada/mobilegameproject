package dam2021.mp08.uf3.conquerors.objetos;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Random;

import dam2021.mp08.uf3.conquerors.soporte.AssetManager;
import dam2021.mp08.uf3.conquerors.utilidades.Configuracion;

public class Nativo extends Actor {

    private final int anchura;
    private final int altura;
    private final Vector2 posicion;
    private boolean estaSaltando;

    public static final float IZQUIERDA = Configuracion.CARRIL_IZQUIERDO;
    public static final float CENTRO = Configuracion.CARRIL_CENTRAL;
    public static final float DERECHA = Configuracion.CARRIL_DERECHO;

    private Random r = new Random();
    private float tiempo;

    public enum MovimientoActual {
        IZQUIERDA,
        DERECHA,
        NADA
    }

    public enum CarrilActual {
        IZQUIERDO,
        CENTRO,
        DERECHO
    }

    public static MovimientoActual movimientoActual;
    public static CarrilActual carrilActual;

    private final Rectangle hitbox;

    public Nativo(int anchura, int altura, float x, float y) {
        this.anchura = anchura;
        this.altura = altura;
        this.posicion = new Vector2(x, y);
        this.tiempo = r.nextFloat();

        this.hitbox = new Rectangle();

        movimientoActual = MovimientoActual.NADA;
        carrilActual = CarrilActual.CENTRO;


    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        //Coje la animacion del nativo
        super.draw(batch, parentAlpha);
        batch.draw((TextureRegion) AssetManager.animationPersonaje.getKeyFrame(this.tiempo), this.getX(), this.getY(), this.getAnchura(), this.getAltura());
    }

    @Override
    public void act(float delta) {
        this.tiempo+=delta;
        //Movimiento nativo
        if (movimientoActual == MovimientoActual.DERECHA) {
                if (carrilActual == CarrilActual.CENTRO) {
                    carrilActual = CarrilActual.DERECHO;
                    this.posicion.x = DERECHA - getAnchura()/2;
                    movimientoActual = MovimientoActual.NADA;
                } else if (carrilActual == CarrilActual.DERECHO) {
                    movimientoActual = MovimientoActual.NADA;
                } else if (carrilActual == CarrilActual.IZQUIERDO) {
                    carrilActual = CarrilActual.CENTRO;
                    this.posicion.x = CENTRO - getAnchura()/2;
                    movimientoActual = MovimientoActual.NADA;
                }
        }
            if(movimientoActual == MovimientoActual.IZQUIERDA) {
                if(carrilActual == CarrilActual.CENTRO) {
                    carrilActual = CarrilActual.IZQUIERDO;
                    this.posicion.x = IZQUIERDA - getAnchura()/2;
                    movimientoActual = MovimientoActual.NADA;
                } else if(carrilActual == CarrilActual.DERECHO) {
                    carrilActual = CarrilActual.CENTRO;
                    this.posicion.x = CENTRO - getAnchura()/2;
                    movimientoActual = MovimientoActual.NADA;
                } else if(carrilActual == CarrilActual.IZQUIERDO) {
                    movimientoActual = MovimientoActual.NADA;
                }
            }
        this.hitbox.set(getX() + getAnchura()/2,getY() + getAltura()/2,getAnchura()/2,getAltura()/2);
}

    public int getAnchura() {
        return anchura;
    }

    public int getAltura() {
        return altura;
    }

    public float getX() {
        return posicion.x;
    }

    public float getY() {
        return posicion.y;
    }

    public Rectangle getHitboxNativo() {
        return hitbox;
    }

    public void irIzquierda() {
        this.movimientoActual = MovimientoActual.IZQUIERDA;
    }

    public void irDerecha() {
        this.movimientoActual = MovimientoActual.DERECHA;
    }

    public void noMover() {
        this.movimientoActual = MovimientoActual.NADA;
    }
}
