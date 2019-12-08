package C_16_Moderate;

public class Operations {

    static int divide(int a, int b){
        int quotient = 0;
        while(a >= b){
            quotient++;
            a -=b;
        }
        return quotient;
    }

    static int multiply(int a, int b){
        int totalSum = 0;
        for(int i=0;i<b;i++){
            totalSum += a;
        }
        return totalSum;
    }

    static int subtraction(int a, int b){
        int onescomp = b ^ (~0);
        return a + (onescomp + 1);
    }

    public static void main(String[] args) {
        int a = 10; int b =5;
        System.out.println(subtraction(a,b));
        System.out.println(multiply(a,b));
        System.out.println(divide(a,b));
    }
}
