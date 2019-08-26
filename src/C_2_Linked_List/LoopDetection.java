package C_2_Linked_List;

import java.util.HashSet;

/**
 * Created by Shahbaz on 19-May-19.
 */
public class LoopDetection {
    public static void main(String[] args) {
        int[] vals = {4,1,5,6,7,3,2,9,3,6,0};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            LinkedListNode node = new LinkedListNode(vals[i], null, null);
            current.next = node;
            current =node;
        }

        System.out.println(head.printForward());
        current = head;
        //create a loop
        for(int i=0;i<3;i++){
            current = current.next;
        }
        LinkedListNode node = head;
        while(node.next!=null){
            node = node.next;
        }
        node.next  = current;
        int v = findLoop(head).data;
        System.out.println("The loop starting point node's value: "+v);
    }

    static LinkedListNode findLoop(LinkedListNode head){
        HashSet<LinkedListNode> hs = new HashSet<>();
        while(head!=null){
            if(hs.contains(head)){
                return head;
            }
            else{
                hs.add(head);
                head = head.next;
            }
        }
        return null;
    }
}
