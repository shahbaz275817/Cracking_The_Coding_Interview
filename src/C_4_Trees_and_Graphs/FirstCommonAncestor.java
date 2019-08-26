package C_4_Trees_and_Graphs;

import java.util.HashSet;

/**
 * Created by Shahbaz on 11-Jul-19.
 */
public class FirstCommonAncestor {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        BST rootNode = BST.createBSTFromArray(arr);
        BST n1 = rootNode.find(1);
        BST n2 = rootNode.find(3);
        HashSet<BST> set = new HashSet<>();
        while(n1!=null){
            set.add(n1);
            n1=n1.getParent();
        }
        while(!set.contains(n2)&&n2!=null){
            n2=n2.getParent();
        }
        System.out.println("First Common Ancestor node's data = "+n2.getData());
    }
}
