package C_10_Sorting_and_Searching;

public class SortedMerge {

    static void merge(int a[], int b[], int ia,int ib,int x){
        if(x<0)
            return;

        if(ia>=0 && a[ia]>b[ib]){
            a[x] = a[ia];
            ia -=1;
        }
        else {
            a[x] = b[ib];
            ib -=1;
        }
        merge(a,b,ia,ib,--x);
    }





    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 7, 6, 7, 7};
        merge(a, b, 8-1, 6-1,a.length-1);
        for(int x: a){
            System.out.print(x+" ");
        }
    }
}
