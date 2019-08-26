package C_3_Stacks_and_Queues;

import java.util.*;
import java.util.Stack;

/**
 * Created by Shahbaz on 31-May-19.
 */
public class QueueviaStacks {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.pop();
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.pop();
    }
}

class MyQueue{
    private java.util.Stack<Integer> stack1 = new Stack<>();
    private java.util.Stack<Integer> stack2 = new Stack<>();

    void push(int data){
            stack1.push(data);
    }
    void pop(){
        if(!stack2.isEmpty()){
            System.out.println(stack2.pop());
        }
        else{
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            System.out.println(stack2.pop());
        }
    }

}