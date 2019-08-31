package C_5_Bit_Manipulation;

/**
 * Created by Shahbaz on 30-Aug-19.
 */
public class NextNumber {
    public static void main(String[] args) {
        int n = 10115;
        System.out.println(Insertion.convertToBinaryString(n));
        printNext(n);
        printPrevious(n);
    }

    static void printNext(int n){
        //Compute c0 and c1
        int c = n,c0=0,c1=0;
        while((c&1)==0&&(c!=0)){
            c0++;
            c >>= 1;
        }
        while((c&1)==1){
            c1++;
            c >>=1;
        }
        int p = c0 + c1;
        n = n | (1<<p); // flip the p bit to 1
        n = n & (~0<< (p)); //set all the bits from right of p to 0
        n = n | ~(~0<<(c1-1)); // insert c1-1 bits from the right side
        System.out.println(Insertion.convertToBinaryString(n));
    }

    static void printPrevious(int n){
        //Compute c0 and c1
        int c = n,c0=0,c1=0;
        while((c&1)==1){
            c1++;
            c >>=1;
        }
        while((c&1)==0&&(c!=0)){
            c0++;
            c >>= 1;
        }
        int p = c0 + c1;
        //n = n & ~(1<<p); // flip the p bit to 0
        //System.out.println(Insertion.convertToBinaryString(n));
        n  =  n & (~0<<p+1); // clear all bits to right of p

        // set the c1 bits to 1 after p
        n |= (~(~0<<(c1+1)))<<(p-1-c1);
        System.out.println(Insertion.convertToBinaryString(n));
    }

}
