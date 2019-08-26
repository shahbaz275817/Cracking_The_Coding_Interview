package C_2_Linked_List;

import java.util.Stack;

/**
 * Created by Shahbaz on 18-May-19.
 */
public class Palindrome {
    public static void main(String[] args) {
        int[] vals = {0,1,1,0};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            LinkedListNode node = new LinkedListNode(vals[i], null, null);
            current.next = node;
            current =node;
        }

        System.out.println(head.printForward());
        if(checkPalindrome(head))
            System.out.println("Palindrome");
        else
            System.out.println("Not palindrome");
    }

    static boolean checkPalindrome(LinkedListNode head){
        int length = head.length(head);
        boolean isEven = length%2==0?true:false;
        Stack<Integer> stack = new Stack<>();
        for(int i=1;i<=length/2;i++){
            stack.push(head.data);
            head = head.next;
        }
        if(!isEven)
            head = head.next;
        for(int i=1;i<=length/2;i++){
            int stackData = stack.pop();
            int nodeData = head.data;
            if(nodeData!=stackData)
                return false;
            head = head.next;
        }

        return true;
    }


}
