package C_8_Recursion_and_Dynamic_Programming;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 10;
        moveDisk(n,1,2,3);

    }
    static void moveDisk(int disk,int source,int buffer,int destination){
        if(disk==1)
            System.out.println("move disk " + disk+ " from tower "+source+" to tower "+destination);
        else{
            moveDisk(disk-1,source,destination,buffer);
            System.out.println("move disk " + disk+ " from tower "+source+" to tower "+destination);
            moveDisk(disk-1,buffer,source,destination);

        }

    }

}
