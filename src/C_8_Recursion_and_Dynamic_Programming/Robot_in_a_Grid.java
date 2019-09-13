package C_8_Recursion_and_Dynamic_Programming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public class Robot_in_a_Grid {

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public static boolean randomBoolean(int percentTrue) {
        return randomIntInRange(1, 100) <= percentTrue;
    }

    static boolean[][] randomMatrix(int M, int N, int percentage){
        boolean[][] matrix = new boolean[M][N];
        for(int i =0;i<M;i++){
            for(int j=0;j<N;j++){
                matrix[i][j] = randomBoolean(90);
            }
        }
        return matrix;
    }

    public static void printMatrix(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    static ArrayList<Point> getPath(boolean maze[][]){
        if(maze==null|| maze.length == 0)
            return null;
        ArrayList<Point> path  = new ArrayList<>();
        HashMap<Point, Boolean> cache = new HashMap<>();
        if(getPath(maze,0,0,path,cache))
            return path;
        return null;
    }

    static boolean getPath(boolean maze[][],int row,int col,ArrayList<Point> path,HashMap<Point, Boolean> cache){
        if(col>maze.length-1||row>maze[0].length-1||!maze[row][col])
            return false;
        Point p = new Point(row,col);
        boolean isAtDest = row==maze.length-1&&maze[0].length-1==col?true:false;
        boolean success = false;
        if(cache.containsKey(p))
            return cache.get(p);

        if(isAtDest||getPath(maze,row,col+1,path,cache)||getPath(maze,row+1,col,path,cache)){
            path.add(p);
            success = true;
        }
        cache.put(p,success);
        return success;

    }
    public static void main(String[] args) {
        int size = 100;
        boolean maze[][] = randomMatrix(size,size,70);
        printMatrix(maze);
        ArrayList<Point> path = getPath(maze);

        if (path != null) {
            Collections.reverse(path);
            for(Point p: path){
                System.out.println(p.row+" "+p.col);
            }
        } else {
            System.out.println("No path found.");
        }
    }

}

class Point {
    public int row, col;

    public Point(int row, int col){
       this.row = row;
       this.col = col;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row &&
                col == point.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}
