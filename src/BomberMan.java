import java.util.Scanner;
public class BomberMan {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, row, col, t;
        char ch;

        System.out.print("Row Col : ");
        row = s.nextInt();
        col = s.nextInt();
        String str[] = new String[row];
        input(str, row, col);
        output(str);
        System.out.print("Enter time : ");
        t = s.nextInt();

        bomber(str, row, t);
        //output(invert(str));

        /*
        int arr[] = new int[n];
        for(int i=0 ; i<n ; arr[i]=s.nextInt(), i++);

        arr = mergeSort(arr);
        for(int i=0 ; i<n ; System.out.print(arr[i]+" "), i++);
        */
    }

    public static void input(String str[], int row, int col){
        Scanner s = new Scanner(System.in);
        int i;

        for(i=0 ; i<row ; i++){
            str[i] = s.next();
        }
    }

    public static void output(String[] str){
        for(int i=0 ; i<str.length ; i++){
            System.out.println(str[i]);
        }
    }

    public static boolean isBomb(String str[], int i, int j){
        //Up
        if((i>0) && (str[i-1].charAt(j)=='O'))
            return true;
        //Right
        else if((j<str[0].length()-1) && (str[i].charAt(j+1)=='O'))
            return true;
        //Down
        else if((i<str.length-1) && (str[i+1].charAt(j)=='O'))
            return true;
        //Left
        if((j>0) && (str[i].charAt(j-1)=='O'))
            return true;

        return false;
    }

    public static String[] invert(String str[]){
        String ans[] = new String[str.length];
        int i, j;
        for(i=0 ; i<ans.length ; ans[i]="", i++);

        for(i=0 ; i<str.length ; i++){
            for(j=0 ; j<str[0].length() ; j++){
                if(str[i].charAt(j)=='O'){
                    ans[i] += '.';
                }
                else if(isBomb(str, i, j)){
                    ans[i] += '.';
                }else{
                    ans[i] += 'O';
                }
            }
        }

        return ans;
    }

    public static void bomber(String str[], int row, int time){
        String explosion1[]={""}, explosion2[]={""};
        String full[] = new String[str.length];
        int i, j;

        for(i=0 ; i<str.length ; full[i]="", i++);
        for(i=0 ; i<row ; i++){
            for(j=0 ; j<str[0].length() ; j++){
                full[i] += 'O';
            }
        }
        explosion1 = invert(str);
        explosion2 = invert(explosion1);

        if(time == 1){
            output(str);
        }
        else if((time)%2==0){
            output(full);
        }
        else if((time/2)%2==1){
            output(explosion1);
        }
        else{
            output(explosion2);
        }
    }

    public static int[] mergeSort(int arr[]){
        if(arr.length==1){
            return arr;
        }

        int i;
        int smallArr1[] = new int[arr.length/2];
        int smallArr2[] = new int[arr.length - smallArr1.length];

        for(i=0 ; i<smallArr1.length ; smallArr1[i] = arr[i], i++);
        for( ; i<arr.length ; smallArr2[i - smallArr1.length] = arr[i], i++);

        int smallAns1[] = mergeSort(smallArr1);
        int smallAns2[] = mergeSort(smallArr2);

        return merge(smallAns1, smallAns2);
    }

    public static int[] merge(int arr1[], int arr2[]){
        int i, j, k, t;
        int ans[] = new int[arr1.length + arr2.length];

        for(i=0, j=0, k=0 ; i<=arr1.length && j<= arr2.length ; ){
            if(i==arr1.length){
                for(t=0 ; t<arr2.length-j ; ans[k++] = arr2[j+t], t++);
                break;
            }
            else if(j==arr2.length){
                for(t=0 ; t<arr1.length-i ; ans[k++] = arr1[t+i], t++);
                break;
            }

            if(arr1[i]<=arr2[j]){
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


}
