package me.edur.gecko.tictactoe.engine;

public class Game {
    private int board[][];
    private int gameCode;
    private int winner = 0;

    public Game(int gameCode) {
        board = new int[3][3];
        this.gameCode = gameCode;
        clean();
    }

    public void clean() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    public void play(int i, int j, int valor) {
        board[i][j] = valor;
        winner = calcWinner();
        
    }

    public String show() {
        String string = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j == 2) {
                    string = string + board[i][j] + "\n";
                } else {
                    string = string + board[i][j];
                }
            }
        }
        return string;
    }

    public int calcWinner() {

        if ((board[0][0]==1 && board[0][1]==1 && board[0][2] ==1)  || (board[1][0] ==1 && board[1][1]==1 && board[1][2]==1 ) 
                || (board[2][0]==1 && board[2][1]==1 && board[2][2]==1 )) {
            return 1;
          

        } else if ((board[0][0]==1 && board[1][0]==1 && board[2][0]==1 )|| (board[0][1]==1 && board[1][1]==1 &&board[2][1]==1)
                || (board[0][2]==1 && board[1][2]==1 && board[2][2]==1)) {
            return 1;

        } else if ((board[0][0]==1 && board[1][1]==1 && board[2][2]==1) || (board[0][2]==1 && board[1][1]==1 && board[2][0]==1)) {
            return 1;
        } else if ((board[0][0]==2 && board[0][1] ==2 && board[0][2]==2) || (board[1][0]==2 && board[1][1]==2 && board[1][2]==2)
                || (board[2][0]==2 &&  board[2][1]==2 && board[2][2]==2)) {
            return 2;

        } else if ((board[0][0]==2 && board[1][0]==2 && board[2][0]==2 ) || (board[0][1]==2 && board[1][1]==2 && board[2][1]==2 )
                || (board[0][2]==2 && board[1][2]==2 && board[2][2]==2 )) {
            return 2;

        } else if ((board[0][0]==2 && board[1][1]==2 && board[2][2]==2) || (board[0][2]==2 && board[1][1]==2 && board[2][0]==2 )) {
            return 2;
        } else {
            return 0;
        }


    }

    public int getGameCode() {
        return gameCode;
    }

    public void setGameCode(int gameCode) {
        this.gameCode = gameCode;
    }
    
   
}
