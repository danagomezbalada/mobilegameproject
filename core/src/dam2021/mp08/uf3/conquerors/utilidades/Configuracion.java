package dam2021.mp08.uf3.conquerors.utilidades;

public class Configuracion {

    //Tamaño del juego
    public static final int ANCHURA_JUEGO = 720;
    public static final int ALTURA_JUEGO = 1280;

    //Propiedades del nativo
    public static final int ANCHURA_NATIVO = 105;
    public static final int ALTURA_NATIVO = 175;
    public static final float VELOCIDAD_NATIVO = 525;
    public static final float X_INICIAL_NATIVO = ANCHURA_JUEGO/2 - ANCHURA_NATIVO/2;
    public static final float Y_INICIAL_NATIVO = ALTURA_JUEGO - 250;

    // Propiedades del fondo
    public static final float VELOCIDAD_FONDO = -100;
    public static final float VELOCIDAD_OBSTACULO = -150;
    public static final float DISTANCIA_ENTRE_OBSTACULOS = 565;

    // Propiedades de los obstaculos
    //TODO : Modificar tamaños de cada obstáculo
    public static final float TAMAÑO_OBSTACULO_BOMBA = 35;
    public static final float TAMAÑO_ANCHURA_OBSTACULO_RAMA = 35;
    public static final float TAMAÑO_ALTURA_OBSTACULO_RAMA = 115;
    public static final float TAMAÑO_OBSTACULO_AGUJERO = 75;

    //Carriles
    public static final float CARRIL_IZQUIERDO = ANCHURA_JUEGO/4;
    public static final float CARRIL_CENTRAL = ANCHURA_JUEGO/2;
    public static final float CARRIL_DERECHO = ANCHURA_JUEGO/1.333333333333f;

}