package C_1_Arrays_and_Strings;
import java.util.*;
/**
 * Created by Shahbaz on 06-Oct-18.
 */
public class ZeroMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*System.out.println("enter the size of matrix");
        int n =sc.nextInt();*/
        int a[][] = {{0,0,2},{3,4,5},{6,7,8}};//new int[n][n];
        boolean b[][] = new boolean[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(a[i][j]==0)
                    b[i][j]=true;
            }
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(b[i][j]==true){
                    for(int k=0;k<3;k++){
                        a[i][k]=0;
                        a[k][j]=0;
                    }
                }
            }
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }

    }
}
