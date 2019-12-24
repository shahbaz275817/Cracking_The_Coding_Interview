package C_16_Moderate;

import java.util.HashSet;

public class SumSwap {

    static int sum(int[] a){
        int s = 0;
        for(int i : a){
            s += i;
        }
        return s;
    }
    static Integer findTarget(int[] a, int[] b){
        int sum1 = sum(a);
        int sum2 = sum(b);
        System.out.println(sum1);
        System.out.println(sum2);
        if ((sum1 - sum2) % 2 != 0)
            return null;
        return  (sum1 - sum2) / 2;
    }

    static int[] findPair(int[] a, int[] b){
        var contents  = getCleanArray(a);
        int target = findTarget(a, b);
        for(int one : a){
            int two = target - one;
            if(contents.contains(two)){
                int[] sol = {one, two};
                return sol;
            }
        }
        return null;
    }

    static HashSet<Integer> getCleanArray(int[] a){
        HashSet<Integer> set = new HashSet<>();
        for(int i : a){
            set.add(i);
        }
        return set;
    }

    public static void main(String[] args) {
        int[] array1 = {-9, -1, -4, 8, 9, 6, -5, -7, 3, 9};
        int[] array2 = {6, 6, 4, -1, 7, -6, -9, 4, -8, 8};
        int[] pairs = findPair(array1, array2);
        System.out.println("("+pairs[0]+", "+pairs[1]+")");
    }
}
