package grantateti;

public class Tablero {
    private Minitablero[][] tablero = new Minitablero[3][3];
    private boolean terminado = false;
    private Jugador ganador;
    
    public Tablero() {
        this.terminado = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.tablero[i][j] = new Minitablero();
            }
        }
    }

    public Minitablero[][] getTablero() {
        return tablero;
    }

    public void setTablero(Minitablero[][] tablero) {
        this.tablero = tablero;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }
    
    @Override
    public String toString(){
        StringBuilder tableroString = new StringBuilder();
        
        for (int fil = 0; fil < 3; fil++) {
                for (int col = 0; col < 3; col++) {
                    tableroString.append(this.tablero[fil][col].toString()).append("\n");
                }
                tableroString.append("\n");
        
            }

        return tableroString.toString();
    }
    
}
