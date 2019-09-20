package C_8_Recursion_and_Dynamic_Programming;

import java.util.ArrayList;

public class PermutationWithoutDups {
    public static void main(String[] args) {
        String s = "barc";
        ArrayList<String> permutations = getPerms(s);
        System.out.println(permutations.size());
        System.out.println(permutations.toString());
    }

    static ArrayList<String> getPerms(String str){
        if (str == null) {
            return null;
        }
        ArrayList<String> permutations = new ArrayList<String>();
        if (str.length() == 0) { // base case
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remaining = str.substring(1);
        ArrayList<String> words  = getPerms(remaining);

        for(String word: words){
            for(int j=0;j<= word.length();j++){
                String s = insertCharAt(word,first,j);
                permutations.add(s);
            }
        }
        return permutations;
    }

    static String insertCharAt(String word,char c,int i){
        String first  = word.substring(0,i);
        String last = word.substring(i);
        return first+c+last;
    }


}
