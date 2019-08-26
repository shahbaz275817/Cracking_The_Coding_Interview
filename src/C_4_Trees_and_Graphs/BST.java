package C_4_Trees_and_Graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Shahbaz on 14-Jun-19.
 */
public class BST {
    private int data;
    private BST left;
    private BST right;
    private BST parent;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public BST(int data){
        this.data = data;
        left = null;
        right = null;
        parent = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BST getRight() {
        return right;
    }

    public void setRight(BST right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }

    public BST(){


    }

    public BST getLeft() {
        return left;
    }

    public void setLeft(BST left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    int height(){
        int leftSubtreeHeight = this.left!=null? this.left.height():0;
        int rightSubtreeHeight = this.right!=null? this.right.height():0;
        return 1+Math.max(leftSubtreeHeight,rightSubtreeHeight);
    }

    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                setLeft(new BST(d));
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                setRight(new BST(d));
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    private static BST createBSTFromArray(int arr[],int start, int end){
        if(start>end)
            return null;
        int mid = (start+end)/2;
        BST node = new BST(arr[mid]);
        node.setLeft(createBSTFromArray(arr,start,mid-1));
        node.setRight(createBSTFromArray(arr,mid+1,end));
        return node;
    }

    public static BST createBSTFromArray(int arr[]){
        return createBSTFromArray(arr,0,arr.length-1);
    }

    public ArrayList<Integer> inOrderTraversal(ArrayList<Integer> tempArray){
        if(this.left!=null)
            this.left.inOrderTraversal(tempArray);
        tempArray.add(this.data);
        if(this.right!=null)
            this.right.inOrderTraversal(tempArray);
        return tempArray;
    }

    ArrayList<BST> getAllNodes(ArrayList<BST> tempArray){
        if(this.left!=null)
            this.left.getAllNodes(tempArray);
        tempArray.add(this);
        if(this.right!=null)
            this.right.getAllNodes(tempArray);
        return tempArray;

    }

    public BST getParent() {
        return parent;
    }

    public BST find(int d){
        if(this.data==d)
            return this;
     else if (d <= data) {
        return left != null ? left.find(d) : null;
    } else if (d > data) {
        return right != null ? right.find(d) : null;
    }
		return null;
    }

}
