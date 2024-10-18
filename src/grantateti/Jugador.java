package grantateti;

public class Jugador {
    private static int cantAliases = 0;
    private static String[] Aliases = new String[100];
    private String nombre;
    private String alias;
    private int edad;
    private boolean jugadaMagica;

    public Jugador(String nombre, String alias, int edad) {
        //Esto se puede resolver con un Set<>
            this.nombre = nombre;
            this.alias = alias;
            this.edad = edad;
            Aliases[cantAliases] = alias;
            cantAliases+=1;
    }
        public static boolean verificarDuplicado(String aliasdup){
          for (String a:Aliases){
            if(a!= null && a.equals(aliasdup)){
                return true;
            }
        }
        return false;
}
      

    public static int getCantAliases() {
        return cantAliases;
    }

    public static void setCantAliases(int cantAliases) {
        Jugador.cantAliases = cantAliases;
    }

    public static String[] getAliases() {
        return Aliases;
    }

    public static void setAliases(String[] Aliases) {
        Jugador.Aliases = Aliases;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isJugadaMagica() {
        return jugadaMagica;
    }

    public void setJugadaMagica(boolean jugadaMagica) {
        this.jugadaMagica = jugadaMagica;
    }
    
    
    
}

