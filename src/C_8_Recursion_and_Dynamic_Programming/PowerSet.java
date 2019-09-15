package C_8_Recursion_and_Dynamic_Programming;

import javax.naming.MalformedLinkException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.spi.AbstractResourceBundleProvider;

public class PowerSet {
    public static void main(String[] args) {
        Integer set[] = {1,2,4,5,6,7,10};
        ArrayList<Integer> set1 = new ArrayList<Integer>();
        set1.addAll(Arrays.asList(set));
        ArrayList<ArrayList<Integer>> allSubsets = getSubsets(set1,0);
        System.out.println(allSubsets.toString());

    }

    static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set,int index){
        ArrayList<ArrayList<Integer>> allSubsets;
        if(index==set.size()) {
            allSubsets = new ArrayList<ArrayList<Integer>>();;
            allSubsets.add(new ArrayList<Integer>());
        }
        else{
            //bottom up approach same as textbook soln. Top down is getting way too complicated to implement
            allSubsets = getSubsets(set,index+1);
            ArrayList<ArrayList<Integer>> moreSubset = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset: allSubsets){
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(set.get(index));
                moreSubset.add(newSubset);
            }
            allSubsets.addAll(moreSubset);
        }
        return allSubsets;
    }

}
