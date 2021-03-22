package dam2021.mp08.uf3.conquerors.objetos;

import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.ArrayList;
import java.util.Random;

import dam2021.mp08.uf3.conquerors.utilidades.Configuracion;

public class ScrollHandler extends Group {

    private Background background, background_black;
    private int numAsteroides;
    private ArrayList<Obstaculo> asteroides;
    private Random r;

    public ScrollHandler() {
        //x, y, velocidad, anchura, altura
        this.background = new Background(0, 0, Configuracion.VELOCIDAD_FONDO,
                Configuracion.ANCHURA_JUEGO * 2, Configuracion.ALTURA_JUEGO);
        this.background_black = new Background(this.background.getColaX(), 0, Configuracion.VELOCIDAD_FONDO,
                Configuracion.ANCHURA_JUEGO * 2, Configuracion.ALTURA_JUEGO);

        addActor(background);
        addActor(background_black);

        //Obstaculos
        this.r = new Random();
        this.numAsteroides = 3;
        this.asteroides = new ArrayList<Obstaculo>();
        float mida = nuevoTamañoObstaculo();

        Obstaculo asteroide = new Obstaculo(Configuracion.ANCHURA_JUEGO,
                posicionYObstaculo(mida),
                Configuracion.VELOCIDAD_OBSTACULO, mida, mida);
        this.asteroides.add(asteroide);
        addActor(asteroide);

        for (int i  = 1; i < numAsteroides; i++){
            mida = nuevoTamañoObstaculo();
            Obstaculo a = new Obstaculo(
                    asteroides.get(asteroides.size() - 1).getColaX() + Configuracion.DISTANCIA_ENTRE_OBSTACULOS,
                    posicionYObstaculo(mida),
                    Configuracion.VELOCIDAD_OBSTACULO, mida, mida);
            this.asteroides.add(a);
            addActor(a);
        }
    }

    public ArrayList<Obstaculo> getObstaculos() {
        return asteroides;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        //Comprobar si algun elemento se ha salido de pantalla
        if(background.isFueraDePantalla()) {
            background.reset(background_black.getColaX());
        } else if (background_black.isFueraDePantalla()){
            background_black.reset(background.getColaX());
        }

        for (int i = 0; i < asteroides.size(); i++) {
            Obstaculo a = asteroides.get(i);
            if(a.isFueraDePantalla()){
                if(i==0){
                    a.reset(asteroides.get(asteroides.size()-1).getColaX()
                            + Configuracion.DISTANCIA_ENTRE_OBSTACULOS);
                }else{
                    a.reset(asteroides.get(i-1).getColaX()
                            + Configuracion.DISTANCIA_ENTRE_OBSTACULOS);
                }
            }
        }
    }

    private float nuevoTamañoObstaculo(){
        return (this.r.nextFloat() + Configuracion.TAMAÑO_MINIMO_OBSTACULO)
                * Configuracion.TAMAÑO_OBSTACULO;
    }

    private int posicionYObstaculo(float mida){
        return (int) (this.r.nextFloat() * (Configuracion.ALTURA_JUEGO - mida));
    }

}
