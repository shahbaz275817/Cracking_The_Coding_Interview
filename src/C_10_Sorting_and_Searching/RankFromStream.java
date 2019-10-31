package C_10_Sorting_and_Searching;

public class RankFromStream {

    private static RankNode root = null;

    static void track(int number){
        if(root == null){
            root = new RankNode(number);
        }
        else
            root.insert(number);
    }

    static int getRank(int number){
        return root.getRank(number);
    }

    public static void main(String[] args) {
        int[] list = {1,2,2,4,5,6,7,8,9,11,45,62,12,53,64,37};
        for (int i = 0; i < list.length; i++) {
           track(list[i]);
        }

    }
}

class RankNode {
    int data;
    int left_size;
    RankNode left;
    RankNode right;

    public RankNode(int v){
        this.data = v;
        this.left = null;
        this.right = null;
        this.left_size = 0;
    }

    void insert(int d) {
        if (d <= data) {
            if (left != null) {
                left.insert(d);
            } else {
                left = new RankNode(d);
            }
            left_size++;
        } else {
            if (right != null) {
                right.insert(d);
            } else {
                right = new RankNode(d);
            }
        }
    }

    int getRank(int d){
        if(data == d)
            return left_size;
        else if(data< data){
            if(left == null){
                return -1;
            }
            else
                return left.getRank(d);
        }
        else{
            int rightRank = right == null? -1: right.getRank(d);
            if(rightRank == -1)
                return -1;
            else
                return left_size + 1 + rightRank;
        }
    }
}

