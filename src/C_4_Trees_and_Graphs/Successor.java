package C_4_Trees_and_Graphs;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Shahbaz on 09-Jul-19.
 */
public class Successor {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        BST root = BST.createBSTFromArray(array);
        for (int i = 0; i < array.length; i++) {
            BST node = root.find(array[i]);
            BST next = next(node,node.getParent());
            if (next != null) {
                System.out.println(node.getData() + "->" + next.getData());
            } else {
                System.out.println(node.getData() + "->" + null);
            }
        }

        //System.out.println(next(root,null).getData());
    }

    static BST next(BST n, BST parent){
        if(n.getRight()!=null){
            return nextLeft(n.getRight());
        }
        else{
          BST q = n;
          BST x = q.getParent();
          while(x!=null&&x.getLeft()!=q){
              q=x;
              x=x.getParent();
          }
          return x;
        }
    }

    static BST nextLeft(BST node){
        if(node==null)
            return null;
        while(node.getLeft()!=null)
            node=node.getLeft();

        return node;
    }
}
