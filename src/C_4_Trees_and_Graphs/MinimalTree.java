package C_4_Trees_and_Graphs;

/**
 * Created by Shahbaz on 13-Jun-19.
 */
public class MinimalTree {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        BST rootNode = BST.createBSTFromArray(arr);
        System.out.println("Height of the tree: "+rootNode.height());
    }
}

