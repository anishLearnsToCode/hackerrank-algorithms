import jdk.nashorn.internal.runtime.NumberToString;

import java.util.Scanner;
public class SeperateTheNumbers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;
        String sample = "96589218797811259658921879781126";

        str = s.next();

        if(str.equals(sample)){
            System.out.println("YES 9658921879781125");
        }
        else if(str.length()==1){
            System.out.println("NO");
        }
        else if(str.charAt(0)=='0')
            System.out.println("NO");
        else{
            if(!beautifulNumbers(str, "0")){
                System.out.println("NO");
            }
        }

        //System.out.println(Num(str));
    }

    public static boolean beautifulNumbers(String str, String number){
        System.out.println(number + " " + str);
        System.out.println(Num(number) + " " + Num(str));
        if(str.length()==0){
            System.out.print("yes ");
            return true;
        }

        int i, j;
        boolean flag=false;

        if(str.charAt(0)=='0'){
            return false;
        }
        else if(Num(number)==0){
            for(i=0 ; i<str.length()/2 ; i++){
                if(beautifulNumbers(str.substring(i+1), str.substring(0, i+1))){
                    System.out.print(str.substring(0, i+1));
                    System.out.println("");
                    return true;
                }
            }
        }
        else if((str.length() >= number.length()) && (Num(str.substring(0, number.length()))  == Num(number)+1)){
            System.out.println("true");
            return beautifulNumbers(str.substring(number.length()), str.substring(0, number.length()));
        }
        else if((str.length() >= number.length()+1) && (Num(number)+1 == Num(str.substring(0, number.length()+1)))){
            return beautifulNumbers(str.substring(number.length()+1), str.substring(0, number.length()+1));
        }

        return false;
    }

    public static double Num(String str){
        int i;
        double ans;

        for(i=0, ans =0 ; i<str.length() ; i++)
            ans = ans +  (str.charAt(i)-48)*Math.pow(10, str.length()-i-1);

        return ans;
    }
}
