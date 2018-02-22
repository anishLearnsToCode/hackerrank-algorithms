import java.util.Scanner;

public class BigSorting {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size =s.nextInt();
        String str[] = new String[size];

        for(int i=0 ; i<size ; i++){
            str[i] = s.next();
        }

        str = mergeSort(str);
        print(str);
    }

    private static void print(String str[]) {
        for(int i=0 ; i<str.length ; i++){
            System.out.println(str[i]);
        }
    }

    private static String[] mergeSort(String str[]){
        if(str.length == 1 || str.length == 0){
            return str;
        }

        String smallArr1[] = new String[str.length/2];
        String smallArr2[] = new String[str.length - smallArr1.length];

        int i;
        for(i=0 ; i<smallArr1.length ; smallArr1[i] = str[i], i++);
        for( ; i<str.length ; smallArr2[i-smallArr1.length] = str[i], i++);

        String smallAns1[] = mergeSort(smallArr1);
        String smallAns2[] = mergeSort(smallArr2);

        return merge(smallAns1, smallAns2);
    }

    private static String[] merge(String str1[], String str2[]){
        String ans[] = new String[str1.length + str2.length];
        int i, j, k, t;

        for(i=0, j=0, k=0 ; i<=str1.length && j<=str2.length ; ){
            if(i == str1.length){
                for(t=0 ; t<str2.length - j ; ans[k++] = str2[j+t], t++);
                break;
            } else if(j == str2.length) {
                for(t=0 ; t<str1.length - i ; ans[k++] = str1[i+t], t++);
                break;
            }

            if(strcmp(str1[i], str2[j])){
                ans[k++] = str1[i];
                i++;
            } else {
                ans[k++] = str2[j];
                j++;
            }
        }

        return ans;
    }

    private static boolean strcmp(String str1, String str2) {
        if(str1.length() < str2.length())
            return true;
        if(str2.length() < str1.length())
            return false;

        for(int i=0 ; i<str1.length() ; i++){
            if(str1.charAt(i) < str2.charAt(i))
                return true;
            else if(str1.charAt(i) > str2.charAt(i))
                return false;
        }

        return false;
    }
}
