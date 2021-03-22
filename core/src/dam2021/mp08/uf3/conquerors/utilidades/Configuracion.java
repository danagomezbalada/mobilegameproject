package dam2021.mp08.uf3.conquerors.utilidades;

public class Configuracion {

    // Mida del joc, automàticament s'escalarà
    public static final int ANCHURA_JUEGO = 1440;
    public static final int ALTURA_JUEGO = 2560;

    // Propietats de la nau
    public static final int ANCHURA_NATIVO = 35;
    public static final int ALTURA_NATIVO = 15;
    public static final float VELOCIDAD_NATIVO = 150;
    public static final float X_INICIAL_NATIVO = 20;
    public static final float Y_INICIAL_NATIVO = ALTURA_JUEGO/2 - ALTURA_NATIVO/2;

    // Propietats del fons
    public static final float VELOCIDAD_FONDO = -100;

    // Propietats de l'asteroide
    public static final float VELOCIDAD_OBSTACULO = -150;
    public static final float TAMAÑO_MAXIMO_OBSTACULO = 1.5f;
    public static final float TAMAÑO_MINIMO_OBSTACULO = 0.5f;
    public static final float TAMAÑO_OBSTACULO = 35;
    public static final float DISTANCIA_ENTRE_OBSTACULOS = 75;
}