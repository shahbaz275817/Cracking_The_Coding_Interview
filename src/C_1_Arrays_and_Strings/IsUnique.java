package C_1_Arrays_and_Strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Shahbaz on 21-Sep-18.
 */
public class IsUnique {
    /**
     * Created by Shahbaz on 10-Aug-18.
     */
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            char string[] = s.toCharArray();
            Arrays.sort(string);
            for(int i =0 ; i < string.length-1; i++){
                if(string[i] == string[i+1]){
                    System.out.println("not unique");
                    System.exit(0);
                }
            }
            System.out.println("Unique");
        }
}
