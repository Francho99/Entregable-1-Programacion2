
package interfaz;
import grantateti.*;  // Importar la clase Jugador desde el package grantateti
import java.util.Scanner;

/**
Registrar un jugador.
Jugar al Gran Tateti entre dos personas.
Jugar contra la computadora.
Ver el ranking de jugadores.
Terminar el programa.

 */
public class Menu {
    //private ArrayList<Jugador> jugadores = new ArrayList<>();
    //Este ArrayList funciona mejor en Interfaz porque es inmutable 
      
    public Menu() {
    }



    public void mostrarMenu() {
    
        boolean continuar = true;
        Scanner scanner = new Scanner(System.in);
 
            while (continuar) {
                System.out.println("\n--- Menú Principal ---");
                System.out.println("1 - Registrar un jugador");
                System.out.println("2 - Jugar al Gran Tateti entre dos personas");
                System.out.println("3 - Jugar al Gran Tateti contra la computadora");
                System.out.println("4 - Ver el ranking de jugadores");
                System.out.println("5 - Salir");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                        if(opcion == 5){
                            continuar = false;
                            }else if(opcion == 4){
                               // mostrarRanking();        
                            }else if(opcion == 3){
                                //Computadora computadora = new Computadora();
                                
                            }else if(opcion == 2){
                        //Jugar al Gran Tateti entre dos personas
                                
                            
                            } else if(opcion == 1){
                                System.out.println("Registrar nuevo jugador");
                                
                                System.out.print("Ingresa el nombre del jugador: ");
                                String nombre = scanner.nextLine();
         
                                System.out.print("Ingresa el alias del jugador: ");
                                String alias = scanner.nextLine();
                                 
                                if(!Jugador.verificarDuplicado(alias)){
                                    System.out.print("Ingresa la edad del jugador: ");
                                    int edad = scanner.nextInt();
                                    scanner.nextLine();
                                    Jugador nuevoJugador = new Jugador(nombre, alias, edad);
                                    Jugador.setCantAliases(Jugador.getCantAliases()+1);
                                    Jugador.nuevoAlias(alias);
                                    Interfaz.jugadores.add(nuevoJugador);
                                    System.out.println("Jugador registrado exitosamente.");
                                } else {
                                     System.out.println("No se pudo registrar el jugador. El alias ya está en uso.");
                                }     
                            }
                        else if (opcion>5|| opcion<1){
                        System.out.println("Opción inválida. Inténtalo de nuevo.");
                        }
}
/*public void mostrarRanking() {
    if (Interfaz.jugadores.isEmpty()){
        System.out.println("No hay jugadores registrados");
        return;
    }
    Interfaz.jugadores.sort(jugadores, Comparator.comparingInt(jugador::getPuntaje).reversed());

    System.out.println("\n--- Ranking de Jugadores ---");
    for(Jugador jugador : jugadores){
        
        System.out.println(jugador.getAlias() + "-" + jugador.getPuntaje());
    }


}*/

}
}


        
  
        
    
