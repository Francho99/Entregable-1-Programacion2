package grantateti;


public class Juego {
    private static int cantAlias = 0;
    private static  String[] aliases = new String[100];
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
            
            //Interfaz.mostrarTablero(); Esto es para imaginar el siguiente metodo jeje
            //Metodo para acceder al minitablero -- (Deberia tener variable con posiciones anteriores)
            Tablero tab = this.getTablero();
            int[] p1 = {1, 2};
            int[] p2 = {2, 0};
            tab.minitablero(p1, p2, ficha());
            System.out.println(tab);
            cambiarTurno();
            this.juegoTerminado = true;
        }
    }

   
    
    //Se asigna una ficha dependiendo que jugador esté en el turno
    public char ficha(){
        Jugador jugadorAct = this.getJugadorActual();
        char ficha = ' ';
        if(jugadorAct == jugador1){
            ficha = 'X';
        }
        if(jugadorAct == jugador2){
            ficha = 'O';
        }
        return ficha;
    }
    
    //this.getTablero().Metodo para eso
    //Se accede a un minitablero
    //Voy a pasar este metodo a Tablero posiblemente
    //public void minitableroActual(int[] posiciones){
    //    Tablero tablero = this.getTablero();
    //    Minitablero[][] tabloide = tablero.getTablero();
    //}

    //Se pasa el turno al siguiente jugador
    public void cambiarTurno(){
        if(this.jugadorActual == jugador1){
            this.setJugadorActual(jugador2);
        }else if(this.jugadorActual == jugador2){
            this.setJugadorActual(jugador1);
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
