package C_8_Recursion_and_Dynamic_Programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.Comparator;

public class StackOfBoxes {

    static int getRandomPoint(){
            return (int) (Math.random() * 10);
    }

    static boolean canAddInStack(Box b,Box box){
        if(b == null || box == null){
            return true;
        }

        if(b.height <= box.height || b.width <= box.width || b.depth <= box.depth)
            return false;

        return true;
    }

    static int findMaxHeight(ArrayList<Box> boxes,int currentHeight,Stack<Box> stack, int i){
        if(i >= boxes.size()){
            return 0;
        }
        // call recursive function twice once by adding the ith box and one by not adding the ith box;
        // and also add the box only if it can be added;
        // if current height greater than max height then update the max height
        int a = 0;
        int maxHeight = 0;
        Box topOfStack = stack.isEmpty()?null:stack.peek();
        if(canAddInStack(topOfStack,boxes.get(i))){
            stack.add(boxes.get(i));
            currentHeight += boxes.get(i).height;
            a = currentHeight + findMaxHeight(boxes,currentHeight,stack,i+1);
            if(!stack.empty())
                stack.pop();
            currentHeight -= boxes.get(i).height;
            a -= currentHeight;
        }
        int b = findMaxHeight(boxes,currentHeight,stack,i+1);
        maxHeight = Math.max(a,b);

        return maxHeight;

    }

    public static void main(String[] args) {
       /* int numBoxes = 10;
        Box boxes[] = new Box[numBoxes];
        for(int i = 0; i < numBoxes; i++){
            boxes[i] = new Box(getRandomPoint(),getRandomPoint(),getRandomPoint());
        }*/
        Box[] boxList = { new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3), new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 7, 3)};
        ArrayList<Box> boxes = new ArrayList<Box>();
        for (Box b : boxList) {
            boxes.add(b);
        }
        Collections.sort(boxes, new BoxComparator());
        Stack<Box> stack  = new Stack<>();
        int h = findMaxHeight(boxes,0,stack,0);
        System.out.println(h);
    }


}

class Box {
    public int width;
    public int height;
    public int depth;

    public Box(int width, int height, int depth){
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public boolean canBeAbove(Box b) {
        if (b == null) {
            return true;
        }
        if (width < b.width && height < b.height && depth < b.depth) {
            return true;
        }
        return false;
    }
}

class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box x, Box y){
        return y.height - x.height;
    }


}
