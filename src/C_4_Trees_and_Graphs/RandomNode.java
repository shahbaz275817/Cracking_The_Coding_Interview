package C_4_Trees_and_Graphs;

import java.util.Random;

/**
 * Created by Shahbaz on 24-Aug-19.
 */
public class RandomNode {
    public static void main(String[] args) {
        BST root =  new BST();
        int[] array = {20,100, 50, 20, 75, 150, 120, 170};
        for (int a : array) {
            root.insertInOrder(a);
        }
        System.out.println(getRandomNode(root).getData());
    }

    static BST getRandomNode(BST node){
        int leftSize = node.getLeft() == null? 0: node.getLeft().getSize();
        Random random  = new Random();
        int index = random.nextInt(node.getSize());
        if(index<leftSize){
            return getRandomNode(node.getLeft());
        }
        else if(index == leftSize)
            return node;
        else
            return getRandomNode(node.getRight());
    }
}



