package C_4_Trees_and_Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shahbaz on 26-Aug-19.
 */
public class PathsWithSum {
    public static void main(String[] args) {
        int[] arr = {3,-2,3,5,2,1,10,-3,11};
        BST rootNode = BST.createBSTFromArray(arr);
        int sum =8;
        int paths = findPaths(rootNode,sum);
        System.out.println(paths);
    }
    //Brute-force method
    static int findPaths(BST node,int sum){
        ArrayList<BST> allnodes = new ArrayList<>();
        allnodes = node.getAllNodes(allnodes);
        int count = 0;
        for(BST n : allnodes){
            count+=getPath(n,sum,0);
        }
        return count;
    }

    static int getPath(BST node,int targetSum,int levelsum){
        if(node == null)
            return 0;
        levelsum+= node.getData();
        if(levelsum==targetSum)
            return 1;
        else{
            int l = getPath(node.getLeft(),targetSum,levelsum);
            int r = getPath(node.getRight(),targetSum,levelsum);
            return l+r;
        }
    }




}
