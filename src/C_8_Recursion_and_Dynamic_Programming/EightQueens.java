package C_8_Recursion_and_Dynamic_Programming;

import java.util.ArrayList;

public class EightQueens {
    private static int GRID_SIZE = 8;

    public static boolean checkValid(Integer[] columns, int row1, int col1){
        for(int row2 = 0; row2 < row1; row2++){
            int column2 = columns[row2];
            /* check if (row2,col2) invalidates (row1,col1) */

            /* check if rows have a queen in the same column */
            if (column2 == col1){
                return false;
            }

            /* check diagonals */
            int colDistance = Math.abs(column2 - col1);
            int rowDistance = row1 - row2;
            if (rowDistance == colDistance){
                return false;
            }
        }
        return true;
    }

    static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results){
        if(row == GRID_SIZE){
            results.add(columns.clone());
        } else {
            for(int col = 0; col < GRID_SIZE; col++){
                if (checkValid(columns, row, col)) {
                    columns[row] = col; //place queen
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    static void printBoard(Integer[] columns){
        drawLine();
        for(int i = 0; i < GRID_SIZE; i++){
            System.out.print("|");
            for(int j = 0; j < GRID_SIZE; j++){
                if(columns[i] == j){
                    System.out.print("Q|");
                } else {
                    System.out.print(" |");
                }
            }
            System.out.print("\n");
            drawLine();
        }
        System.out.println("");
    }

    static void printBoard(ArrayList<Integer[]> boards){
        for(int i = 0; i < boards.size(); i++){
            Integer[] board = boards.get(i);
            printBoard(board);
        }
    }

    static void drawLine(){
        StringBuilder line = new StringBuilder();
        for(int i = 0; i < GRID_SIZE; i++){
           line.append('-');
        }
        System.out.println(line.toString());
    }

    static void clear(Integer[] column){
        for(int i = 0; i < GRID_SIZE; i++){
            column[i] = -1;
        }
    }
    public static void main(String[] args){
        ArrayList<Integer[]> results = new ArrayList<Integer[]>();
        Integer[] columns = new Integer[GRID_SIZE];
        clear(columns);
        placeQueens(0, columns, results);
        printBoard(results);
        System.out.println(results.size());
    }
}
