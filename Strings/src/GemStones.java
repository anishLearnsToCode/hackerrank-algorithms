import java.util.Scanner;
public class GemStones {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        int n, i, ans;

        System.out.print("Rocks : ");
        n = s.nextInt();

        String str[] = new String[n];

        for(i=0 ; i<n ; i++)
            str[i] = s.next();

        ans = gemstone(str);
        System.out.println(ans);
    }

    public static int gemstone(String str[]){
        boolean indexArr[] = new boolean[26];
        int i, c;

        indexArr = indexing(str[0]);
        for(i=1 ; i<str.length ; indexArr = indexing(indexArr, str[i]), i++);
        for(i=0, c=0 ; i<indexArr.length ; i++){
            if(indexArr[i])
                c++;
        }

        return c;
    }

    public static boolean[] indexing(boolean indexArr[], String str){
        boolean arr[] = new boolean[26];
        int i;
        for(i=0 ; i<str.length() ; i++){
            arr[str.charAt(i)-97] = true && indexArr[str.charAt(i)-97];
        }
        return arr;
    }

    public static boolean[] indexing(String str){
        boolean arr[] = new boolean[26];
        int i;

        for(i=0 ; i<arr.length ; arr[i] = false, i++);
        for(i=0 ; i<str.length() ; arr[str.charAt(i)-97]=true, i++);

        return arr;
    }

    public static void output(boolean arr[]){
        for(int i=0 ; i<arr.length ; System.out.print(arr[i]+" "), i++);
    }

    public static void output(int arr[]){
        for(int i=0 ; i<arr.length ; System.out.print(arr[i]+" "), i++);
    }
}
