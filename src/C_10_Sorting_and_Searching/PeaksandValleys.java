package C_10_Sorting_and_Searching;

import java.util.Arrays;

public class PeaksandValleys {

    static void sort(int[] arr){
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i=i+2){
            swap(arr,i,i+1);
        }
    }

    static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {48, 40, 31, 62, 28, 21, 64, 40, 23, 17};
        sort(array);
        for(int a: array){
            System.out.print(a+ " ");
        }

    }
}
