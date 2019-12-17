package C_16_Moderate;

public class SubSort {

    static int findRightSequenceStart(int[] array){
        int lastNo =  0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            if(max > array[i])
                lastNo = i;
            max = Math.max(max, array[i]);
        }
        return lastNo;
    }
    static int findLeftSequenceEnd(int[] array){
        int lastNo = 0;
        int min = Integer.MAX_VALUE;
        for(int i = array.length - 1; i >= 0; i--){
            if(min < array[i]){
                lastNo = i;
            }
            min = Math.min(min, array[i]);
        }
        return lastNo;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 4, 7, 10, 11, 8, 12, 5, 6, 16, 18, 19};
        int m = findRightSequenceStart(input);
        int n = findLeftSequenceEnd(input);
        System.out.println("("+n+", "+m+")");
    }
}
