package C_16_Moderate;

import java.util.Hashtable;

public class MasterMind {
    public static void main(String[] args) {
        String input1 = "RGBY";
        String input2 = "GGRR";
        int hit = 0;
        int pseudoHit = 0;
        char[] s1 = input1.toCharArray();
        char[] s2 = input2.toCharArray();

        int[] pseudoHitColorArray = new int[4];
        for(int i = 0 ;i < s1.length; i++){
            if(s1[i] == s2[i])
                hit++;
            else{
                pseudoHitColorArray[getColorIndex(s1[i])]++;
            }
        }
        for(int i = 0; i < s2.length; i++){
            if(pseudoHitColorArray[getColorIndex(s2[i])] > 0){
                pseudoHitColorArray[getColorIndex(s2[i])]--;
                pseudoHit++;
            }
        }
        System.out.println("Hits: "+ hit +" Pseudo-hit: "+pseudoHit);
    }
    static int getColorIndex(char c){
        switch (c){
            case 'R':
                return 0;
            case 'Y':
                return 1;
            case 'G':
                return 2;
            case 'B':
                return 3;
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
    }
}
