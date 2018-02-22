import java.util.Scanner;
public class SherlockAndValidString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str, ans;

        str = s.next();
        ans = validString(str);
        System.out.println(ans);
    }

    public static String validString(String str){
        int indexArr[] = indexing(str);
        int arr[] = mergeSort(indexArr);
        int i, c, j, frequency=1;
        boolean flag;

        output(arr);

        for(i=1, j=0 ; i<arr.length ; i++){
            if(arr[i]==0){
                j=i;
                continue;
            }

            if(arr[i]!=arr[j]){
                frequency = Math.max(frequency, arr[j]);
                j=i;
            }else if(i==arr.length-1){
                frequency = Math.max(frequency, arr[j]);
                break;
            }
        }

        System.out.println(frequency);

        for(i=0, c=0 ; i<indexArr.length ; i++){
            if(indexArr[i]>0){
                if(indexArr[i] >= frequency)
                    c += indexArr[i] - frequency;
                else
                    c += indexArr[i];
            }
        }

        if(c > 1)
            return "NO";

        return "YES";
    }

    public static int[] indexing(String str){
        int arr[] = new int[26];
        for(int i=0 ; i<26 ; arr[i]=0, i++);
        for(int i=0 ; i<str.length() ; arr[str.charAt(i)-97]++, i++);
        return arr;
    }

    public static int[] mergeSort(int arr[]){
        if(arr.length==1){
            return arr;
        }

        int smallArr1[] = new int[arr.length/2];
        int smallArr2[] = new int[arr.length - smallArr1.length];

        int i;
        for(i=0 ; i<smallArr1.length ; smallArr1[i] = arr[i], i++);
        for( ; i<arr.length ; smallArr2[i - smallArr1.length] = arr[i], i++);

        int smallAns1[] = mergeSort(smallArr1);
        int smallAns2[] = mergeSort(smallArr2);

        return merge(smallAns1, smallAns2);
    }

    public static int[] merge(int arr1[], int arr2[]){
        int i, j, k, t;
        int ans[] = new int[arr1.length + arr2.length];

        for(i=0, j=0, k=0 ; i<=arr1.length && j <= arr2.length ; ){
            if(i==arr1.length){
                for(t=0 ; t<arr2.length - j ; ans[k++] = arr2[j+t], t++);
                break;
            }
            else if(j==arr2.length){
                for(t=0 ; t<arr1.length - i ; ans[k++] = arr1[i+t], t++);
                break;
            }

            if(arr1[i] <= arr2[j]){
                ans[k++] = arr1[i];
                i++;
            }
            else{
                ans[k++] = arr2[j];
                j++;
            }
        }

        return ans;
    }

    public static void output(int arr[]){
        for(int i=0 ; i<arr.length ; System.out.print(arr[i]+" "), i++);
        System.out.println("");
    }
}
