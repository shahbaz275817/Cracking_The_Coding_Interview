package C_2_Linked_List;
/*import sun.awt.image.ImageWatched;*/

import java.util.*;
/**
 * Created by Shahbaz on 16-May-19.
 */
public class Partition {
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
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        partition(head,k);
        System.out.println(head.printForward());
    }

    static void partition(LinkedListNode head, int k){
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        while(p1!=null){
            if(p1.data < k){
                p1 = p1.next;
                p2 = p2.next;
            }
            else{
                while(p2.data>=k&& p2.next!=null )
                    p2= p2.next;
                int temp = p1.data;
                p1.data = p2.data;
                p2.data = temp;
                p2 = p1;
                p1 = p1.next;
                p2 = p2.next;
            }
        }
    }

}
