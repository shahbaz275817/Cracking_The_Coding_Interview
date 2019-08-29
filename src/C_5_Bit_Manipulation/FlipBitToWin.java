package C_5_Bit_Manipulation;

/**
 * Created by Shahbaz on 29-Aug-19.
 */
public class FlipBitToWin {
    public static void main(String[] args) {
        int n = 466874678;
        String binaryn = Insertion.convertToBinaryString(n);
        int flips = countFlips(binaryn);
        System.out.println(binaryn);
        System.out.println(flips);
    }
    static int countFlips(String binary){
        int count[] = new int[2];       // works almost like 2 stacks to count no of ones
        char[] bits = binary.toCharArray();
        int sum = 0; int bit = 0;
        for(int i=0;i<bits.length;i++) {
            if (bits[i] == '1') {
                count[bit]++;
                if (i != bits.length - 1)
                    continue;
            }
            int temp = count[0] + count[1];
            sum = temp > sum ? temp : sum;
            count[bit^1] = 0;
            bit = bit ^ 1;

        }
        return sum+1;
    }
}
