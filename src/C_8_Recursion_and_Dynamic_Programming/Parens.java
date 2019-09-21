package C_8_Recursion_and_Dynamic_Programming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Parens {
    public static void main(String[] args) {
        int n =3;
        var set = getParens(n);
        System.out.println(set.size());
        System.out.println(set.toString());
    }

    static ArrayList<String> getParens(int count){
        var str = new char[count*2];
        var list = new ArrayList<String>();
        addParens(list,count,count,str,0);
        return list;
    }

    static void addParens(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count){
        if(leftRem<0||leftRem>rightRem)
            return;
        if(leftRem==0&&rightRem==0){
            list.add(String.copyValueOf(str));
        }
        else{
            str[count] = '(';
            addParens(list,leftRem-1,rightRem,str,count+1);

            str[count] = ')';
            addParens(list,leftRem,rightRem-1,str,count+1);

        }
    }

}
