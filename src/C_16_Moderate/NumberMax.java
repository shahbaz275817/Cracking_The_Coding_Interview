package C_16_Moderate;

public class NumberMax {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        int diff = a - b;

        int k = 1 ^ ((diff >> 63) & 0x1);
        System.out.println(k*a + ((1 ^ k)*b));
    }
}