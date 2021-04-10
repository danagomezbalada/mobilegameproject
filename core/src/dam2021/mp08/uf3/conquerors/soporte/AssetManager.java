package dam2021.mp08.uf3.conquerors.soporte;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import dam2021.mp08.uf3.conquerors.utilidades.Configuracion;

public class AssetManager {

    public static BitmapFont fuente;

    public static TextureRegion personajeQuieto, fonsDePantalla, bomba, rama, agujero;

    public static TextureRegion[] personaje;
    public static Animation animationPersonaje;

    public static Texture texturaBackground, texturaBomba, texturaRama, texturaAgujero, texturaPersonaje; //texture sheet

    public AssetManager() {

    }


    public static void load() {
        //TODO: Cambiado tipo y tamaño de fuente (para mostrar puntos)
        fuente = new BitmapFont(Gdx.files.internal("fonts/mono_syne.fnt"),
                Gdx.files.internal("fonts/mono_syne.png"), true);
        fuente.getData().setScale(1.5f,1);

        texturaBackground = new Texture(Gdx.files.internal("img/background.png"));
        texturaBomba = new Texture(Gdx.files.internal("img/bomb.png"));
        texturaRama = new Texture(Gdx.files.internal("img/branch.png"));
        texturaAgujero = new Texture(Gdx.files.internal("img/hole.png"));

        personajeQuieto = new TextureRegion();
        //TODO: Cambiada ruta de imagen (coje la de Configuracion)
        texturaPersonaje = new Texture(Gdx.files.internal(Configuracion.rutaActual));

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
                explosions[indecccccccccccccccccccccccccx - 1].flip(false, true);
            }
        }

        animationExplosio = new Animation(0.04f, explosions);
        animationExplosio.setPlayMode(Animation.PlayMode.NORMAL);
*/
        //Imagen nativo
        personaje = new TextureRegion[8];

        for(int i=0; i<(personaje.length/2); i++){

            //Eso mueve el personaje para un lado
            personaje[i] = new TextureRegion(texturaPersonaje, i * 64, 0, 58, 63);
            personaje[i].flip(false, true);

            //Este para el otro lado
            personaje[i+(personaje.length/2)] = new TextureRegion(personaje[i]);
            personaje[i+(personaje.length/2)].flip(true, false);

        }

        // Animacion nativo, el primer numero del contructor animation es la velocidad de la animacion
        animationPersonaje = new Animation(0.10f, personaje);
        animationPersonaje.setPlayMode(Animation.PlayMode.LOOP_REVERSED);


        fonsDePantalla = new TextureRegion(texturaBackground, 0, 177, Configuracion.ANCHURA_JUEGO, Configuracion.ALTURA_JUEGO);
        bomba = new TextureRegion(texturaBomba, 0,205, 100, 130); //TODO: Asignar valores correctos de tamaño
        rama = new TextureRegion(texturaRama, 0, 200, 100, 130);
        agujero = new TextureRegion(texturaAgujero, 0, 30, 30, 30);
    }

    public static void dispose() {

    }
}
