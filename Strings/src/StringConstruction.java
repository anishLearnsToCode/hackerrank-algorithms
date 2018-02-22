import java.util.Scanner;
public class StringConstruction {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;
        int ans;

        str = s.next();
        ans = minCost(str);
        System.out.println(ans);
    }

    public static int minCost(String str){
        int indexArr1[] = indexing(str);
        int indexArr2[] = indexing("");
        int cost=0;

        for(int i=0 ; i<str.length() ; i++){
            if(!(indexArr1[str.charAt(i)-97] == indexArr2[str.charAt(i)-97])){
                cost ++;
                indexArr2[str.charAt(i)-97]=1;
            }
        }

        return cost;
    }

    public static int[] indexing(String str){
        int arr[] = new int[26];
        for(int i=0 ; i<26 ; arr[i]=0, i++);
        for(int i=0 ; i<str.length() ; arr[str.charAt(i)-97]=1, i++);
        return arr;
    }
}
