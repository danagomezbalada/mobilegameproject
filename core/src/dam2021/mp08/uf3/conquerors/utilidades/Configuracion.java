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
    public static final float DISTANCIA_ENTRE_OBSTACULOS = 75;

    // Propiedades de los obstaculos
    //TODO : Modificar tamaños de cada obstáculo
    public static final float TAMAÑO_OBSTACULO_BOMBA = 35;
    public static final float TAMAÑO_OBSTACULO_RAMA = 35;
    public static final float TAMAÑO_OBSTACULO_AGUJERO = 35;

}