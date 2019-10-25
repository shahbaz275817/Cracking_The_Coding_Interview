package C_10_Sorting_and_Searching;


public class FindDuplicates {

    static void findDuplicates(int[] arr){

        BitVector bv = new BitVector(100);

        for(int i = 0;i < arr.length; i++){
            int num = arr[i];
            int num0 = num -1;
            if(bv.get(num0)==1)
                System.out.println(num);
            else
                bv.set(num0);
        }
    }



    public static void main(String[] args) {
        int[] array = {3,6,7,1,5,7,3};
        findDuplicates(array);
    }

}

//custom bit vector which works like hash table of factor n
class BitVector{
    private byte[] bitSet;
    public BitVector(int size){
        bitSet = new byte[(size / 32 ) + 1];
    }

    int get(int pos){
        int arrayIndex = pos / 32; //word number
        int indexOffset = pos % 32; //bit number
        if((bitSet[arrayIndex] & 1 << indexOffset) !=0)
            return 1;
        return 0;
    }

    void set(int pos){
        int arrayIndex = pos / 32; //word number
        int indexOffset = pos % 32; //bit number
        bitSet[arrayIndex] |= 1 << indexOffset;
    }
}