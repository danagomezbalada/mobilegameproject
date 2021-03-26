package dam2021.mp08.uf3.conquerors.objetos.obstaculos;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

import dam2021.mp08.uf3.conquerors.objetos.Nativo;
import dam2021.mp08.uf3.conquerors.objetos.Obstaculo;

public class Agujero extends Obstaculo {
    public Agujero(float x, float y, float velocidad, float anchura, float altura) {
        super(x, y, velocidad, anchura, altura);
        this.hitboxCirc = new Circle();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        //TODO: Asignar medidas del obstaculo a la hitbox
    }

    @Override
    public boolean hayColision(Nativo nativo) {
        if(getX() <= nativo.getX() + nativo.getAnchura()) {
            return (Intersector.overlaps(this.getHitboxCirc(), nativo.getHitboxNativo()));
        }
        return false;
    }
}
