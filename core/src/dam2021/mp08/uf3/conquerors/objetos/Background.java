package dam2021.mp08.uf3.conquerors.objetos;

import com.badlogic.gdx.graphics.g2d.Batch;

import dam2021.mp08.uf3.conquerors.soporte.AssetManager;

public class Background extends Scrollable {

    public Background(float x, float y, float velocidad, float anchura, float altura) {
        super(x, y, velocidad, anchura, altura);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.disableBlending();
        //batch.draw(AssetManager.fonsDePantalla, getX(), getY(),
               // getAnchura(), getAltura());
        batch.enableBlending();

    }
}
