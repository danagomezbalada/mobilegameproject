package dam2021.mp08.uf3.conquerors.utilidades;

public class Configuracion {

    // Mida del joc, automàticament s'escalarà
    public static final int ANCHURA_JUEGO = 240;
    public static final int ALTURA_JUEGO = 135;

    // Propietats de la nau
    public static final int ANCHURA_NATIU = 35;
    public static final int ALTURA_NATIVO = 15;
    public static final float VELOCIDAD_NATIVO = 150;
    public static final float X_INICIAL_NATIVO = 20;
    public static final float Y_INICIAL_NATIVO = ALTURA_JUEGO/2 - ALTURA_NATIVO/2;

    // Propietats del fons
    public static final float VELOCIDAD_FONDO = -100;

    // Propietats de l'asteroide
   //public static final float VELOCITAT_ASTEROIDE = -150;
    //public static final float MIDA_MAXIMA_ASTERIODE = 1.5f;
    //public static final float MIDA_MINIMA_ASTERIODE = 0.5f;
    public static final float MEDIDA_OBSTACULO = 35;
    public static final float DISTANCIA_ENTRE_OBSTACULOS = 75;
}