package C_8_Recursion_and_Dynamic_Programming;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Coins {

    static int makeChange(int amount,Set<Integer> noOfCoins,int coins,HashMap<Integer,Integer> memory){
        if(memory.containsKey(amount))
            return memory.get(amount);
        if(amount == 0 && !noOfCoins.contains(coins)){
            noOfCoins.add(coins);
            return 1;
        }
        if(amount < 0)
            return 0;

        return (makeChange(amount-25,noOfCoins,coins+1,memory)+makeChange(amount-10,noOfCoins,coins+1,memory)+makeChange(amount-5,noOfCoins,coins+1,memory)+makeChange(amount-1,noOfCoins,coins+1,memory));
    }


    public static void main(String[] args) {
        int amount = 27;
        Set<Integer> noOfCoins = new HashSet<>();
        noOfCoins.add(0);
        HashMap<Integer,Integer> memory = new HashMap<>();
        int ways = makeChange(amount,noOfCoins,0,memory);
        System.out.println(ways);
    }
}
