package C_16_Moderate;

import java.util.HashSet;

public class DividingBoard {
    public static void main(String[] args) {
        int k = 10;
        int longer = 5; int shorter = 3;
        HashSet<Integer> allLengths = allLengths(k, longer, shorter);
        for(Integer l : allLengths)
            System.out.println(l);

    }

    static HashSet<Integer> allLengths(int k, int longer, int shorter){
        HashSet<Integer> set = new HashSet<>();
        int total = 0;
        allLengths(set, total, k,longer, shorter);
        return set;
    }

    static void allLengths(HashSet<Integer> lengths,int total, int k, int longer, int shorter){
        if(k == 0){
            lengths.add(total);
            return;
        }
        allLengths(lengths, total + shorter, k - 1, longer, shorter);
        allLengths(lengths, total + longer, k - 1, longer, shorter);
    }
}
