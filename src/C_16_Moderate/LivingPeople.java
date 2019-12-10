package C_16_Moderate;

import java.util.Arrays;
import java.util.Random;

public class LivingPeople {

    static int[] sortYear(Person[] p, boolean birthYear){
        int[] sortedArray = new int[p.length];
        for(int i =0; i < p.length; i++){
            sortedArray[i] = birthYear ? p[i].birthYear : p[i].deathYear;
        }
        Arrays.sort(sortedArray);
        return sortedArray;
    }
    static int maxAliveYear(Person[] p,int min, int max){
        int[] birthYear = sortYear(p,true);
        int[] deathYear = sortYear(p,false);

        int birthIndex = 0;
        int deathIndex = 0;

        int alive = 0;
        int maxAlive = 0;
        int maxAliveYear = 0;

        while(birthIndex < birthYear.length){
            if(birthYear[birthIndex] <= deathYear[deathIndex]) {
                alive++;
                if(maxAlive < alive){
                    maxAlive = alive;
                    maxAliveYear = birthYear[birthIndex];
                }
                birthIndex++;
            }
            else if(birthYear[birthIndex] > deathYear[deathIndex]){
                alive--;
                deathIndex++;
            }
        }
        return maxAlive;
    }

    public static void main(String[] args) {
        int n = 100;
        int first = 1900;
        int last = 2000;

        Random random = new Random();
        Person[] people = new Person[n + 1];
        for (int i = 0; i < n; i++) {
            int birth = first + random.nextInt(last - first);
            int death = birth + random.nextInt(last - birth);
            people[i] = new Person(birth, death);
//            System.out.println(birth + ", " + death);
        }
        people[n] = new Person(first, first);
        System.out.println(maxAliveYear(people,first,last));
    }
}

class Person {
    int birthYear;
    int deathYear;

    public Person(int birthYear, int deathYear) {
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

}
