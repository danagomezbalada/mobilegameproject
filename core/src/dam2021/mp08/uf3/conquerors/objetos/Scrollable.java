package dam2021.mp08.uf3.conquerors.objetos;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

import dam2021.mp08.uf3.conquerors.utilidades.Configuracion;

public class Scrollable extends Actor {

    private Vector2 posicion;
    private float velocidad;
    private float anchura, altura;
    private boolean fueraDePantalla;

    public Scrollable(float x, float y, float velocidad, float anchura, float altura){
        this.posicion = new Vector2(x, y);
        this.velocidad = velocidad;
        this.anchura = anchura;
        this.altura = altura;
        this.fueraDePantalla = false;
    }


    public float getAnchura() {
        return anchura;
    }

    public void setAnchura(float anchura) {
        this.anchura = anchura;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setPosicion(Vector2 posicion) {
        this.posicion = posicion;
    }

    public boolean isFueraDePantalla() {
        return fueraDePantalla;
    }

    public float getX(){
        return this.posicion.x;
    }

    /*public float getColaX(){
        return this.posicion.x + anchura;
    }*/

    public float getColaY(){ return this.posicion.y - altura; }

    public float getY(){
        return this.posicion.y;
    }

    public void act(float delta){
        //Eje Y
        this.posicion.y -= this.velocidad * delta;

        //True si esta fuera de pantalla
        if(getY() > Configuracion.ALTURA_JUEGO){
            this.fueraDePantalla = true;
        }

    }

    public void reset(float nuevaY){
        this.posicion.y = nuevaY;
        fueraDePantalla = false;
    }


}
