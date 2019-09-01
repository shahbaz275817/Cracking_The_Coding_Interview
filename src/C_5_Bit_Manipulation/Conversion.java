package C_5_Bit_Manipulation;

public class Conversion {
    public static void main(String[] args) {
        int a = 3242;
        int b = 4321;
        System.out.println(countBits(a,b));
    }

    static int countBits(int a, int b){
        int count = 0;
        while(a!=0&&b!=0){
            if((a&1)!=(b&1))
                count++;
            a >>= 1; b >>= 1;
        }
        return count;
    }
}
