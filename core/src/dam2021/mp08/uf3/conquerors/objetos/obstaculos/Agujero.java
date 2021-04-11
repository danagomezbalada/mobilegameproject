package dam2021.mp08.uf3.conquerors.objetos.obstaculos;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.graphics.g2d.Batch;

import dam2021.mp08.uf3.conquerors.objetos.Nativo;
import dam2021.mp08.uf3.conquerors.objetos.Obstaculo;
import dam2021.mp08.uf3.conquerors.soporte.AssetManager;

public class Agujero extends Obstaculo {
    public Agujero(float x, float y, float velocidad, float anchura, float altura) {
        super(x, y, velocidad, anchura, altura);
        this.hitboxCirc = new Circle();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.enableBlending();
        batch.draw(AssetManager.agujero, getX(), getY(),
                getAnchura(), getAltura());

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        this.hitboxCirc.set(getX()+getAnchura()/2,
                getY()+getAnchura()/2,
                getAnchura()/2);
    }

    @Override
    public boolean hayColision(Nativo nativo) {
        if(getX() <= nativo.getX() + nativo.getAnchura()) {
            return (Intersector.overlaps(this.getHitboxCirc(), nativo.getHitboxNativo()));
        }
        return false;
    }
}
