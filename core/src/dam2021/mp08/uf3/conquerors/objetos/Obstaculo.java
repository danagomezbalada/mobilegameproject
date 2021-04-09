package dam2021.mp08.uf3.conquerors.objetos;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

import java.security.cert.Certificate;
import java.util.Random;

import dam2021.mp08.uf3.conquerors.objetos.obstaculos.Agujero;
import dam2021.mp08.uf3.conquerors.objetos.obstaculos.Bomba;
import dam2021.mp08.uf3.conquerors.objetos.obstaculos.Rama;
import dam2021.mp08.uf3.conquerors.utilidades.Configuracion;

public abstract class Obstaculo extends Scrollable{

    private Random r;
    protected Rectangle hitboxRect;
    protected Circle hitboxCirc;

    private Circle circuloColision;
    private int carrilActual; //0 -> Izquierda  1 -> Centro  2 -> Derecha

    public Obstaculo(float x, float y, float velocidad, float anchura, float altura) {
        super(x, y, velocidad, anchura, altura);
        this.r = new Random();
        this.circuloColision = new Circle();
    }

    public void reset(float nuevaY) {
        super.reset(nuevaY);

        if (this instanceof Agujero){
            setAnchura(Configuracion.TAMAÑO_OBSTACULO_AGUJERO);
            setAltura(Configuracion.TAMAÑO_OBSTACULO_AGUJERO);
        } else if (this instanceof Bomba){
            setAnchura(Configuracion.TAMAÑO_OBSTACULO_BOMBA);
            setAltura(Configuracion.TAMAÑO_OBSTACULO_BOMBA);
        } else if (this instanceof Rama){
            setAnchura(Configuracion.TAMAÑO_ANCHURA_OBSTACULO_RAMA);
            setAltura(Configuracion.TAMAÑO_ALTURA_OBSTACULO_RAMA);
        }

        //valor X
        Vector2 nuevaPos = nuevaPosicion();
        setPosicion(nuevaPos);

    }

    public Vector2 nuevaPosicion() {
        int pos = r.nextInt(3);
        switch (pos) {
            case 0:
                carrilActual = 0;
                return new Vector2(Configuracion.CARRIL_IZQUIERDO - getAnchura()/2, 0 - Configuracion.DISTANCIA_ENTRE_OBSTACULOS);
            case 1:
                carrilActual = 1;
                return new Vector2(Configuracion.CARRIL_CENTRAL - getAnchura()/2, 0 - Configuracion.DISTANCIA_ENTRE_OBSTACULOS);
            case 2:
                carrilActual = 2;
                return new Vector2(Configuracion.CARRIL_DERECHO - getAnchura()/2, 0 - Configuracion.DISTANCIA_ENTRE_OBSTACULOS);
            default:
                carrilActual = 1;
                return new Vector2(Configuracion.CARRIL_CENTRAL - getAnchura()/2, 0 - Configuracion.DISTANCIA_ENTRE_OBSTACULOS);
        }
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        this.circuloColision.set(getX()+getAnchura()/2,
                getY()+getAnchura()/2,
                getAnchura()/2);

    }

    public Circle getHitboxCirc() {
        return hitboxCirc;
    }

    public Rectangle getHitboxRect() {
        return hitboxRect;
    }

    public Circle getCirculoColision() { return circuloColision; }

    public int getCarrilActual(){return carrilActual;}

    public boolean hayColision(Nativo nativo){
        if(getX() <= nativo.getX() + nativo.getAnchura()){
            return (Intersector.overlaps(this.circuloColision, nativo.getHitboxNativo()));
        }
        return false;

    }

}
