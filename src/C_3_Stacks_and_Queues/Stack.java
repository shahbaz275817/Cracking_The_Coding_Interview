package C_3_Stacks_and_Queues;

/**
 * Created by Shahbaz on 29-May-19.
 */
public class Stack {
    private int data[];
    private int min[];
    private int top;

    public Stack(){}
    public Stack(int stackSize){
        data = new int[stackSize];
        min = new int[stackSize];
        top = -1;
    }

    int topIndex(){
        return top;
    }

    void push(int data){
        top++;
        this.data[top]=data;
        if(top==0)
            min[0]=data;
        else if(min[top-1]>=data)
            min[top]=data;
        else
            min[top]=min[top-1];
    }
    void pop(){
        this.data[top]=0;
        min[top]=0;
        top--;
    }
    int min(){
        return min[top];
    }

}
