package C_3_Stacks_and_Queues;

/**
 * Created by Shahbaz on 29-May-19.
 */
public class StackMin {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(3);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(10);

        System.out.println("Min "+stack.min());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("Min "+stack.min());
    }
}
