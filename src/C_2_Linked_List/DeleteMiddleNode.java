package C_2_Linked_List;

import sun.awt.image.ImageWatched;

/**
 * Created by Shahbaz on 16-May-19.
 */
public class DeleteMiddleNode {
    public static void main(String[] args) {
        int[] vals = {4,1,5,6,7,3,2,6,0};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            LinkedListNode node = new LinkedListNode(vals[i], null, null);
            current.next = node;
            current =node;
        }

        System.out.println(head.printForward());
        current = head;
        for(int i =0;i<4;i++){
            current = current.next;
        }

        deleteNode(current);
        System.out.println(head.printForward());
    }

    static void deleteNode(LinkedListNode node){
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
