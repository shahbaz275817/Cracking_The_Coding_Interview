package C_5_Bit_Manipulation;

/**
 * Created by Shahbaz on 27-Aug-19.
 */
import java.util.*;
public class Insertion {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int a = ~23423;
        System.out.println(convertToBinaryString(a));
        int b = 5;
        System.out.println(convertToBinaryString(b));
        int newVal = insert(a,b,2,4);
        System.out.println(convertToBinaryString(newVal));
    }
    static int insert(int M,int N, int i,int j){
        int allOnes = ~0;
        int mask = ~(allOnes<<j+1);
        int mask2 = ~(allOnes<<i);
        mask = mask|mask2;
        M = M&mask;
        N = N << i;
        return M|N;
    }

    static String convertToBinaryString(int a){
        String s = "";
        for(int i=0;i<32;i++){
            Integer lsb = new Integer(a&1);
            s = lsb.toString()+s;
            a >>= 1;
        }
        return s;
    }
}
