package C_10_Sorting_and_Searching;

public class SortedSearch {

    static int findLength(Listy a, int i){
        if(a == null)
            return  0;
        while(a.get(i-1) != -1)
            i *=2;
        int h = i; int l = i/2;
        while (l < h) {
            int mid = ((l + h) / 2);
            if( a.get(mid) != -1 && a.get(mid+1) == -1)
                return mid;
            if (a.get(mid) == -1)
                h = mid;
            else
                l = mid + 1;
        }
        return -1;
    }

    static int binarySearch(Listy a, int l,int r, int value){
        int mid = (l+r) / 2;
        if(a.get(mid) == value){
            return mid;
        }
        else if(a.get(mid) < value){
            return binarySearch(a,mid + 1,r,value);
        }
        else
            return binarySearch(a,l,mid-1,value);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 6, 7, 9, 10, 15, 20, 191};
        Listy list = new Listy(array);
        int l = findLength(list,1);
        int pos = binarySearch(list,0, l, 15);
        System.out.println(pos);
    }
}

class Listy {
    private int[] array;

    public Listy(int[] arr){
        this.array = arr;
    }

    int get(int i){
        try{
            return array[i];
        }
        catch (ArrayIndexOutOfBoundsException e){
            return -1;
        }
    }
}
