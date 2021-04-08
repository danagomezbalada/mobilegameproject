package dam2021.mp08.uf3.conquerors.objetos.obstaculos;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import dam2021.mp08.uf3.conquerors.objetos.Nativo;
import dam2021.mp08.uf3.conquerors.objetos.Obstaculo;
import dam2021.mp08.uf3.conquerors.soporte.AssetManager;

public class Rama extends Obstaculo {
    public Rama(float x, float y, float velocidad, float anchura, float altura) {
        super(x, y, velocidad, anchura, altura);
        this.hitboxRect = new Rectangle();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.disableBlending();
        batch.draw(AssetManager.rama, getX(), getY(),
                getAnchura(), getAltura());
        batch.enableBlending();
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        //TODO: Asignar medidas del obstaculo a la hitbox
    }

    @Override
    public boolean hayColision(Nativo nativo) {
        if(getX() <= nativo.getX() + nativo.getAnchura()) {
            return (Intersector.overlaps(this.getHitboxRect(), nativo.getHitboxNativo()));
        }
        return false;
    }
}
