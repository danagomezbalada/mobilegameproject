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
        fuente = new BitmapFont(Gdx.files.internal("fonts/mono_syne.fnt"),
                Gdx.files.internal("fonts/mono_syne.png"), true);
        fuente.getData().setScale(1.5f,1);

        texturaBackground = new Texture(Gdx.files.internal("img/background.png"));
        texturaBomba = new Texture(Gdx.files.internal("img/bomb.png"));
        texturaRama = new Texture(Gdx.files.internal("img/branch.png"));
        texturaAgujero = new Texture(Gdx.files.internal("img/hole.png"));

        personajeQuieto = new TextureRegion();
        texturaPersonaje = new Texture(Gdx.files.internal(Configuracion.rutaActual));

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


        fonsDePantalla = new TextureRegion(texturaBackground, 0, 0, Configuracion.ANCHURA_JUEGO, Configuracion.ALTURA_JUEGO);
        bomba = new TextureRegion(texturaBomba, 0,0, 100, 130);
        bomba.flip(false, true);
        rama = new TextureRegion(texturaRama, 0, 0, 130, 100);
        agujero = new TextureRegion(texturaAgujero, 0, 0, 90, 90);

    }

    public static void dispose() {

    }
}
