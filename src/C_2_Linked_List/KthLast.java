package C_2_Linked_List;

import java.util.Scanner;

/**
 * Created by Shahbaz on 15-May-19.
 */
public class KthLast {
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
        if(k==0){
            System.out.println("Enter value greater than 0");
        }
        int val = sol(head,k);
        System.out.println("Kth to last :"+val);
    }

    static int sol(LinkedListNode head,int k){
        int val=0;

        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        for(int i=0;i<k;i++){
            p1 = p1.next;
        }

        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        val = p2.data;
        return val;
    }
}
