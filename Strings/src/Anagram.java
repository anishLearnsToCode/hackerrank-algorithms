import java.util.Scanner;
public class Anagram {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;
        int ans;

        str = s.next();
        ans = minChages(str);
        System.out.println(ans);
    }

    public static int minChages(String str){
        if(str.length()%2==1)
            return -1;

        int i, c;
        int indexArr1[] = indexing(str.substring(0, str.length()/2));
        int indexArr2[] = indexing(str.substring(str.length()/2));

        for(i=0, c=0 ; i<indexArr1.length ; c += Math.abs(indexArr1[i] - indexArr2[i]), i++);
        return c/2;
    }

    public static int[] indexing(String str){
        int arr[] = new int[26];
        for(int i=0 ; i<26 ; arr[i]=0, i++);
        for(int i=0 ; i<str.length() ; arr[str.charAt(i)-97]++, i++);
        return arr;
    }
}
