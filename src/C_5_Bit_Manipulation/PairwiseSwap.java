package C_5_Bit_Manipulation;

public class PairwiseSwap {
    public static void main(String[] args) {
        int n = 2456342;
        swap(n);
    }

    static void swap(int n){
        System.out.println(Insertion.convertToBinaryString(n));
        int newNum = (n & 0xAAAAAAAA) >>> 1 | (n & 0x55555555) << 1;
        System.out.println(Insertion.convertToBinaryString(newNum));
    }
}
