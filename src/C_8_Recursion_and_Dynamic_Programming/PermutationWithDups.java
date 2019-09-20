package C_8_Recursion_and_Dynamic_Programming;

import java.lang.reflect.Array;
import java.util.ArrayList;

import java.util.ArrayList;
import java.util.HashMap;

public class PermutationWithDups {

    static ArrayList<String> getPerms(String s){
        ArrayList<String> permutations = new ArrayList<>();
        HashMap<Character,Integer> map = buildFreqTable(s);
        printPerms(map, "", s.length(), permutations);
        return permutations;
    }

    static  void printPerms(HashMap<Character,Integer> map, String prefix, int remaining,ArrayList<String> result){
        if (remaining == 0) {
            result.add(prefix);
            return;
        }
        for(Character c: map.keySet()){
            int count = map.get(c);
            if(count > 0){
                map.put(c,map.get(c)-1);
                printPerms(map,prefix+c,remaining-1,result);
                map.put(c,count);
            }

        }
    }

    static HashMap<Character,Integer> buildFreqTable(String s){
        if( s == null){
            return new HashMap<Character, Integer>();
        }
        HashMap<Character,Integer> freqTable = new HashMap<>();
        for(char a: s.toCharArray()){
            if(freqTable.containsKey(a))
                freqTable.put(a,(freqTable.get(a)+1));
            else
                freqTable.put(a,1);
        }
        return freqTable;
    }

    public static void main(String[] args) {
        String s = "aaagfgjhfhfaaaa";
        ArrayList<String> permutations = getPerms(s);
        System.out.println(permutations.size());
        System.out.println(permutations.toString());
    }
}
