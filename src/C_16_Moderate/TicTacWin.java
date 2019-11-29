package C_16_Moderate;

import java.time.Period;
import java.util.Hashtable;
import java.util.Scanner;

public class TicTacWin {
    enum Piece { Empty, Red, Blue};

    public static void main(String[] args) {
        Piece[][] board =  {
                {Piece.Empty, Piece.Empty, Piece.Empty},
                {Piece.Empty, Piece.Empty, Piece.Empty},
                {Piece.Blue, Piece.Blue, Piece.Blue}};

        int boardValue = convertBoardToInt(board);
        Hashtable<Integer,Piece> winnerHashTable = getWinnerHashTable();
        Piece winner = winnerHashTable.get(boardValue);
        System.out.println(winner.name());
    }

    static int convertBoardToInt(Piece[][] board){
        int sum = 0;

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                sum += board[i][j].ordinal();
            }
        }
        return sum;
    }

    static Hashtable<Integer,Piece> table = new Hashtable<Integer,Piece>();

    static Hashtable<Integer,Piece> getWinnerHashTable(){
        int sum = 0;
        return table;
    }

    static void createTable(){
        //
    }
}
