package C_8_Recursion_and_Dynamic_Programming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TripleStep {
    public static void main(String[] args) {
        int N = 30;
        int memo[] = new int[N+1];
        Arrays.fill(memo,-1);
        int ways = countSteps(N,memo);
        System.out.println(ways);
    }

    static int countSteps(int n,int memo[]){
        if(n<0)
            return 0;
        if(n==0)
            return 1;
        if(memo[n]==-1) {
            int oneStep = countSteps(n - 1, memo);
            int twoStep = countSteps(n - 2, memo);
            int threeStep = countSteps(n - 3, memo);
            memo[n] = oneStep + twoStep + threeStep;
        }
        return memo[n];
    }
}



