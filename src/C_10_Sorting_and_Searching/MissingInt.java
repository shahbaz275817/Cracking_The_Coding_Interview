package C_10_Sorting_and_Searching;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MissingInt {
    static long noOfInts = ((long) Integer.MAX_VALUE) + 1;
    static byte[] bitField = new byte[(int) (noOfInts / 8)];

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(("/path/input.txt")));
        while(sc.hasNext()){
            int n = sc.nextInt();
            //add the number into the bit vector
            bitField[n / 8] |= 1 << (n % 8);
        }

        //find the missing int
        for(int i = 0; i < bitField.length; i++){
            for(int j = 0; j < 8; j++){
                if((bitField[i] & (1 << j)) == 0){
                    System.out.println("The missing int is: " + (i*8 + j));
                    return;
                }
            }
        }
    }
}
