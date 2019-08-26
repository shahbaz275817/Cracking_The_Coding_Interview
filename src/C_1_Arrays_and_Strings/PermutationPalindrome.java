package C_1_Arrays_and_Strings;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Shahbaz on 21-Sep-18.
 */
public class PermutationPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase();
        char[] ch = str.toCharArray();
        Hashtable<Character,Integer> ht = new Hashtable<>();
        for(char c: ch){
            if(!ht.containsKey(c))
                ht.put(c,1);
            else{
                ht.replace(c,ht.get(c)+1);
            }
        }
        ht.remove(' ');
        int noOfOdd=0;
        Set<Character> keys = ht.keySet();
        for(char c : keys){
            if(ht.get(c)%2!=0)  noOfOdd++;
            if(noOfOdd>1) {
                System.out.println("False");
                System.exit(0);
            }
        }
        System.out.println("true");
    }
}
