package grantateti;


public class GranTateti {
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador pc = new Computadora();
    private Juego juego;

    //Constructores dependiendo de que argumentos se le ingrese (Algo de polimorfismo por acá)
    public GranTateti(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.juego = new Juego(jugador1, jugador2);
    }

    public GranTateti(Jugador jugador1) {
        this.jugador1 = jugador1;
        this.juego = new Juego(jugador1, pc);
    }

    //Verificamos que la jugada esta bien ingresada
    public static boolean verificarJugada(String posicion){
        boolean esValida = false;
        char p1 = posicion.charAt(0);
        char p2 = posicion.charAt(1);
        if(p1 == 'A' || p1 == 'B' || p1 == 'C' && p2 == '1' || p2 == '2' || p2 == '3'){
            esValida = true;
        }
        return esValida;
    }
    //Transformamos la entrada "String" en un Array de posiciones
    public static int[] posiciones(String posicion){
        int pos1 = 0; int pos2 = 0;
        char p1 = posicion.charAt(0);
        char p2 = posicion.charAt(1);
        if(p2 == 'A'){
            pos1 = 0;
        }else if(p1 == 'B'){
            pos1 = 1;
        }else if(p1 == 'C'){
            pos1 = 2;
        }
        pos2 = (p2 - 0)-1; // En ASCII la diferencia entre el 0 al 9 son numericamente correctas y el -1 es para que realmente cumpla con el indice que se espera
        int[] coord = {pos1, pos2};
        return coord;
    }


    //Getters y Setters
    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Jugador getPc() {
        return pc;
    }

    public void setPc(Jugador pc) {
        this.pc = pc;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    

    
    
    


 
}
