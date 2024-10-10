package grantateti;

import java.util.*;

public class Jugador {
    private String nombre;
    private String alias;
    private int edad;
    private boolean jugadaMagica;
    
    Scanner in = new Scanner(System.in);

    public Jugador(String nombre, String alias, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.jugadaMagica = true;
        
        boolean esta = false;
        for (String string:Juego.getAliases()) {
            if(alias == string){esta = true;}
        }
        if(!esta){
        Juego.setAliases(alias);
        this.alias = alias;}
        else{
            System.out.println("El alias ya esta registrado prueba otra vez");
            this.alias = in.nextLine();
        }
    }
    
    
}
