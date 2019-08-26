package C_3_Stacks_and_Queues;

import java.util.LinkedList;

/**
 * Created by Shahbaz on 03-Jun-19.
 */
public class AnimalShelter {
    public static void main(String[] args) {
        AnimalQueue animals =  new AnimalQueue();
        animals.dogs.add(++animals.order);
        animals.dogs.add(++animals.order);
        animals.cats.add(++animals.order);
        animals.cats.add(++animals.order);
        animals.dogs.add(++animals.order);
        animals.dogs.add(++animals.order);
        animals.cats.add(++animals.order);
        animals.dogs.add(++animals.order);
        animals.cats.add(++animals.order);
        System.out.println(animals.deQueueAny());
        System.out.println(animals.dequeueCat());
        System.out.println(animals.dequeueDog());
    }
}

class AnimalQueue{
    LinkedList<Integer> dogs = new LinkedList<>();
    LinkedList<Integer> cats = new LinkedList<>();
    int order = 0;

    public void enqueue(){

    }

    public String deQueueAny(){
        if(dogs.peekFirst()<cats.peekFirst())
            return "Dog removed. ID: "+dogs.pollFirst().toString();
        else
            return "Cat removed. ID: "+cats.pollFirst().toString();

    }

    public String dequeueCat(){
        return "removed cat id: "+cats.pollFirst().toString();
    }

    public String dequeueDog(){
        return "removed dog id: "+dogs.pollFirst().toString();
    }
}
