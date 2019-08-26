package C_2_Linked_List;

import com.sun.scenario.effect.impl.state.LinearConvolveKernel;
import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/**
 * Created by Shahbaz on 17-May-19.
 */
public class SumList {
    //this variable is used to hold carry value during recursion callbacks as java functions are unable to return multiple values
    //comment out this line while running reverseSum function
    static int carry = 0;
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

        System.out.println(head1.printForward()+" + "+head2.printForward());
        //LinkedListNode sum = reverseSum(head1,head2);
        LinkedListNode sum = sum(head1,head2);
        System.out.println(sum.printForward());
    }

    static LinkedListNode reverseSum(LinkedListNode node1, LinkedListNode node2){
        LinkedListNode sum = new LinkedListNode();
        LinkedListNode sumHead = sum;
        int carry = 0;
        while(node1!=null&&node2!=null){
            int a,b;
            if(node1==null) a=0; else a=node1.data;
            if(node2==null) b=0; else b=node2.data;
            int d = a+b;
            int digit = d +carry;
            carry = digit/10;
            sum.data = digit%10;
            if(node1.next!=null&&node2.next!=null&&carry!=0) {
                LinkedListNode node = new LinkedListNode();
                sum.next = node;
                sum = node;
            }
            node1 = node1.next;     node2 = node2.next;
        }
        if(carry!=0){
            LinkedListNode node = new LinkedListNode(carry);
            sum.next = node;
        }
        return sumHead;
    }

    static LinkedListNode sum(LinkedListNode head1, LinkedListNode head2){
        int l1 = length(head1);
        int l2 = length(head2);
        if(l1<l2){
            head1 = padList(head1,l2-l1);
        }
        if(l1>l2){
            head2 = padList(head2,l1-l2);
        }
        LinkedListNode sumHead = new LinkedListNode();
        LinkedListNode sum = sumList(sumHead,head1,head2);

        return sum;
    }

    static LinkedListNode sumList(LinkedListNode sumHead,LinkedListNode head1, LinkedListNode head2){
        if(head1.next==null&&head2.next==null){
            int d = head1.data+head2.data;
            int digit = (d +carry)%10;
            carry = d/10;
            sumHead.data = digit;
            return sumHead;
        }
        sumHead.next = new LinkedListNode();
        LinkedListNode node = sumList(sumHead.next,head1.next,head2.next);
        int d = head1.data+head2.data;
        int digit = (d+carry)%10;
        carry = (d+carry)/10;
        sumHead.data = digit;
        return sumHead;
    }

    static LinkedListNode padList(LinkedListNode head,int count){
        while(count!=0){
            LinkedListNode node = new LinkedListNode(0);
            node.next = head;
            head = node;
            count--;
        }
        return head;
    }
    static int length(LinkedListNode head){
        if(head == null)
            return 0;
        else
            return 1+length(head.next);
    }

}
