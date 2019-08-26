package C_4_Trees_and_Graphs;

/**
 * Created by Shahbaz on 20-Jun-19.
 */
public class CheckBalanced {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,15,23,71,50};
        BST rootNode = BST.createBSTFromArray(arr);
        System.out.println(checkBalanced(rootNode));
    }


    static boolean checkBalanced(BST node){
        if(node.getRight()==null||node.getLeft()==null)
            return true;
        boolean balanced = Math.abs(node.getLeft().height()-node.getRight().height())<2?true:false;
        boolean leftBal = checkBalanced(node.getLeft());
        boolean rightBal = checkBalanced(node.getRight());

        return balanced&rightBal&leftBal;
    }


}


