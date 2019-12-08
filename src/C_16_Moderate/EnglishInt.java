package C_16_Moderate;

public class EnglishInt {
    public static void main(String[] args) {
        String s = convert(785423654);
        System.out.println(s);
    }

    static String convert(int num){
        String[] ones = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten","Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] bigs = {"", "Thousand " , "Million ", "Billion "};

        String sol = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++){
            if(num == 0)
                break;
            StringBuilder tsb = new StringBuilder();
            int temp = num%1000;
            if(temp!= 0){
                int val = temp/100;
                if(val != 0)
                    tsb.append(ones[val]).append(" Hundred ");
            }
            temp %=100;
            if(temp/10 != 0){
                int t = temp/10;
                if(t == 1) {
                    tsb.append(ones[t]);
                    continue;
                }
                tsb.append(tens[t]).append(" ");
                tsb.append(ones[temp%10]).append(" ");
            }

            sol = tsb.toString() + bigs[i] + sol;
            //sb.append(tsb.toString(), 0, tsb.toString().length());
            num /=1000;
        }

        return sol;
        //return sb.toString();
    }
}
