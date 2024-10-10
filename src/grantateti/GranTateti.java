package grantateti;

import java.util.*;

public class GranTateti {

   
    public static void main(String[] args) {
        String nombre; int edad; String alias; String alias2;
        Scanner in = new Scanner(System.in);
        System.out.println("Registre un nuevo jugador");
        nombre = in.nextLine();
        alias = in.nextLine();
        edad = in.nextInt();
        Jugador jugador1 = new Jugador(nombre, alias, edad);
        System.out.println("Registre un nuevo jugador");
        nombre = in.nextLine();
        System.out.println("Alias");
        alias2 = in.nextLine();
        System.out.println("Edad");
        edad = in.nextInt();
        Jugador jugador2 = new Jugador(nombre, alias, edad);
        Juego juegoNuevo = new Juego(jugador1, jugador2);
    }
        
}
