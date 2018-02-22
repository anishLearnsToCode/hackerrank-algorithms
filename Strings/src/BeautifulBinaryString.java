import java.util.Scanner;
public class BeautifulBinaryString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ans;
        String str;

        str = s.next();
        ans = minSteps(str);
        System.out.println(ans);
    }

    public static int minSteps(String str){
        int i, steps;

        for(i=0, steps=0 ; i<str.length()-2 ; ){

            if(str.charAt(i)=='0'){
                if(str.substring(i, i+3).equals("010")){
                    steps++;
                    i=i+3;
                }
                else
                    i++;
            }

            else
                i++;
        }

        return steps;
    }
}
