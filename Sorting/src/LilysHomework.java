import java.beans.IntrospectionException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LilysHomework {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size;

        System.out.print("Enter size : ");
        size = s.nextInt();
        Element arr[] = new Element[size];
        for(int i=0 ; i<size ; i++){
            int data = s.nextInt();
            arr[i] = new Element(data, i);
        }

        arr = mergeSort(arr);
//        print(arr);
        HashMap<Integer, Integer> indexMap = hashing(arr);
//        print(indexMap);

        int ans = minInversions(0, arr, indexMap);
        System.out.println(ans);
    }

    private static int minInversions(int index, Element arr[], HashMap<Integer, Integer> indexMap) {
        if(index == arr.length)
            return 0;

        if(arr[index].previousIndex != index){
            int otherIndex = indexMap.get(index);
            arr[otherIndex].previousIndex = arr[index].previousIndex;
            indexMap.put(index , index);
            indexMap.put(arr[otherIndex].previousIndex, otherIndex);
            arr[index].previousIndex = index;
            return 1 + minInversions(index +1, arr, indexMap);
        }

        return minInversions(index +1, arr, indexMap);
    }

    private static HashMap<Integer, Integer> hashing(Element arr[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<arr.length ; i++) {
            map.put(arr[i].previousIndex, i);
        }
        return map;
    }

    private static Element[] mergeSort(Element arr[]) {
        if(arr.length == 1 || arr.length == 0){
            return arr;
        }

        Element smallArr1[] = new Element[arr.length/2];
        Element smallArr2[] = new Element[arr.length - smallArr1.length];
        int i;

        for(i=0 ; i<smallArr1.length ; smallArr1[i] = arr[i], i++);
        for( ; i<arr.length ; smallArr2[i - smallArr1.length] = arr[i], i++);

        Element ans1[] = mergeSort(smallArr1);
        Element ans2[] = mergeSort(smallArr2);

        return merge(ans1, ans2);
    }

    private static Element[] merge(Element arr1[], Element arr2[]){
        int i, j, k, t;
        Element ans[] = new Element[arr1.length + arr2.length];

        for(i=0, j=0, k=0 ; i<=arr1.length && j<=arr2.length ; ){
            if(i == arr1.length){
                for(t=0 ; t<arr2.length - j ; ans[k++] = arr2[j+t], t++);
                break;
            } else if(j == arr2.length) {
                for(t=0 ; t<arr1.length - i ; ans[k++] = arr1[i+t], t++);
                break;
            }

            if(arr1[i].data <= arr2[j].data){
                ans[k++] = arr1[i];
                i++;
            } else {
                ans[k++] = arr2[j];
                j++;
            }
        }

        return ans;
    }

    private static void print(Element arr[]){
        for(int i=0 ; i<arr.length ; i++) {
            System.out.println(arr[i].data + " " + arr[i].previousIndex);
        }
    }

    private static void print(HashMap<Integer, Integer> map) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

class Element{
    int data;
    int previousIndex;
    Element(int data, int previousIndex){
        this.data = data;
        this.previousIndex = previousIndex;
    }
}
