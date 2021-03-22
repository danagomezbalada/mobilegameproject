package dam2021.mp08.uf3.conquerors.objetos;

import com.badlogic.gdx.math.Vector2;

import java.util.Random;

import dam2021.mp08.uf3.conquerors.utilidades.Configuracion;

public class Obstaculo extends Scrollable{

    private Random r = new Random();

    public Obstaculo(float x, float y, float velocidad, float anchura, float altura) {
        super(x, y, velocidad, anchura, altura);
        this.r = new Random();

    }

    public void reset(float nuevaX) {
        super.reset(nuevaX);

        float tamaño = nuevoTamañoObstaculo();
        setAnchura(tamaño);
        setAltura(tamaño);
        //valor Y
        Vector2 nuevaPos = nuevaPosicion(tamaño);
        setPosicion(nuevaPos);

    }

    private Vector2 nuevaPosicion(float tamaño) {
        return new Vector2(getX(), (int) (this.r.nextFloat() * (Configuracion.ALTURA_JUEGO - tamaño)));
    }

    private float nuevoTamañoObstaculo(){
        return (this.r.nextFloat() + Configuracion.TAMAÑO_MINIMO_OBSTACULO)
                * Configuracion.TAMAÑO_OBSTACULO;

    }
}
