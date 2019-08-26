package C_3_Stacks_and_Queues;

import java.util.*;
import java.util.Stack;

/**
 * Created by Shahbaz on 02-Jun-19.
 */
public class SortStack {
    public static void main(String[] args) {
        java.util.Stack<Integer> stack1 = new Stack<>();
        stack1.add(5);
        stack1.add(6);
        stack1.add(3);
        stack1.add(4);
        stack1.add(1);
        stack1.add(7);
        Stack sortedStack = sortStack(stack1);
        for(int i =0 ;i<sortedStack.toArray().length;i++)
            System.out.println(sortedStack.toArray()[i]);
    }

    static Stack sortStack(Stack<Integer> stack){
        Stack<Integer> stack2 = new Stack<>();
        while(!stack.isEmpty()){
            stack2.push(stack.pop());
            if(!stack2.isEmpty()&&!stack.isEmpty()&&stack2.peek()>stack.peek()){
                int temp;
                temp = stack2.pop();
                stack2.push(stack.pop());
                stack.push(temp);
            }
            //re-arrange the second stack
            int i =0;
            while(!stack2.isEmpty()){
                stack.push(stack2.pop());
                if(!stack2.isEmpty()&&!stack.isEmpty()&&stack2.peek()>stack.peek()){
                    int temp;
                    temp = stack2.pop();
                    stack2.push(stack.pop());
                    stack.push(temp);
                }
                i++;
            }
            for(int j=0;j<i;j++){
                stack2.push(stack.pop());
            }
        }
        while(!stack2.isEmpty())
            stack.push(stack2.pop());
        return stack;
    }
}
