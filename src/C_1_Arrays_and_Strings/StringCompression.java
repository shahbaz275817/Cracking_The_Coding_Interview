package C_1_Arrays_and_Strings;

import java.util.*;
/**
 * Created by Shahbaz on 28-Sep-18.
 */
public class StringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] str = s.toCharArray();
        char[] newstr=new char[str.length];
        int count=1;
        for(int i=0,j=0;i<str.length-1;i++){
            if(str[i]==str[i+1])
                count++;
            else{
                newstr[j++]=str[i];
                newstr[j++]=Character.forDigit(count,10);
                count=1;
            }
            if(i==str.length-2){
                newstr[j++]=str[i];
                newstr[j++]=Character.forDigit(count,10);
            }
        }
        if(str.length==newstr.length)
            System.out.println(String.valueOf(str));
        else
            System.out.println(String.valueOf(newstr));

    }
}
