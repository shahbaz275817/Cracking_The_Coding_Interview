package C_16_Moderate;

public class FactorialZeros {
    public static void main(String[] args) {
        int n = 101;
        int offset = 5;
        int count = 0;
        while(offset < n){
            int temp = n;
            for(int i = 2; i < n; i++){
                if(temp % offset == 0)
                    count++;
                temp--;
            }
            offset *= 5;
        }
        System.out.println(count);
    }
}
