package C_3_Stacks_and_Queues;

import java.util.Random;
import java.util.Set;
import java.util.*;

/**
 * Created by Shahbaz on 30-May-19.
 */
public class StackofPlates {
    public static void main(String[] args) {
        SetOfStacks stacks = new SetOfStacks(0);
        //add values to the stack
        int i = 0;
        while (i < 23){
            stacks = stacks.push(new Random().nextInt(10));
            i++;
        }

        stacks.printStack();
        //pop few elements
        stacks = stacks.pop();
        stacks = stacks.pop();
        stacks = stacks.pop();
        stacks = stacks.pop();

        stacks.popAt(2);
        System.out.println("################");
        stacks.printStack();
    }


}


class SetOfStacks{
    int THRESHOLD = 5;
    int size;
    private int values[];
    SetOfStacks prevSet;
    private int setIndex;

    public SetOfStacks(int index){
        size = -1;
        values = new int[THRESHOLD];
        setIndex = index;
    }
    //add values to stack, if the stack get full then a new stack is created and is added to the top of old stack.
    SetOfStacks push(int data){
        if(size==THRESHOLD-1){
            SetOfStacks newSet = new SetOfStacks(this.setIndex+1);
            newSet.prevSet = this;
            newSet.size++;
            newSet.values[newSet.size] = data;
            return newSet;
        }
        size++;
        values[size]=data;

        return this;
    }
    SetOfStacks pop(){
        values[size]=0;
        size--;
        if(this.size==-1){
            return prevSet;
        }
        return this;
    }
    void popAt(int index){
        if(this.setIndex!=index)
            prevSet.popAt(index);
        this.pop();
    }

    void printStack(){
        int size = this.size;
        for(int i=size;i>=0;i--){
            System.out.println(values[i]);
        }
        if(this.prevSet==null)
            return;
        this.prevSet.printStack();

    }
}