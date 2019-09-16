package C_8_Recursion_and_Dynamic_Programming;

public class RecursiveMultiply {
    public static void main(String[] args) {
        int a =0, b=7;
        System.out.println(multiply(a,b));

    }

    static int multiply(int a,int b){
        if(a==0)
            return 0;
        if(a==1)
            return b;
        int s = a<b?a:b;
        int big = a<b?b:a;
        int halfProd = multiply(s>>1,big);
        if(s%2==0)
            return halfProd+halfProd;
       else
            return halfProd+halfProd+big;
    }
}
