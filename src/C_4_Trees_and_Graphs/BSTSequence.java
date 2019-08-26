package C_4_Trees_and_Graphs;

import com.sun.javafx.image.IntPixelGetter;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.*;

/**
 * Created by Shahbaz on 17-Jul-19.
 */
public class BSTSequence {

    static void weaved(LinkedList<Integer> first, LinkedList<Integer> second,ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix){
        if(first.size()==0||second.size()==0){
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaved(first,second,results,prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaved(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);

    }


    static ArrayList<LinkedList<Integer>> allSequences(BST node){
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if(node == null){
            result.add(new LinkedList<Integer>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(node.getData());

        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.getLeft());
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.getRight());

        for(LinkedList<Integer> left: leftSeq){
            for(LinkedList<Integer> right : rightSeq){
                ArrayList<LinkedList<Integer>> weaved  = new ArrayList<>();
                weaved(right,left,weaved,prefix);
                result.addAll(weaved);
            }
        }


        return result;
    }


    public static void main(String[] args) {
        BST root =  new BST();
        int[] array = {100, 50, 20, 75, 150, 120, 170};
        for (int a : array) {
            root.insertInOrder(a);
        }
        ArrayList<LinkedList<Integer>> allSeq = allSequences(root);

        for(LinkedList<Integer> list: allSeq){
            System.out.println(list);
        }
        System.out.println(allSeq.size());
    }
}
