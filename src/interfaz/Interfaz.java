package interfaz;

import grantateti.*;


public class Interfaz {
    public static void main(String[] args) {
//        Menu menu = new Menu(); // nuevo objeto de la clase menu
//        menu.mostrarMenu(); //llama al metodo de mostrr el menu
    Jugador j1 = new Jugador("Franco", "fran", 234);
    Jugador j2 = new Jugador("Franco", "fran2", 234);
    Juego nuevo = new Juego(j1, j2);
    nuevo.jugar();


        
    }

    //"Metodo de prueba" Me ayuda a pensar ;) ... Cuando pienso
   /*public void mostrarTablero(){
        System.out.println(nuevoJuego.getTablero());
        
    }*/

}
