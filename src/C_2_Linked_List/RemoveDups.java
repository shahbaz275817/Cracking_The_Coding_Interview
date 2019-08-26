package C_2_Linked_List;

import sun.awt.image.ImageWatched;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * Created by Shahbaz on 13-May-19.
 */
public class RemoveDups {
    public static void main(String[] args) {
        LinkedListNode first = new LinkedListNode();
        LinkedListNode head = first;
        LinkedListNode second =first;
        for(int i=0;i<10;i++){
            second = new LinkedListNode(i%2,null,null);
            first.setNext(second);
            second.setPrevious(first);
            first=second;
        }
        System.out.println(head.printForward());
        //removeDupsBuffer(head);
        removeDupsWitoutBuffer(head);
        System.out.println(head.printForward());

    }
    static void removeDupsBuffer(LinkedListNode node){
        HashSet<Integer> hs = new HashSet<>();
        LinkedListNode previous = null;
        while(node!=null){
            if(!hs.contains(node.data)){
                hs.add(node.data);
                previous = node;
            }
            else{
                previous.next = node.next;
            }
            node = node.next;
        }

    }

    static void removeDupsWitoutBuffer(LinkedListNode head){
        LinkedListNode current = head;
        while(current!=null){
            int data = current.data;
            LinkedListNode runner = current;
            while(runner.next !=null){
                if(runner.next.data == data){
                    runner.next = runner.next.next;
                }
                else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
