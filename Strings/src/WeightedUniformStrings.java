import java.util.Scanner;
public class WeightedUniformStrings {

    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        String str;
        int t, i;
        int indexArr[];
        double x;

        str = s.next();
        indexArr = indexing(str);
        output(indexArr);
        System.out.print("Test case : ");
        t = s.nextInt();

        for(i=0 ; i<t ; i++){
            System.out.print("x : ");
            x = s.nextDouble();
            uniformString(str, x, indexArr);
        }
    }

    public static void uniformString(String str, double x, int indexArr[]){
        double i;
        boolean flag=false;

        for(i=1 ; i<=Math.min(x, 26) ; i++){
            if(x/i == Math.floor(x/i)){
                //System.out.println(i);
                if(indexArr[(int)i-1] >= x/i){
                    System.out.println("YES");
                    flag = true;
                    break;
                }
            }
        }

        if(!flag){
            System.out.println("NO");
        }
    }

    public static int[] indexing(String str){
        int arr[] = new int[26];
        int i, j, value;

        for(i=0 ; i<arr.length ; arr[i]=0, i++);

        if(str.length()==1){
            arr[str.charAt(0)-97]++;
            return arr;
        }

        for(i=1, j=0 ; i<str.length() ; ){
            if(i==str.length()-1){
                if(str.charAt(i)==str.charAt(j)){
                    value = i-j+1;
                    arr[str.charAt(j)-97] = Math.max(value, arr[str.charAt(j)-97]);
                }else{
                    value = i-j;
                    arr[str.charAt(j)-97] = Math.max(value, arr[str.charAt(j)-97]);
                    value = 1;
                    arr[str.charAt(i)-97] = Math.max(value, arr[str.charAt(i)-97]);
                }

                break;
            }

            if(str.charAt(i)==str.charAt(j)){
                i++;
            }
            else{
                value = i-j;
                arr[str.charAt(j)-97] = Math.max(value, arr[str.charAt(j)-97]);
                j=i;
                i++;
            }
        }

        return arr;
    }

    public static void output(int arr[]){
        for(int i=0 ; i<arr.length ; System.out.print(arr[i]+" "), i++);
    }
}