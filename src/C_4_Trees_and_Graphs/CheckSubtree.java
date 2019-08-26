package C_4_Trees_and_Graphs;

/**
 * Created by Shahbaz on 22-Jul-19.
 */
public class CheckSubtree {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,15,23,71,50};
        int[] arr1 = {4,5,6,71,50};
        BST rootNode1 = BST.createBSTFromArray(arr);
        BST rootNode2 = BST.createBSTFromArray(arr1);
    }

    static boolean checkTree(BST r1,BST r2) {
        if(r1==null)
            return false;
        else if(r1.getData()==r2.getData()&&matchTree(r1,r2))
            return true;

        return checkTree(r1.getLeft(),r2) || checkTree(r1.getRight(),r2);
    }

    static boolean matchTree(BST n1,BST n2){
        if(n1==null && n2 == null)
            return true;
        else if(n1==null || n2 == null)
            return false;
        else if(n1.getData()!=n2.getData())
            return false;
        return matchTree(n1.getLeft(),n2.getLeft())&&matchTree(n1.getRight(),n2.getRight());
    }
}
