import java.util.Scanner;
public class Pangrams {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;

        str = s.nextLine();
        isPangram(str);
    }

    public static void isPangram(String str){
        str = str.toLowerCase();
        System.out.println(str);

        int i;
        int index[] = new int[26];
        boolean flag= true;

        for(i=0 ; i<26 ; index[i]=0, i++);
        for(i=0 ; i<str.length() ; i++){
            if(str.charAt(i)!=' '){
                index[str.charAt(i)-97]=1;
            }
        }

        output(index);

        for(i=0 ; i<index.length ; i++){
            if(index[i]==0){
                flag = false;
                break;
            }
        }

        if(flag)
            System.out.println("pangram");
        else
            System.out.println("not pangram");
    }

    public static void output(int arr[]){
        for(int i=0 ; i<arr.length ; System.out.print(arr[i] + " "), i++);
    }
}
