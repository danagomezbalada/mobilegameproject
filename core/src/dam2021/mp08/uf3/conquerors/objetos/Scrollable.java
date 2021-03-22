package dam2021.mp08.uf3.conquerors.objetos;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Scrollable extends Actor {

    private Vector2 posicion;
    private float velocidad;
    private float anchura, altura;
    private boolean fueraDePantalla;

    public Scrollable(float x, float y, float velocidad, float amplada, float altura){
        this.posicion = new Vector2(x, y);
        this.velocidad = velocidad;
        this.anchura = amplada;
        this.altura = altura;
        this.fueraDePantalla = false;
    }


    public float getAnchura() {
        return anchura;
    }

    public float getAltura() {
        return altura;
    }

    public void setAnchura(float anchura) {
        this.anchura = anchura;
    }

    public Vector2 getPosicion() {
        return posicion;
    }

    public void setPosicion(Vector2 posicion) {
        this.posicion = posicion;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public boolean isFueraDePantalla() {
        return fueraDePantalla;
    }
    public float getX(){
        return this.posicion.x;
    }

    public float getColaX(){
        return this.posicion.x + anchura;
    }

    public float getY(){
        return this.posicion.y;
    }

    public void act(float delta){
        // Desplacem l'objecte per l'eix X
        this.posicion.x += this.velocidad * delta;

        // Si es troba fora la pantalla canviem la variable a veritat
        if(getColaX() < 0){
            this.fueraDePantalla = true;
        }

    }

    public void reset(float novaX){
        this.posicion.x = novaX;
        fueraDePantalla = false;
    }


}
