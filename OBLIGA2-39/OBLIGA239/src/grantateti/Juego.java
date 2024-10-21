package grantateti;

import java.util.Scanner;

public class Juego {
    private static int cantAlias = 0;
    private static  String[] aliases = new String[100];
    private int[] posicionAnterior = new int[2];
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
          int[] nuevaPosicion = obtenerPosicionJugador();

          ponerFicha(posicionAnterior, nuevaPosicion);
          actualizarPosicionAnterior(nuevaPosicion);
  
          System.out.println(tablero.toString());
  
          tablero.terminado();
  
          cambiarTurno();
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

    public void ponerFicha(int[] pos1, int[] pos2){
        this.tablero.minitablero(pos1, pos2, this.ficha());
    }
    

    //Se pasa el turno al siguiente jugador
    public void cambiarTurno(){
        if(this.jugadorActual == jugador1){
            this.setJugadorActual(jugador2);
        }else if(this.jugadorActual == jugador2){
            this.setJugadorActual(jugador1);
        }
    }

  

    // Método para obtener la posición del jugador
    public int[] obtenerPosicionJugador() {
        Scanner scanner = new Scanner(System.in);
        int[] posicion = new int[2];  // Para almacenar la fila y la columna
        
        System.out.println("Introduce las coordenadas donde quieres jugar (ej: A1, B2, etc.):");
    
        String entrada = scanner.nextLine().toUpperCase();
    
        while (entrada.length() != 2 || !Character.isLetter(entrada.charAt(0)) || !Character.isDigit(entrada.charAt(1))) {
            System.out.println("Entrada inválida. Por favor introduce una coordenada válida (ej: A1, B2, etc.):");
            entrada = scanner.nextLine().toUpperCase();
        }
    
        char fila = entrada.charAt(0);
        if (fila == 'A'){
            posicion[0] = 0;
        } else if (fila == 'B') {
            posicion[0] = 1;
        } else if (fila == 'C') {
            posicion[0] = 2;
        } else {
       
            System.out.println("Jugada no válida, elige otra fila (A, B o C):");
            return obtenerPosicionJugador();
        }
    
       
        char columna = entrada.charAt(1);
        posicion[1] = Character.getNumericValue(columna) - 1;  
    
        // Validar si las coordenadas están dentro de los límites
        if (posicion[0] < 0 || posicion[0] > 2 || posicion[1] < 0 || posicion[1] > 2) {
            System.out.println("Coordenadas fuera de los límites. Inténtalo de nuevo.");
            return obtenerPosicionJugador();  // Llamamos de nuevo para pedir las coordenadas correctas
        }
    
        return posicion;  // Devolver las coordenadas correctas
    }

    public void destacarMinitablero() {
        int fila = posicionAnterior[0];
        int columna = posicionAnterior[1];
    
        // Accedes al minitablero correcto usando las coordenadas (fila, columna)
        Minitablero minitableroActual = tablero.obtenerMinitablero(fila, columna);
    
        // Llamas al método que cambia el borde del minitablero a amarillo
        if (minitableroActual != null) {
            minitableroActual.BordeAmarillo();
        }
    }
    
    public void actualizarPosicionAnterior(int[] nuevaPosicion) {
        this.posicionAnterior = nuevaPosicion;
        tablero.setPosicionAnterior(nuevaPosicion);  // Ahora llamas a este método correctamente en el objeto Tablero
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
