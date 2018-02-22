import java.util.Scanner;

public class Encryption {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        String str, ans;

        str = s.next();

        ans = encrypted(str);
        System.out.println(ans);
    }

    public static String encrypted(String str){
        int i;
        double row, col;
        col = row = (int)Math.sqrt(str.length());
        //System.out.println(row);
        //System.out.println(col);
        //System.out.println(Math.ceil(Math.sqrt(str.length())));

        for( ; ; col++){
            if((row * col) >= str.length()){
                //System.out.println("true ");
                if(col <= Math.ceil(Math.sqrt(str.length()))){
                    //System.out.println(Math.ceil(Math.sqrt(str.length())));
                    break;
                }
                else{
                    row++;
                    col=row-1;
                }
            }
        }

        System.out.println(row);
        System.out.println(col);

        String arr[] = new String[(int)col];
        for(i=0 ; i<arr.length ; arr[i]="", i++);
        String ans="";

        for(i=0 ; i<str.length() ; i++){
            arr[(int)((col+i)%col)] += str.charAt(i) + "";
        }

        for(i=0 ; i<arr.length ; i++){
            ans += arr[i]+" ";
        }

        return ans;
    }
}
