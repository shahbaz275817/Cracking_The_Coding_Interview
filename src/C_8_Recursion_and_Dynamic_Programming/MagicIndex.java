package C_8_Recursion_and_Dynamic_Programming;

public class MagicIndex {
    public static void main(String[] args) {
        int array[] = {-1,0,2,4};
        int magicIndex = findMagicIndex(array,0,array.length-1);
        System.out.println(magicIndex);
    }
    static int findMagicIndex(int[] a,int l,int r){
        int m = (r+l)/2;
        if(a[m]==m)
            return m;
        if(l>=r)
            return -1;
        else if(a[m]>m)
            return (findMagicIndex(a,l,m));
        else
            return(findMagicIndex(a,m+1,r));
    }
}
