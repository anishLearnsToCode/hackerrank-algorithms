import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        char[] test = "gtfeaaamjy".toCharArray();
        Arrays.sort(test);
        System.out.println(test);


    }

    private static String compressedString(String str){
        int indexArr[] = indexing(str);
        String ans = "";

        for(int i=0 ; i<indexArr.length ; i++){
            if(indexArr[i] > 0){
                ans += (char)(i+97) + numToStr(indexArr[i]);
            }
        }
        return ans;
    }

    private static String numToStr(int n) {
        char ch = (char) (n+48);
        System.out.println(ch);
        return ch+"";
    }

    private static int[] indexing(String str) {
        int arr[] = new int[26];
        for(int i=0 ; i<arr.length ; arr[i] = 0, i++);
        for(int i=0 ; i<str.length() ; arr[str.charAt(i)-97]++, i++);
        return arr;
    }
}
