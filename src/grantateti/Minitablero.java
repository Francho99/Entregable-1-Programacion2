package grantateti;


public class Minitablero {
    private boolean terminado = false;
    private char ganador;
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
    
    public void terminado(){
        boolean hayGanador = false;
        //filas
        for (int i = 0; i < 3; i++) {
            if (this.tablero[i][0] != ' ' && this.tablero[i][0] == (this.tablero[i][1]) &&  this.tablero[i][0] == (this.tablero[i][2])) {
                hayGanador = true;
                this.setGanador(tablero[i][0]);
            }
        }
        //columnas
        for (int i = 0; i < 3; i++) {
            if (this.tablero[0][i] != ' ' && this.tablero[0][i] == (this.tablero[1][i]) && this.tablero[0][i] == (this.tablero[2][i])) {
                hayGanador = true;
                this.setGanador(tablero[0][i]);
            }
        }
        //diagonal principal
        if (this.tablero[0][0] != ' ' && this.tablero[0][0] == (this.tablero[1][1]) && this.tablero[0][0] == (this.tablero[2][2])) {
            hayGanador = true;
            this.setGanador(tablero[0][0]);
        }
        //la otra diagonal
        if (this.tablero[0][2] != ' ' && this.tablero[0][2] == (this.tablero[1][1]) && this.tablero[0][2] == (this.tablero[2][0])) {
            hayGanador = true;
            this.setGanador(tablero[0][2]);
        }
        if(hayGanador){this.setTerminado(true);}
    }
    
    
    
    //Getters y Setters
    public boolean isTerminado() {
        return terminado;
    }

    public char getGanador() {
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
    
    public void setGanador(char ganador) {
        this.ganador = ganador;
    }
    
        
       @Override
    public String toString(){
        StringBuilder tableroString = new StringBuilder();
        String verde = "\u001B[32m";
        String reset = "\u001B[0m";
        for (int fil = 0; fil < 3; fil++) {
                for (int col = 0; col < 3; col++) {
                    tableroString.append(this.tablero[fil][col]);
                   if(col<2){
                        tableroString.append("|");
                    }
                
                }
                tableroString.append("\n");
            
        tableroString.append("-+-+-\n");
        }
       
    return tableroString.toString();
    }
    

}
