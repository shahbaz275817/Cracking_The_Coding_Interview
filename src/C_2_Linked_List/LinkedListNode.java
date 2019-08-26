package C_2_Linked_List;

import sun.awt.image.ImageWatched;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Shahbaz on 13-May-19.
 */
public class LinkedListNode {
    public LinkedListNode next;
    public LinkedListNode prev;
    public LinkedListNode last;
    public int data;

    public LinkedListNode(int d, LinkedListNode n, LinkedListNode p){
        data = d;
        next = n;
        prev = p;
    }

    LinkedListNode(int d){
        data = d;
    }

    LinkedListNode(){}

    public void setNext(LinkedListNode n){
        next = n;
        if(this == last){
            last = n;
        }
        if(n != null && n.prev != this){
            n.setPrevious(this);
        }
    }

    public void setPrevious(LinkedListNode p){
        prev = p;
        if(this!=null  && p.next!=this){
            p.setNext(this);
        }
    }

    public String printForward(){
        if(next!=null){
             return (this.data+"->"+next.printForward());
        }
        else{
            return String.valueOf(((int)this.data));
        }
    }

    public LinkedListNode clone(){
        LinkedListNode next2 = null;
        if(next!=null){
            next2 = next.clone();
        }
        LinkedListNode head2 = new LinkedListNode(data,next2,null);
        return head2;
    }

    public int length(LinkedListNode head){
        if(head == null)
            return 0;
        else
            return 1+length(head.next);
    }

}
