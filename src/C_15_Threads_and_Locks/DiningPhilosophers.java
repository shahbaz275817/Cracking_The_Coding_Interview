package C_15_Threads_and_Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    public static void main(String[] args) {

        Fork forks[] = new Fork[5];
        for(int i=0;i<5;i++){
            forks[i] = new Fork(i);
        }

        Philosopher philosophers[] = new Philosopher[5];
        for(int i = 0;i<5;i++){
            philosophers[i] = new Philosopher(i,forks[i],forks[(i+1)%5]);  //left and right forks
        }

        for(int i=0;i<5;i++){
            Thread thread = new Thread(philosophers[i]);
            thread.start();
        }
    }

}

class Philosopher implements Runnable{
    private Fork left, right;
    int id;
    public Philosopher(int id, Fork left, Fork right){
        this.id = id;
        this.left = left;
        this.right = right;
    }

    void eat() throws InterruptedException {
        // with dead-lock
        /*while(!left.takeFork());
        System.out.println(this.id+" took left fork"+ left.id);
        while(!right.takeFork());
        System.out.println(this.id+" took right fork"+  right.id);*/


        while(true) {
            while (!left.takeFork()) ;
            Thread.sleep(500);
            if (right.takeFork()){
                System.out.println(this.id + " took left fork" + left.id);
                System.out.println(this.id + " took right fork" + right.id);
                break;
            }
            else {
                left.releaseFork();
            }
        }

        System.out.println(this.id+" Eating....");
        Thread.sleep((long) Math.random());
        left.releaseFork();
        right.releaseFork();
        System.out.println(this.id+" released forks");

    }
    @Override
    public void run() {
        try {
            eat();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class Fork{
    private Lock lock;
    int id;
    public Fork(int id){
        this.lock = new ReentrantLock();
        this.id = id;
    }

    boolean takeFork() throws InterruptedException {
        try{
             return this.lock.tryLock();
        }
        catch (Exception e){
            return false;
        }
    }

    void releaseFork(){
        this.lock.unlock();
    }
}