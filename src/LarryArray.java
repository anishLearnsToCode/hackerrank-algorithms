import java.util.Scanner;
public class LarryArray {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        int t, n;

        System.out.print("Test Cases : ");
        t = s.nextInt();

        for(int i=0 ; i<t ; i++){
            n = s.nextInt();
            int arr[] = new int[n];
            int positionArr[] = new int[n];
            for(int j=0 ; j<n ; arr[j] = s.nextInt(), positionArr[arr[j]-1] = j, j++);
            String ans = larryArr(arr, positionArr);
            System.out.println(ans);
        }

        int temp_arr[] = new int[t];
        for(int i=0 ; i< temp_arr.length ; temp_arr[i] = s.nextInt(), i++);
        System.out.print("Lower Bound : ");
        int lowerBound = s.nextInt();
        System.out.print("Upper Bound : ");
        int upperBound = s.nextInt();

        //arrCycle(temp_arr, lowerBound, upperBound);
        output(temp_arr);
    }

    public static String larryArr(int arr[], int positionArr[]){
        int lowerBound, upperBound, i, j, k, cycle, sortedIndex;

        for(i=0, sortedIndex=-1 ; i<arr.length ; i++){
            cycle = (positionArr[i])/3 + 1;

            for(j=0 ; j<cycle ; j++){
                if(positionArr[i]==i){
                    break;
                }

                if(positionArr[i]-2 > i){
                    lowerBound = positionArr[i]-2;
                    upperBound = positionArr[i];
                }
                else{
                    lowerBound = i;
                    upperBound = lowerBound+2;
                }

                //System.out.println(lowerBound + " " + upperBound + " " + i + " " + positionArr[i]);
                if((lowerBound <= sortedIndex) || (upperBound >= arr.length)){
                    return "NO";
                }

                larryCycle(positionArr, arr, lowerBound, upperBound, positionArr[i]);
            }

            sortedIndex = i;
        }

        return "YES";
    }

    public static void larryCycle(int positionArr[], int arr[], int lowerBound, int upperBound, int position){
        int i, cycle;
        cycle = position - lowerBound;

        for(i=0 ; i<cycle ; i++){
            arrCycle(positionArr, arr, lowerBound, upperBound);
            output(positionArr);
        }
    }

    public static void arrCycle(int positionArr[], int arr[], int lowerBound, int upperBound){
        int temp = positionArr[arr[upperBound]];
        for(int i=upperBound ; i>upperBound - lowerBound  ; positionArr[arr[i]] = positionArr[arr[i-1]], i--);
        positionArr[arr[lowerBound]] = temp;
    }

    public static void output(int arr[]){
        System.out.println("");
        for(int i=0 ; i<arr.length ; System.out.print(arr[i]+" "), i++);
    }
}
