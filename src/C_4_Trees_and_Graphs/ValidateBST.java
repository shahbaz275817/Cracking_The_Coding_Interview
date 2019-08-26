package C_4_Trees_and_Graphs;

import java.util.ArrayList;

/**
 * Created by Shahbaz on 04-Jul-19.
 */
public class ValidateBST {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        BST rootNode = BST.createBSTFromArray(arr);
        System.out.println(validateInorder(rootNode));
        System.out.println(validateRecursion(rootNode,null,null));
    }

    static boolean validateInorder(BST node){
        ArrayList<Integer> list = new ArrayList<>();
        list = node.inOrderTraversal(list);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>list.get(i+1))
                return false;
        }
        return true;
    }

    static boolean validateRecursion(BST node,Integer min,Integer max){
        if(node==null)
            return true;
        if(min!=null&&node.getData()<=min||max!=null&&node.getData()>max)
            return false;
        boolean x = validateRecursion(node.getLeft(),min,node.getData());
        boolean y = validateRecursion(node.getRight(),node.getData(),max);
        return x&y;
    }
}
