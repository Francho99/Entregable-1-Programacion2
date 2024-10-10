package grantateti;

public class Juego {
    private static int cantAlias = 0;
    private static String[] aliases = new String[100];
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;
    private boolean juegoTerminado;

    public Juego(Jugador jugador1, Jugador jugador2) {
        this.tablero = new Tablero();
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.jugadorActual = jugador1;
        this.juegoTerminado = false;
    }
    
    public void jugar(){
        while (!juegoTerminado) {            
            //Mostrar Tablero
            //Jugada
            //Verificar
            //Cambiar turno
        }
    }
    
    
    
    //Getters y Setters
    
    public static String[] getAliases() {
        return aliases;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public static void setAliases(String alias){
        if (Juego.cantAlias < 100) {
            Juego.aliases[Juego.cantAlias] = alias;
        }
        Juego.cantAlias = Juego.cantAlias + 1;
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public void setJuegoTerminado(boolean juegoTerminado) {
        this.juegoTerminado = juegoTerminado;
    }
    
    
}
