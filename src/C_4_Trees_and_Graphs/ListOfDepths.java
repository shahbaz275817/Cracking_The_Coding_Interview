package C_4_Trees_and_Graphs;

/*import sun.awt.image.ImageWatched;*/

import java.util.*;

/**
 * Created by Shahbaz on 14-Jun-19.
 */
public class ListOfDepths {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        BST rootNode = BST.createBSTFromArray(arr);
        System.out.println("Height of the tree: "+rootNode.height());

        ArrayList<LinkedList<BST>> list = createList(rootNode,rootNode.height());

        for(int i=0;i<list.size();i++){
            LinkedList<BST> listHead = list.get(i);
            Iterator<BST> itr = listHead.listIterator();
            while(itr.hasNext()){
                BST node = itr.next();
                System.out.print(node.getData()+" ");
            }
            System.out.println();
        }
    }

    static ArrayList<LinkedList<BST>> createList(BST node,int depth){
        ArrayList<LinkedList<BST>> list = new ArrayList<>(depth);
        LinkedList<BST> current = new LinkedList<>();
        current.add(node);
        list.add(current);

        for(int i=0;i<depth;i++){
            LinkedList<BST> temp  = new LinkedList<>();
            for(BST n: current){
                BST left = n.getLeft();
                BST right = n.getRight();
                if(left!=null)
                    temp.add(left);
                if(right!=null)
                    temp.add(right);
            }
            current = temp;
            list.add(current);
        }
        return list;
    }
}

