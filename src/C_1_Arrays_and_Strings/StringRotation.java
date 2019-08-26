package C_1_Arrays_and_Strings;
import java.util.*;
/**
 * Created by Shahbaz on 06-Oct-18.
 */
public class StringRotation {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s1= sc.nextLine();
        String s2= sc.nextLine();
        if(isSubString(s1,s2))
            System.out.println("True");
        else
            System.out.println("False");
    }
    static boolean isSubString(String s1, String s2){
        if(s1.length()!=s2.length())
            return false;
        for(int i=0;i<s1.length();i++){
            s1=s1.substring(1)+s1.substring(0,1);
            if(s1.compareTo(s2)==0)
                return true;
        }

        return false;
    }
}
