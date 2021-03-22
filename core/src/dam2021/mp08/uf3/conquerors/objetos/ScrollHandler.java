package dam2021.mp08.uf3.conquerors.objetos;

import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.ArrayList;
import java.util.Random;

import dam2021.mp08.uf3.conquerors.utilidades.Configuracion;

public class ScrollHandler extends Group {

    private Background background, background_back;
    private int numObstaculos;
    private ArrayList<Obstaculo> obstaculos;
    private Random r;

    public ScrollHandler() {
        //x, y, velocidad, anchura, altura
        this.background = new Background(0, 0, Configuracion.VELOCIDAD_FONDO,
                Configuracion.ANCHURA_JUEGO * 2, Configuracion.ALTURA_JUEGO);
        this.background_back = new Background(this.background.getColaX(), 0, Configuracion.VELOCIDAD_FONDO,
                Configuracion.ANCHURA_JUEGO * 2, Configuracion.ALTURA_JUEGO);

        addActor(background);
        addActor(background_back);

        //Obstaculos
        this.r = new Random();
        this.numObstaculos = 3;
        this.obstaculos = new ArrayList<Obstaculo>();
        float tamaño = nuevoTamañoObstaculo();

        Obstaculo obstaculo = new Obstaculo(Configuracion.ANCHURA_JUEGO,
                posicionYObstaculo(tamaño),
                Configuracion.VELOCIDAD_OBSTACULO, tamaño, tamaño);
        this.obstaculos.add(obstaculo);
        addActor(obstaculo);

        for (int i = 1; i < numObstaculos; i++){
            tamaño = nuevoTamañoObstaculo();
            Obstaculo o = new Obstaculo(
                    obstaculos.get(obstaculos.size() - 1).getColaX() + Configuracion.DISTANCIA_ENTRE_OBSTACULOS,
                    posicionYObstaculo(tamaño),
                    Configuracion.VELOCIDAD_OBSTACULO, tamaño, tamaño);
            this.obstaculos.add(o);
            addActor(o);
        }
    }

    public ArrayList<Obstaculo> getObstaculos() {
        return obstaculos;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        //Comprobar si algun elemento se ha salido de pantalla
        if(background.isFueraDePantalla()) {
            background.reset(background_back.getColaX());
        } else if (background_back.isFueraDePantalla()){
            background_back.reset(background.getColaX());
        }

        for (int i = 0; i < obstaculos.size(); i++) {
            Obstaculo a = obstaculos.get(i);
            if(a.isFueraDePantalla()){
                if(i==0){
                    a.reset(obstaculos.get(obstaculos.size()-1).getColaX()
                            + Configuracion.DISTANCIA_ENTRE_OBSTACULOS);
                }else{
                    a.reset(obstaculos.get(i-1).getColaX()
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
