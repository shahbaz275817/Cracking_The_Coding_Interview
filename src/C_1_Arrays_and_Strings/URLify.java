package C_1_Arrays_and_Strings;

import java.util.Scanner;

/**
 * Created by Shahbaz on 21-Sep-18.
 */
public class URLify {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        if(s.length()>128)
            return;
        //input format: Mr John Smith , 13

        //LOL
        /*s = s.replaceAll(" ", "%20");
        System.out.println(s);*/
        String[] str = s.split(",");

        char c[]= str[0].trim().toCharArray();
        int noOfCharacters = Integer.parseInt(str[1].trim());
        int noOfSpaces = 0;
        for(char ch : c ){
            if(ch == ' ')
                noOfSpaces++;
        }

        int totalChars = noOfCharacters + (noOfSpaces*2);
        char[] a = new char[totalChars];
        for(int i = 0,j=0; i<c.length; i++){
            if(c[i] != ' '){
                a[j++] = c[i];
            }
            else{
                a[j++]='%';
                a[j++]='2';
                a[j++]='0';
            }
        }
        String url = String.valueOf(a);
        System.out.println(url);

    }
}
