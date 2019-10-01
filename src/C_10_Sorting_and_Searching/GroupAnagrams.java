package C_10_Sorting_and_Searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {

    static void sort(String[] array){
        HashMap<String, ArrayList<String>> list = new HashMap<>();

        for(String s : array){
            String temp = sortChars(s);
            if( list.containsKey(temp)){
                list.get(temp).add(s);
                /*ArrayList<String> l = list.get(temp);
                l.add(s);
                list.replace(temp,l);*/
            }
            else{
                ArrayList<String> l = new ArrayList<String>();
                l.add(s);
                list.put(temp,l);
            }
        }

        int index = 0;
        for(String key : list.keySet()){
            var l = list.get(key);
            for(String s : l){
                array[index++] = s;
            }
        }

    }

    static String sortChars(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
        sort(array);
        for(var s : array){
            System.out.print(s + " ");
        }
    }
}
