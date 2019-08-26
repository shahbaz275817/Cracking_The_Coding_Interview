package C_3_Stacks_and_Queues;

/**
 * Created by Shahbaz on 20-May-19.
 */
public class ThreeInOne {
    public static void main(String[] args) {
        MultiStack stack = new MultiStack(3);

        //push data into stack 1
        stack.push(0,5);
        stack.push(0,1);
        //push data into stack 2
        stack.push(1,4);
        stack.push(1,8);
        //push data into stack 3
        stack.push(2,2);
        stack.push(2,7);

        //peek top
        stack.peek(0);
        stack.peek(1);
        stack.peek(2);
        //pop data from each stack
        stack.pop(0);
        stack.pop(1);
        stack.pop(2);
        //print each stack
        stack.printStack(0);
        stack.printStack(1);
        stack.printStack(2);

    }


}
