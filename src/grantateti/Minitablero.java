package grantateti;


public class Minitablero {
    private boolean terminado = false;
    private Jugador ganador;
    private char[][] tablero = new char[3][3];

    //Constructor
    public Minitablero() {
        this.terminado = false;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++){
                this.tablero[i][j] = ' ';
            }
        }
    }
    //Getters y Setters
    public boolean isTerminado() {
        return terminado;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public char[][] getTablero() {
        return tablero;
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }
    
    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }
    
    
    @Override
    public String toString(){
        StringBuilder tableroString = new StringBuilder();
        
        for (int fil = 0; fil < 3; fil++) {
                for (int col = 0; col < 3; col++) {
                    tableroString.append(this.tablero[fil][col]);
                    if(col<2){tableroString.append("|");}
                }
            }
        return tableroString.toString();
    }
}
