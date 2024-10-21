package grantateti;

public class Tablero {
    private Minitablero[][] tablero;
    private boolean terminado = false;
    private char ganador;
    private int[] posicionAnterior;
    
    public Tablero() {
        this.terminado = false;
        tablero = new Minitablero[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = new Minitablero();
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

    public void setPosicionAnterior(int[] posicionAnterior) {
        this.posicionAnterior = posicionAnterior;
    }

  
    public Minitablero obtenerMinitablero(int f, int c) {
        if (f >= 0 && f < 3 && c >= 0 && c < 3) {
            return tablero[f][c];
        } else {
            System.out.println("Coordenadas fuera de los límites.");
            return null;  
        }
    }

    public void destacarBordeAmarillo() {
        String fondoAmarillo = "\u001B[43m"; 
        String reset = "\u001B[0m"; 
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
    public String toString() {
        String fondoVerde = "\u001B[42m";  
        String fondoAmarillo = "\u001B[43m";  
        String reset = "\u001B[0m"; 
        StringBuilder tableroString = new StringBuilder();
    
 
        for (int fil = 0; fil < 3; fil++) {

            for (int minicol = 0; minicol < 3; minicol++) {
                if (fil == posicionAnterior[0] && minicol == posicionAnterior[1]) {
                    tableroString.append(fondoAmarillo).append("*******").append(reset);
                    tableroString.append(fondoVerde).append("*******").append(reset);
                }
                if (minicol < 2) {
                    tableroString.append(" ");
                }
            }
            tableroString.append("\n");
    
            String[] filasTablero = new String[3];
            for (int fila = 0; fila < 3; fila++) {
                StringBuilder filaTablero = new StringBuilder();
                for (int minicol = 0; minicol < 3; minicol++) {
    
                    if (fil == posicionAnterior[0] && minicol == posicionAnterior[1]) {
                        filaTablero.append(fondoAmarillo).append("*").append(reset); 
                    } else {
                        filaTablero.append(fondoVerde).append("*").append(reset); 
                    }
    
                    filaTablero.append(tablero[fil][minicol].getTablero()[fila][0]).append("|")
                               .append(tablero[fil][minicol].getTablero()[fila][1]).append("|")
                               .append(tablero[fil][minicol].getTablero()[fila][2]);
    
  
                    if (fil == posicionAnterior[0] && minicol == posicionAnterior[1]) {
                        filaTablero.append(fondoAmarillo).append("*").append(reset); 
                    } else {
                        filaTablero.append(fondoVerde).append("*").append(reset);
                    }
                    if (minicol < 2) {
                        filaTablero.append(" "); 
                    }
                }
                filasTablero[fila] = filaTablero.toString();
            }
    

            for (int i = 0; i < 3; i++) {
                tableroString.append(filasTablero[i]).append("\n");
            }

            for (int minicol = 0; minicol < 3; minicol++) {
                if (fil == posicionAnterior[0] && minicol == posicionAnterior[1]) {
                    tableroString.append(fondoAmarillo).append("*******").append(reset); 
                } else {
                    tableroString.append(fondoVerde).append("*******").append(reset);  
                }
                if (minicol < 2) {
                    tableroString.append(" ");
                }  
            }
            tableroString.append("\n");
    
          
            if (fil < 2) {
                for (int minicol = 0; minicol < 3; minicol++) {
                    tableroString.append("       ");  
                    if (minicol < 2) {
                        tableroString.append(" ");  
                    }
                }
                tableroString.append("\n");
            }
        }
    
        return tableroString.toString();
    }
}    
  