package C_16_Moderate;

public class NumberSwapper {
    public static void main(String[] args) {
        int a = 5; int b = 10;
        a = a - b;
        b = a + b;
        a = b - a;
        System.out.println("a = "+ a + " b = " + b);
    }
}
