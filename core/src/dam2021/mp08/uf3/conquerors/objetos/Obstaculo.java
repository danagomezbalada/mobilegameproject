package dam2021.mp08.uf3.conquerors.objetos;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

import dam2021.mp08.uf3.conquerors.utilidades.Configuracion;
import sun.security.krb5.Config;

public abstract class Obstaculo extends Scrollable{

    private Random r;
    protected Rectangle hitboxRect;
    protected Circle hitboxCirc;

    public Obstaculo(float x, float y, float velocidad, float anchura, float altura) {
        super(x, y, velocidad, anchura, altura);
        this.r = new Random();
    }

    public void reset(float nuevaY) {
        super.reset(nuevaY);

        //TODO: Modificar y añadir diversos obstáculos
        float tamaño = Configuracion.TAMAÑO_OBSTACULO_AGUJERO;
        setAnchura(tamaño);
        setAltura(tamaño);
        //valor X
        Vector2 nuevaPos = nuevaPosicion(tamaño);
        setPosicion(nuevaPos);

    }

    //TODO: Cambiar a 3 posicions estáticas (3 carriles)
    public Vector2 nuevaPosicion(float tamaño) {
        int pos = r.nextInt(3);
        switch (pos) {
            case 0:
                return new Vector2(Configuracion.CARRIL_IZQUIERDO, 0);
            case 1:
                return new Vector2(Configuracion.CARRIL_CENTRAL, 0);
            case 2:
                return new Vector2(Configuracion.CARRIL_DERECHO, 0);
            default:
                return new Vector2(Configuracion.CARRIL_CENTRAL, 0);
        }
    }

    public Circle getHitboxCirc() {
        return hitboxCirc;
    }

    public Rectangle getHitboxRect() {
        return hitboxRect;
    }

    public abstract boolean hayColision(Nativo nativo);
}
