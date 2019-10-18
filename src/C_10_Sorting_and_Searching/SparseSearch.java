package C_10_Sorting_and_Searching;

public class SparseSearch {

    private static int search(String[] strings, String str, int first, int last){
        int mid = (first + last) / 2;

        if(strings[mid].isEmpty()){
            int left = mid - 1;
            int right = mid + 1;

            while(true){
                if(left < first && right > last)
                    return -1;
                else if(left >= first && !strings[left].isEmpty() ){
                    mid = left;
                    break;
                }
                else if(right <= last && !strings[right].isEmpty()){
                    mid = right;
                    break;
                }
                left--; right++;
            }
        }
        if(strings[mid].equals(str)){
            return mid;
        }
        else if(strings[mid].compareTo(str) > 0)
            return search(strings, str, first, mid - 1);
        else
            return search(strings, str, mid + 1, last);
    }

    private static int search(String[] arr,String value){
        if(value == null || arr == null || value.isEmpty())
            return -1;
        return search(arr, value, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        String[] stringList = {"apple", "", "", "banana", "", "", "", "carrot", "duck", "", "", "eel", "", "flower"};
        System.out.println(search(stringList, "banana"));
    }
}
