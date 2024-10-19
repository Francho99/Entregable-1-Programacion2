package grantateti;

public class Tablero {
    private Minitablero[][] tablero = new Minitablero[3][3];
    private boolean terminado = false;
    private char ganador;
    
    public Tablero() {
        this.terminado = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.tablero[i][j] = new Minitablero();
            }
        }
    }
    
    public void terminado(){
        boolean hayGanador = false;
        //filas
        for (int i = 0; i < 3; i++) {
            if (this.tablero[i][0].isTerminado() && this.tablero[i][0].getGanador() == this.tablero[i][1].getGanador() &&  this.tablero[i][0].getGanador() == this.tablero[i][2].getGanador()) {
                hayGanador = true;
                this.setGanador(tablero[i][0].getGanador());
            }
        }
        //columnas
        for (int i = 0; i < 3; i++) {
            if (this.tablero[0][i].isTerminado() && this.tablero[0][i].getGanador() == this.tablero[1][i].getGanador() && this.tablero[0][i].getGanador() == this.tablero[2][i].getGanador()) {
                hayGanador = true;
                this.setGanador(tablero[0][i].getGanador());
            }
        }
        //diagonal principal
        if (this.tablero[0][0].isTerminado() && this.tablero[0][0].getGanador() == this.tablero[1][1].getGanador() && this.tablero[0][0].getGanador() == this.tablero[2][2].getGanador()) {
            hayGanador = true;
            this.setGanador(tablero[0][0].getGanador());
        }
        //la otra diagonal
        if (this.tablero[0][2].isTerminado() && this.tablero[0][2].getGanador() == this.tablero[1][1].getGanador() && this.tablero[0][2].getGanador() == this.tablero[2][0].getGanador()) {
            hayGanador = true;
            this.setGanador(tablero[0][2].getGanador());
        }
        if(hayGanador){this.setTerminado(true);}    
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

    public char getGanador() {
        return ganador;
    }

    public void setGanador(char ganador) {
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
