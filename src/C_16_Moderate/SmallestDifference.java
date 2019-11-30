package C_16_Moderate;

import java.util.Arrays;

public class SmallestDifference {
    public static void main(String[] args) {
        int[] a = {1,3,5,11,2};
        int[] b = {23,127,235,19,8};

        Arrays.sort(a);
        Arrays.sort(b);
        int min = Integer.MAX_VALUE;
        int i = 0; int j = 0;
        while(i != a.length && j != b.length){
            if( (Math.abs(a[i] - b[j])) < min)
                min = Math.abs(a[i] - b[j]);
            if(a[i] > b[i])
                j++;
            else
                i++;
        }
        System.out.println(min);
    }
}
