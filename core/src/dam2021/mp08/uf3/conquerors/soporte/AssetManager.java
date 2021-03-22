package dam2021.mp08.uf3.conquerors.soporte;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetManager {

    public static BitmapFont syneMono;

   /* public static Texture textura; //texture sheet

    //imatge nau
    public static TextureRegion nau, nauBaixa, nauDalt;
    public static TextureRegion fonsDePantalla;

    //asteroides
    public static TextureRegion[] asteroides;
    public static Animation animationAsteroides;

    //explosions
    public static TextureRegion[] explosions;
    public static Animation animationExplosio;*/

    public AssetManager() {

    }


    public static void load() {
        syneMono = new BitmapFont(Gdx.files.internal("/fonts/SyneMono-Regular.ttf"));
        /*textura = new Texture(Gdx.files.internal("sheet.png"));
        textura.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest); //filtre textura per que es vegi més nítida

        nau = new TextureRegion(textura, 0, 0, 36, 15);
        nau.flip(false, true);

        nauDalt = new TextureRegion(textura, 36, 0, 36, 15);
        nauDalt.flip(false, true);

        nauBaixa = new TextureRegion(textura, 72, 0, 36, 15);
        nauBaixa.flip(false, true);

        asteroides = new TextureRegion[16];
        for (int i = 0; i < asteroides.length; i++) {
            asteroides[i] = new TextureRegion(textura, i * 34, 15, 34, 34);
            asteroides[i].flip(false, true);
        }

        //animacio asteroides
        animationAsteroides = new Animation(0.05f, asteroides);
        animationAsteroides.setPlayMode(Animation.PlayMode.LOOP_REVERSED);

        explosions = new TextureRegion[16];

        int index = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                explosions[index++] = new TextureRegion(textura, j * 64, i * 64 + 49, 64, 64);
                explosions[index - 1].flip(false, true);
            }
        }

        animationExplosio = new Animation(0.04f, explosions);
        animationExplosio.setPlayMode(Animation.PlayMode.NORMAL);

        //fons
        fonsDePantalla = new TextureRegion(textura, 0, 177, 480, 135);*/
    }

    public static void dispose() {

    }
}
