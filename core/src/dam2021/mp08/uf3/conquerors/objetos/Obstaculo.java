package dam2021.mp08.uf3.conquerors.objetos;

import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Obstaculo extends Scrollable{

    private Random r;

    public Obstaculo(float x, float y, float velocidad, float anchura, float altura) {
        super(x, y, velocidad, anchura, altura);
        this.r = new Random();

    }

    public void reset(float nuevaX) {
        //super.reset(nuevaX);

        //Tamaño nuevo obstaculo
        //float tamaño = novaMidaAsteroide();

        //Dimensiones nuevo obstaculo
        /*setAmplada(tamaño);
        setAltura(tamaño);*/


        //Modificamos su posicion (valor Y)
        /*Vector2 novaPos = novaPosicio(tamaño);
        setPosicio(novaPos);*/
    }

    private Vector2 nuevaPosicion(float tamaño) {
        //return new Vector2(getX(), (int) (this.r.nextFloat() * (Configuracio.ALCADA_JOC - mida)));
        return null;
    }

    private float nuevoTamañoObstaculo(){
        //return (this.r.nextFloat() + Configuracio.MIDA_MINIMA_ASTEROIDE) * Configuracio.MIDA_ASTEROIDE;
        return 0;
    }
}
