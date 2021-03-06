package dam2021.mp08.uf3.conquerors.objetos;

import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.ArrayList;
import java.util.Random;

import dam2021.mp08.uf3.conquerors.objetos.obstaculos.Agujero;
import dam2021.mp08.uf3.conquerors.objetos.obstaculos.Bomba;
import dam2021.mp08.uf3.conquerors.objetos.obstaculos.Rama;
import dam2021.mp08.uf3.conquerors.utilidades.Configuracion;

public class ScrollHandler extends Group {

    private Background background, background_back;
    private int numAgujeros, numBombas, numRamas;
    private ArrayList<Obstaculo> obstaculos;
    private Random r;
    private int puntos;

    public ScrollHandler() {
        this.background = new Background(0, 0, Configuracion.VELOCIDAD_FONDO,
                Configuracion.ANCHURA_JUEGO, Configuracion.ALTURA_JUEGO);
        this.background_back = new Background(0, this.background.getColaY(), Configuracion.VELOCIDAD_FONDO,
                Configuracion.ANCHURA_JUEGO, Configuracion.ALTURA_JUEGO);

        addActor(background);
        addActor(background_back);

        //Obstaculos
        this.r = new Random();
        this.numAgujeros = 3;
        this.numBombas = 2;
        this.numRamas = 5;
        this.obstaculos = new ArrayList<Obstaculo>();

        Obstaculo agujero = new Agujero(Configuracion.ANCHURA_JUEGO,
                0,
                Configuracion.VELOCIDAD_OBSTACULO, Configuracion.TAMAÑO_OBSTACULO_AGUJERO, Configuracion.TAMAÑO_OBSTACULO_AGUJERO);
        this.obstaculos.add(agujero);
        addActor(agujero);

        Obstaculo bomba = new Bomba(Configuracion.ANCHURA_JUEGO,
                0,
                Configuracion.VELOCIDAD_OBSTACULO, Configuracion.TAMAÑO_OBSTACULO_BOMBA, Configuracion.TAMAÑO_OBSTACULO_BOMBA);
        this.obstaculos.add(bomba);
        addActor(bomba);

        Obstaculo rama = new Agujero(Configuracion.ANCHURA_JUEGO,
                0,
                Configuracion.VELOCIDAD_OBSTACULO, Configuracion.TAMAÑO_ANCHURA_OBSTACULO_RAMA, Configuracion.TAMAÑO_ALTURA_OBSTACULO_RAMA);
        this.obstaculos.add(rama);
        addActor(rama);

        //Creacion de agujeros
        for (int i = 1; i < numAgujeros; i++){
            agujero = new Agujero(
                    posicionXObstaculo(agujero),
                    obstaculos.get(obstaculos.size() - 1).getColaYObstaculo() - Configuracion.DISTANCIA_ENTRE_OBSTACULOS,
                    Configuracion.VELOCIDAD_OBSTACULO, Configuracion.TAMAÑO_OBSTACULO_AGUJERO, Configuracion.TAMAÑO_OBSTACULO_AGUJERO);
            this.obstaculos.add(agujero);
            addActor(agujero);
        }
        //Creacion de bombas
        for (int i = 1; i < numBombas; i++){
            bomba = new Bomba(
                    posicionXObstaculo(bomba),
                    obstaculos.get(obstaculos.size() - 1).getColaYObstaculo() - Configuracion.DISTANCIA_ENTRE_OBSTACULOS,
                    Configuracion.VELOCIDAD_OBSTACULO, Configuracion.TAMAÑO_OBSTACULO_BOMBA, Configuracion.TAMAÑO_OBSTACULO_BOMBA);
            this.obstaculos.add(bomba);
            addActor(bomba);
        }

        //Creacion de ramas
        for (int i = 1; i < numRamas; i++){
            rama = new Rama(
                    posicionXObstaculo(rama),
                    obstaculos.get(obstaculos.size() - 1).getColaYObstaculo() - Configuracion.DISTANCIA_ENTRE_OBSTACULOS,
                    Configuracion.VELOCIDAD_OBSTACULO, Configuracion.TAMAÑO_ANCHURA_OBSTACULO_RAMA, Configuracion.TAMAÑO_ALTURA_OBSTACULO_RAMA);
            this.obstaculos.add(rama);
            addActor(rama);
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
            background.reset(this.background_back.getColaY());
        } else if (background_back.isFueraDePantalla()){
            background_back.reset(this.background.getColaY());
        }

        float lastYPos = 0;

        for (int i = 0; i < obstaculos.size(); i++) {
            Obstaculo o = obstaculos.get(i);
            if(o.isFueraDePantalla()){
                puntos++;
                if(i > 0 && i < 2){
                    o.reset(0 - lastYPos);
                    lastYPos = o.getY();
                }else{
                    o.reset(0 - lastYPos);
                    lastYPos = o.getY();
                }
            }
        }
    }

    public boolean hayColision(Nativo nativo) {
        for (Obstaculo o : this.obstaculos) {
            if(o.hayColision(nativo)) {
                return true;
            }
        }
        return false;
    }

    public int getPuntos(){
        return this.puntos;
    }

    public void aumentarVelocidad(){
        this.background.setVelocidad(this.background.getVelocidad()-0.001f);
        this.background_back.setVelocidad(this.background_back.getVelocidad()-0.001f);
        for (Obstaculo o : obstaculos)
            o.setVelocidad(o.getVelocidad()-0.001f);
    }

    private int posicionXObstaculo(Obstaculo o){
        return (int) (o.nuevaPosicion().x);
    }

}
