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

    public void minitablero(int[] posicionAnt, int[] posicionAct, char ficha){
        Minitablero[][] tablero = this.tablero;
        Minitablero minitablero = tablero[posicionAnt[0]][posicionAnt[1]];
        char[][] minitab = minitablero.getTablero();
        minitab[posicionAct[0]][posicionAct[1]] = ficha;
        minitablero.setTablero(minitab);
        tablero[posicionAnt[0]][posicionAnt[1]] = minitablero;
        this.setTablero(tablero);
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
    String fondoVerde = "\u001B[42m";
    String reset = "\u001B[0m"; // Restablecer color predeterminado

        StringBuilder tableroString = new StringBuilder();
            tableroString.append(fondoVerde).append("*******************").append(reset).append("\n");
            for(int fil=0; fil < 3; fil++){
                String[] filasTablero = new String[3];
                

                for(int fila = 0; fila < 3; fila++){
                    StringBuilder filaTablero = new StringBuilder();

                    for(int minicol = 0; minicol < 3; minicol++){
                        String[] filminitablero = tablero[fil][minicol].toString().split("\n");
                        filaTablero.append(filminitablero[fila]);
                        if(minicol < 2){
                            filaTablero.append(fondoVerde).append("*").append(reset);
                        }
                    }
                    filasTablero[fila] = filaTablero.toString();
                    
                }
                for(int i=0;i<3; i++){
                    tableroString.append(fondoVerde).append("*").append(reset).append(filasTablero[i]).append(fondoVerde).append("*").append(reset).append("\n");
                }
                
                tableroString.append(fondoVerde).append("*").append(reset).append("-+-+-").append(fondoVerde).append("*").append(reset).append("-+-+-").append(fondoVerde).append("*").append(reset).append("-+-+-").append(fondoVerde).append("*").append(reset).append("\n");

                tableroString.append(fondoVerde).append("*").append(reset).append(" | | ").append(fondoVerde).append("*").append(reset).append(" | | ").append(fondoVerde).append("*").append(reset).append(" | | ").append(fondoVerde).append("*").append(reset).append("\n");
            
        
                if (fil < 2) {  // Solo añadir el separador entre los tres minitableros completos
                    tableroString.append(fondoVerde).append("*").append("******************").append(reset).append("\n");
                }

            }
            tableroString.append(fondoVerde).append("*******************").append(reset).append("\n");
        return tableroString.toString();
    }
    
}



    
