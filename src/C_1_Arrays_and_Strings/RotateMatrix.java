package C_1_Arrays_and_Strings;

import java.util.Scanner;

/**
 * Created by Shahbaz on 03-Oct-18.
 */
public class RotateMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++)
                a[i][j] = sc.nextInt();
        }

        for(int k=0;k<(n/2);k++){
            int first = k;
            int last = n-1-k;
            for(int i= first;i<last;i++){
                int offset =i-first;
                int temp = a[first][i]; //save top
                a[first][i] = a[last-offset][first]; // right -> top
                a[last-offset][first] = a[last][last-offset]; //bottom - > right
                a[last][last-offset] = a[i][last]; // left -> bottom
                a[i][last] = temp;
            }
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
