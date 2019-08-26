package C_2_Linked_List;

import java.util.HashSet;

/**
 * Created by Shahbaz on 18-May-19.
 */
public class Intersection {
    public static void main(String[] args) {
        int[] vals1 = {1,9,7,8};
        int[] vals2 = {6,8,5};
        LinkedListNode head1 = new LinkedListNode(vals1[0], null, null);
        LinkedListNode head2 = new LinkedListNode(vals2[0], null, null);
        LinkedListNode current1 = head1;
        LinkedListNode current2 = head2;
        for (int i = 1; i < vals1.length; i++) {
            LinkedListNode node = new LinkedListNode(vals1[i], null, null);
            current1.next = node;
            current1 =node;
        }
        for (int i = 1; i < vals2.length; i++) {
            LinkedListNode node = new LinkedListNode(vals2[i], null, null);
            current2.next = node;
            current2 =node;
        }

        current1.next = head2;
        System.out.println(head1.printForward());
        System.out.println(head2.printForward());
        LinkedListNode intersectionPointNode = checkIntersection(head1,head2);
        if(intersectionPointNode==null)
            System.out.println("No intersection point");
        else
            System.out.println("value of intersection node = "+intersectionPointNode.data);
    }

    static LinkedListNode checkIntersection(LinkedListNode node1, LinkedListNode node2){
        HashSet<LinkedListNode> hashSet = new HashSet<>();
        while(node1!=null){
            hashSet.add(node1);
            node1 = node1.next;
        }
        while(node2!=null){
            if(hashSet.contains(node2)){
                return node2;
            }
            node2 = node2.next;
        }
        return null;
    }
}
