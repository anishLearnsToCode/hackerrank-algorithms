import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;

        str=s.nextLine();
        str = time_func(str);
        System.out.println(str);
    }

    public static String time_func(String str){
        String ans ="";
        ans = ans + parse(str.substring(0, 2), str.substring(8));
        ans = ans + str.substring(2, 8);

        return ans;
    }

    public static String parse(String str, String median){
        String ans = StrNum(Num(str), median);
        return ans;
    }

    public static int Num(String str){
        int sum, i;

        for(i=str.length()-1, sum=0 ; i>=0 ; i--){
            sum += (str.charAt(i)-48)*Math.pow(10, str.length()-i-1) ;
        }

        return sum;
    }

    public static String StrNum(int num, String median){
        String ans;
        System.out.println(median);

        if(num == 12){
            ans = 00+"";
        }
        else if(median.compareTo("AM")==0){
            if(num<10){
                ans = "0"+num;
            }else{
                ans = num + "";
            }
        }
        else {
            ans = num + 12 +"";
        }

        return ans;
    }
}
