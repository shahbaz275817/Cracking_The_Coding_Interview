package C_5_Bit_Manipulation;

/**
 * Created by Shahbaz on 28-Aug-19.
 */
public class BinaryToString {
    public static void main(String[] args) {
        double n = 0.893    ;
        String binaryEquivalent = convertToBinary(n);
        System.out.println(binaryEquivalent);
    }

    static String convertToBinary(double d){
        StringBuilder binary = new StringBuilder(".");
        int i =0;
        while(i<32) {
            d = d*2;
            if (d > 1) {
                binary.append("1");
                d = d - 1;
            } else
                binary.append("0");
            i++;
        }
        return binary.toString();
    }
}
