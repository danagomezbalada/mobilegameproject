package dam2021.mp08.uf3.conquerors.utilidades;

public class Configuracion {

    //Tamaño del juego
    public static final int ANCHURA_JUEGO = 1440;
    public static final int ALTURA_JUEGO = 2560;

    //Propiedades del nativo
    public static final int ANCHURA_NATIVO = 150;
    public static final int ALTURA_NATIVO = 350;
    public static final float VELOCIDAD_NATIVO = 1050;
    public static final float X_INICIAL_NATIVO = ANCHURA_JUEGO/2 - ANCHURA_NATIVO/2;
    public static final float Y_INICIAL_NATIVO = ALTURA_JUEGO - 500;

    // Propiedades del fondo
    public static final float VELOCIDAD_FONDO = -100;

    //Propiedades de los obstaculos
    public static final float VELOCIDAD_OBSTACULO = -150;
    public static final float TAMAÑO_MAXIMO_OBSTACULO = 1.5f;
    public static final float TAMAÑO_MINIMO_OBSTACULO = 0.5f;
    public static final float TAMAÑO_OBSTACULO = 70;
    public static final float DISTANCIA_ENTRE_OBSTACULOS = 145;
}