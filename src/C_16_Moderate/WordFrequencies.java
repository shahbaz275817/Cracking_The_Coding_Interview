package C_16_Moderate;

import java.util.Hashtable;

public class WordFrequencies {

    static int countWord(String[] book, String word){
        Hashtable<String,Integer> table = new Hashtable<>();
        for(String s :  book){
            if(!table.contains(s))
                table.put(s,0);
            table.put(s,table.get(s)+1);

        }
        if(table.containsKey(word))
            return table.get(word);
        else
            return 0;
    }

    public static void main(String[] args) {
        String[] wordlist = {"This", "is", "ctci", "book"};
        int freq = countWord(wordlist,"book");
        System.out.println(freq);
    }
}
