package C_1_Arrays_and_Strings;

import java.util.*;

/**
 * Created by Shahbaz on 21-Sep-18.
 */
        //wrong logic //refer to crackingthecodinginterview.com solutions
public class OneAway {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        char[] c1 = str[0].toCharArray();
        char[] c2 = str[1].toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        if (c1.length - c2.length >= 2) {
            System.out.println("False");
            System.exit(0);
        }

        Hashtable<Character, Integer> ht1 = new Hashtable<>();
        Hashtable<Character, Integer> ht2 = new Hashtable<>();
        for (int i = 0; i < c1.length; i++) {
            if (!ht1.containsKey(c1[i]))
                ht1.put(c1[i], 1);
            else
                ht1.replace(c1[i], ht1.get(c1[i]) + 1);

        }
        for (int i = 0; i < c2.length; i++) {
            if (!ht2.containsKey(c2[i]))
                ht2.put(c2[i], 1);
            else
                ht2.replace(c2[i], ht2.get(c2[i]) + 1);

        }
        int awayCount = 0;
        Iterator<Character> itr1 = ht1.keySet().iterator();
        while(itr1.hasNext()){
            Character key = itr1.next();
            if(awayCount>1){
                System.out.println("False");
                System.exit(0);
            }
            if(!ht2.containsKey(key))
                awayCount++;
            else {
                ht1.replace(key, ht1.get(key) - 1);
                ht2.replace(key, ht2.get(key) - 1);
                if(ht1.get(key)<1)
                    itr1.remove();
                if(ht2.get(key)<1)
                    ht2.remove(key);
            }
        }

        if (ht1.size() > 1 || ht2.size() > 1)
            System.out.println("False");
        else
            System.out.println("True");
    }
}
