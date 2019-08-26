package C_1_Arrays_and_Strings;

import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by Shahbaz on 21-Sep-18.
 */
public class CheckPermuatation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1= sc.nextLine().trim().toLowerCase();
        String s2= sc.nextLine().trim().toLowerCase();

        if(s1.length()!=s2.length()) {
            System.out.println("Not permutation");
            System.exit(0);
        }
        Hashtable<Character,Integer> ht = new Hashtable<>();
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        for(int i = 0 ;i< c1.length;i++){
            if(!ht.containsKey(c1[i]))
                ht.put(c1[i],1);
            else
                ht.replace(c1[i],ht.get(c1[i])+1);

        }
        for(int i = 0 ;i< c1.length;i++){
            if(!ht.containsKey(c2[i])) {
                System.out.println("1Not permutation");
                System.exit(0);
            }
            ht.replace(c2[i],ht.get(c2[i])-1);
            if(ht.get(c2[i])<0){
                System.out.println("Not permutation");
                System.exit(0);
            }
        }
        System.out.println("Permutation");
    }


}
