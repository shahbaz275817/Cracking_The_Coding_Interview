package C_3_Stacks_and_Queues;

/**
 * Created by Shahbaz on 28-May-19.
 */
public class MultiStack {

    int[] stackArray;
    int numStacks = 3;
    int sizes[];
    int stackCapacity;

    public MultiStack(int stackSize){
        stackCapacity = stackSize;
        stackArray = new int[stackSize*numStacks];
        sizes = new int[numStacks];
    }

    int topIndex(int stackNum){
        int offset = stackNum*stackCapacity;
        int size = sizes[stackNum];
        return offset + size -1;
    }

    void push(int stackNum,int data){
        if(isFull(stackNum)){
            System.out.println("Push failed! Stack is full");
            return;
        }
        sizes[stackNum]++;
        int top = topIndex(stackNum);
        stackArray[top] = data;
    }
    void pop(int stackNum){
        int top = topIndex(stackNum);
        sizes[stackNum]--;
        stackArray[top] = 0;
    }
    void peek(int stackNum){
        System.out.println(stackArray[topIndex(stackNum)]);
    }
    boolean isEmpty(int stackNum){
        return sizes[stackNum]==0;
    }
    boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }

    void printStack(int stackNum){
        for(int i=0;i<stackArray.length;i++)
            System.out.print(stackArray[i]+" ");
        System.out.println();
    }
}
