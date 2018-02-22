import java.util.Scanner;

public class DesignerPDFViewer {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ans;

        int arr[] = new int[26];
        //arr_input(arr);
        initialize(arr);

        String word = s.next();

        ans = area(word, arr);
        System.out.println(ans);
    }

    public static void arr_input(int arr[]){
        Scanner s = new Scanner(System.in);

        for(int i=0 ; i<arr.length ; i++){
            arr[i]=s.nextInt();
        }
    }

    public static void initialize(int arr[]){
        int i;
        for(i=0 ; i<5 ; arr[i]=0, i++);
        for( ; i<10 ; arr[i]=1, i++ );
        for( ; i<20 ; arr[i]=2, i++);
        for( ; i<arr.length ; arr[i]=2, i++);
    }

    public static int area(String word, int arr[]){
        int i, k;

        for(i=0, k=0 ; i<word.length() ; i++){
            if(arr[word.charAt(i)-97]>k){
                k=arr[word.charAt(i)-97];
            }
        }

        return word.length()*k;
    }
}
