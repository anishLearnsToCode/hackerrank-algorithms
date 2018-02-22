import java.util.Scanner;
public class AlmostSorted {
    public static void main(String[] args) {
        Scanner  s= new Scanner(System.in);
        int n, temp, i, j;

        System.out.print("Size : ");
        n = s.nextInt();

        int arr[] = new int[n];
        int sortedArr[] = new int[n];
        int positionArr[] = new int[0];

        for(i=0, temp=0 ; i<arr.length ; i++){
            arr[i] = s.nextInt();

            if(i>=1) {
                if ((arr[i] < arr[temp]) || (arr[i] < arr[i-1])) {

                    if(arr[temp] < arr[i-1])
                        temp = i-1;

                    int tempArr[] = new int[positionArr.length + 1];
                    for (j = 0; j < positionArr.length; tempArr[j] = positionArr[j], j++) ;
                    tempArr[tempArr.length - 1] = i;
                    positionArr = tempArr;
                }
            }
        }

        output(arr);
        //output(positionArr);
        //System.out.println("");

        //almostSortedArr(arr, positionArr, temp);

        sortedArr = mergeSort(arr);
        output(sortedArr);

        almostSort(arr, sortedArr);
    }

    public static void almostSortedArr(int arr[], int positionArr[], int temp){
        int i;
        boolean flag;

        if(positionArr.length==0){
            System.out.println("no");
        }
        else{
            if(positionArr.length==1){
                System.out.println("yes");
                System.out.println("swap" + " " + (temp+1) + " " + (positionArr[0]+1));
            }
            else{
                for(i=0, flag = true ; i<positionArr.length-1 ; i++){
                    if(positionArr[i+1]-positionArr[i] > 1){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    for(i=0 ; i<positionArr.length-1 ; i++){
                        if(arr[positionArr[i]]<arr[positionArr[i+1]]){
                            flag = false;
                            break;
                        }
                    }
                }

                if(flag) {
                    System.out.println("yes");
                    System.out.println("reverse " + (temp + 1) + " " + (positionArr[positionArr.length - 1] + 1));
                }
                    else
                    System.out.println("no");
            }
        }
    }

    public static void almostSort(int arr[], int sortedArr[]){
        int i, j;
        boolean flag = true;
        int positionArr[] = new int[0];

        for(i=0 ; i<arr.length ; i++){
            if(arr[i]!=sortedArr[i]){
                int tempArr[] = new int[positionArr.length+1];
                for(j=0 ; j<positionArr.length ; tempArr[j] = positionArr[j], j++);
                tempArr[tempArr.length-1] = i;
                positionArr = tempArr;
            }
        }

        output(positionArr);

        if(positionArr.length==0){
            System.out.println("no");
        }
        else if(positionArr.length==2){
            System.out.println("yes");
            System.out.println("swap" + " " + (positionArr[0]+1) + " " + (positionArr[1]+1));
        }
        else if(positionArr.length >2){
            /*
            //to check that positionArr is consecutive
            for(i=0, flag = true ; i<positionArr.length-1 ; i++){
                if(positionArr[i+1] - positionArr[i] >1){
                    flag = false;
                    break;
                }
            }*/

            //to check for breaks
            for(i=0 ; i<positionArr.length-1 ; i++){
                if(positionArr[i+1] - positionArr[i] > 1){
                    if((arr[positionArr[i]+1] > arr[positionArr[i]]) || (arr[positionArr[i+1]-1] < arr[positionArr[i+1]])){
                        flag = false;
                        break;
                    }
                }
            }

            if(flag){
                //to check descending order of positionArr
                for(i=0 ; i<positionArr.length-1 ; i++){
                    if(arr[positionArr[i+1]] > arr[positionArr[i]]){
                        flag = false;
                        break;
                    }
                }
            }

            if(flag){
                System.out.println("yes");
                System.out.println("reverse " + (positionArr[0]+1) + " " + (positionArr[positionArr.length-1]+1) );
            }
            else{
                System.out.println("no");
            }
        }
        else{
            System.out.println("no");
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
        int ans[] = new int[arr1.length + arr2.length];
        int i, j, k, t;

        for(i=0, j=0, k=0 ; i<=arr1.length && j<=arr2.length ; ){
            if(i==arr1.length){
                for(t=0 ; t<arr2.length-j ; ans[k++] = arr2[j+t], t++);
                break;
            }
            else if(j==arr2.length){
                for(t=0 ; t<arr1.length-i ; ans[k++] = arr1[i+t], t++);
                break;
            }

            if(arr1[i] < arr2[j]){
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
        System.out.println("");
        for(int i=0 ; i<arr.length ; System.out.print(arr[i]+" "), i++);
    }
}
