package C_16_Moderate;

import java.util.ArrayList;

public class PondSizes {

    static ArrayList<Integer> computePondSizes(int[][] land){
        boolean[][] visited = new boolean[land.length][land[0].length];
        ArrayList<Integer> pondSizes = new ArrayList<>();
        for(int r = 0; r < land.length; r++){
            for(int c = 0; c< land[0].length; c++){
                int size = computeSizes(land,visited,r,c);
                if(size > 0){
                    pondSizes.add(size);
                }
            }
        }
        return pondSizes;
    }

    static int computeSizes(int[][] land, boolean[][] visited, int r, int c){
        if(r < 0 || c < 0 || r >= land.length || c >= land[0].length || visited[r][c] || land[r][c] !=0)
            return 0;

        int size = 1;
        visited[r][c] = true;
        for(int dr = -1; dr <= 1; dr++){
            for(int dc = -1; dc <= 1; dc++){
                size += computeSizes(land,visited,r + dr, c + dc);
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1}};
        ArrayList<Integer> pondSizes = computePondSizes(land);
        for(int sz: pondSizes){
            System.out.println(sz);
        }
    }
}
