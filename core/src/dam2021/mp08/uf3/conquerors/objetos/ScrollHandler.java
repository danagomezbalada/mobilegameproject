package dam2021.mp08.uf3.conquerors.objetos;

import com.badlogic.gdx.scenes.scene2d.Group;

import java.util.ArrayList;
import java.util.Random;

import dam2021.mp08.uf3.conquerors.utilidades.Configuracion;

public class ScrollHandler extends Group {
        //TODO cambiar movimientos en vertical (van del reves abajo->arriba)
    private Background background, background_back;
    private int numObstaculos;
    private ArrayList<Obstaculo> obstaculos;
    private Random r;

    public ScrollHandler() {
        //x, y, velocidad, anchura, altura
        this.background = new Background(0, 0, Configuracion.VELOCIDAD_FONDO,
                Configuracion.ANCHURA_JUEGO, Configuracion.ALTURA_JUEGO);
        this.background_back = new Background(0, this.background.getColaY(), Configuracion.VELOCIDAD_FONDO,
                Configuracion.ANCHURA_JUEGO, Configuracion.ALTURA_JUEGO);

        addActor(background);
        addActor(background_back);

        //Obstaculos
        this.r = new Random();
        this.numObstaculos = 3;
        this.obstaculos = new ArrayList<Obstaculo>();
        //TODO: Diferentes tamaños por obstáculo
        float tamaño = Configuracion.TAMAÑO_OBSTACULO_RAMA;

        //TODO: Creación de obstaculos arreglar
        /*Obstaculo obstaculo = new Obstaculo(Configuracion.ANCHURA_JUEGO,
                posicionYObstaculo(tamaño),
                Configuracion.VELOCIDAD_OBSTACULO, tamaño, tamaño);
        this.obstaculos.add(obstaculo);
        addActor(obstaculo);*/

        //TODO: Corregir creación de múltiples obstáculos
        /*
        for (int i = 1; i < numObstaculos; i++){
            tamaño = nuevoTamañoObstaculo();
            Obstaculo o = new Obstaculo(
                    obstaculos.get(obstaculos.size() - 1).getColaY() + Configuracion.DISTANCIA_ENTRE_OBSTACULOS,
                    posicionYObstaculo(tamaño),
                    Configuracion.VELOCIDAD_OBSTACULO, tamaño, tamaño);
            this.obstaculos.add(o);
            addActor(o);
        }

         */
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



        for (int i = 0; i < obstaculos.size(); i++) {
            Obstaculo o = obstaculos.get(i);
            if(o.isFueraDePantalla()){
                if(i==0){
                    o.reset(obstaculos.get(obstaculos.size()-1).getColaY()
                            + Configuracion.DISTANCIA_ENTRE_OBSTACULOS);
                }else{
                    o.reset(obstaculos.get(i-1).getColaY()
                            + Configuracion.DISTANCIA_ENTRE_OBSTACULOS);
                }
            }
        }
    }

    public boolean hayColision(Nativo nativo) {
        //TODO: Añadir lista de obstáculos
        /*for (Obstaculo a : ) {
            if(a.hayColision(nativo)) {
                return true;
            }
        }*/
        return false;
    }


    //BORRADO MÉTODO NUEVO TAMAÑO OBSTÁCULO

    private int posicionYObstaculo(float mida){
        return (int) (this.r.nextFloat() * (Configuracion.ALTURA_JUEGO - mida));
    }

}
