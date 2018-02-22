import java.util.Scanner;
public class StringArrMergeSort {
    public static void main(String[] args) {
        Scanner  s = new Scanner(System.in);
        int n, ans;
        String element;

        System.out.print("Size : ");
        n = s.nextInt();

        String str[] = new String[n];
        for(int i=0 ; i<n ; i++){
            str[i] = s.next();
        }

        System.out.print("Enter Integer Array : ");
        int arr[] = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = s.nextInt();
        }

        encrypt(str, arr);
        //output(str);

        str = mergeSort(str);
        arr = decrypt(str);
        //str = removeEncryption(str);
        output(str);
        output(arr);

        System.out.println("");
        System.out.print("Enter element for searching : ");
        element = s.next();

        ans = binarySearch(str, element);
        System.out.println(ans);
    }

    public static void output(String str[]){
        System.out.println("");
        for(int i=0 ; i<str.length ; i++){
            System.out.println(str[i]);
        }
    }

    public static void output(int arr[]){
        System.out.println("");
        for(int i=0 ; i<arr.length ; System.out.print(arr[i]+ " "), i++);
    }

    public static void encrypt(String str[], int arr[]){
        for(int i=0 ; i<str.length ; i++){
            str[i] = str[i] + stringConvert(arr[i]);
        }
    }

    public static String stringConvert(int n){
        if(n<10){
            String ans = n +"";
            return ans;
        }

        String ans;
        ans = stringConvert(n/10) + n%10;
        return ans;
    }

    public static int[] decrypt(String str[]){
        int i, j;
        int arr[] = new int[str.length];

        for(i=0 ; i<str.length ; i++){
            for(j=0 ; j<str[i].length() ; j++){
                if(isNum(str[i].charAt(j))){
                    arr[i] = Num(str[i].substring(j));
                    str[i] = str[i].substring(0, j);
                    break;
                }
            }
        }

        return arr;
    }

    public static boolean isNum(char ch){
        return ((ch >= 48) && (ch <= 57));
    }

    public static int Num(String str){
        int ans, i;
        for(i=0, ans=0 ; i<str.length() ; i++){
            ans += (str.charAt(i)-48)*(Math.pow(10, str.length()-i-1));
        }
        return ans;
    }

    public static int binarySearch(String str[], String element){
        int i, head, tail, mid;

        for(tail=0, head=str.length ; !(tail >= head-1) ; ){
            mid = (tail + head)/2;

            if(str[mid].compareTo(element)==0){
                return mid;
            }
            else if(str[mid].compareTo(element) < 0){
                tail = mid;
            }
            else {
                head = mid;
            }
        }

        if(str.length<=3){
            for(i=0 ; i<str.length ; i++){
               if(str[i].compareTo(element)==0){
                   return i;
               }
            }
        }

        return -1;
    }

    public static String[] mergeSort(String str[]){
        if(str.length==1){
            return str;
        }

        int i;
        String smallStr1[] = new String[str.length/2];
        String smallStr2[] = new String[str.length - smallStr1.length];

        for(i=0 ; i<smallStr1.length ; smallStr1[i] = str[i], i++);
        for( ; i<str.length ; smallStr2[i - smallStr1.length] = str[i], i++);

        String smallAns1[] = mergeSort(smallStr1);
        String smallAns2[] = mergeSort(smallStr2);

        return merge(smallAns1, smallAns2);
    }

    public static String[] merge(String str1[], String str2[]){
        int i, j, k, t;
        String ans[] = new String[str1.length + str2.length];

        for(i=0, j=0, k=0 ; i<=str1.length && j<=str2.length ; ){
            if(i==str1.length){
                for(t=0 ; t<str2.length -j ; ans[k++] = str2[j+t], t++);
                break;
            }
            else if(j==str2.length){
                for(t=0 ; t<str1.length - i ; ans[k++] = str1[i+t], t++);
                break;
            }

            if(str1[i].compareTo(str2[j]) < str2[j].compareTo(str1[i])){
                ans[k++] = str1[i];
                i++;
            }
            else{
                ans[k++] = str2[j];
                j++;
            }
        }

        return ans;
    }
}
