package interfaz;

import grantateti.*;
import java.util.*;


public class Interfaz {
    public static ArrayList<Jugador> jugadores = new ArrayList<>();
    /*
    *Si bien declarar una variable como public static genera dificultades en el debugging por ser de scope global
    *y poder modificarse desde otras clases sin acceder a un metodo, por razones de utilidad a nuestro programa decidimos utilizarla
    */
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
    
        // Crear jugadores para la prueba
        Jugador jugador1 = new Jugador("Franco", "Fran", 21);
        Jugador jugador2 = new Jugador("Alejandra", "Ale", 23);
    
        // Crear una instancia de GranTateti con dos jugadores
        GranTateti juegoTateti = new GranTateti(jugador1, jugador2);
    
        // Iniciar el juego
        juegoTateti.getJuego().jugar();
    }

    //"Metodo de prueba" Me ayuda a pensar ;) ... Cuando pienso
    public void mostrarTablero(){
    ///Posibilidad de meter colores y mejorar la interfaz por consola
        System.out.println(/*Instancia de granTateti.Juego.tablero */);
    }

    public int[] pedirEntrada(){
        //Puede que tengamos que aplicar un while 
        int[] ret = new int[2];
        System.out.println("Ingrese su Jugada");
        String jugada = in.nextLine();
        if(jugada.length() == 1 && jugada.equals("M")){
            //jugada magica
        }
        if(jugada.length() == 2 && GranTateti.verificarJugada(jugada)){
            ret = GranTateti.posiciones(jugada);
        }else{
            System.out.println("La jugada no es valida ingrese otra");
        }
        return ret;
    }

    

}
/*
 * El jugador, luego de seleccionar en el menu que modo de juego quiere, se tiene que iniciar una instancia de Gran tateti dentro de interfaz
 * y mediante la misma se tiene que manejar el estado de juego, 
 * 
 * 
 * Juego 
 * 
 * 
 * 
*/

