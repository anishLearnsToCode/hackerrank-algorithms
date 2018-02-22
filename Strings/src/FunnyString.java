import java.util.Scanner;
public class FunnyString {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        String str;

        str = s.next();
        isFunny(str);
    }

    public static void isFunny(String str){
        int i, j;
        boolean flag = true;

        for(i=0 ; i<str.length()/2 ; i++){
            if(Math.abs(str.charAt(i) - str.charAt(i+1)) != Math.abs(str.charAt(str.length()-1-i) - str.charAt(str.length()-1-i-1))){
                flag = false;
                break;
            }
        }

        if(flag)
            System.out.println("Funny");
        else
            System.out.println("Not Funny");
    }
}
