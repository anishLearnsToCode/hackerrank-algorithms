import java.util.Arrays;
import java.util.Scanner;

class myTuple implements Comparable<myTuple> {
        int originalIndex;   // stores original index of suffix
        int firstHalf;       // store rank for first half of suffix
        int secondHalf;      // store rank for second half of suffix

    @Override
    public int compareTo(myTuple o) {
        if(this.firstHalf == o.firstHalf) {
            return Integer.compare(this.secondHalf, o.secondHalf);
        }
        else return Integer.compare(this.firstHalf , o.firstHalf);
    }

    @Override
    public String toString() {
        return "( " + firstHalf + " , " + secondHalf + " -- " + originalIndex + " )";
    }
};

public class SuffixArray {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

// suffixRank is table hold the rank of each string on each iteration
// suffixRank[i][j] denotes rank of jth suffix at ith iteration

// function to compare two suffix in O(1)
// first it checks whether first half chars of 'a' are equal to first half chars of b
// if they compare second half
// else compare decide on rank of first half

                // Take input string
                // initialize size of string as N

                String s = scanner.nextLine();
                int N = s.length();
        int[][] suffixRank = new int[20][N];

                // Initialize suffix ranking on the basis of only single character
                // for single character ranks will be 'a' = 0, 'b' = 1, 'c' = 2 ... 'z' = 25

                for(int i = 0; i < N; ++i)
                    suffixRank[0][i] = s.charAt(i) - 'a';
                print("Suffix Array", suffixRank);

                // Create a tuple array for each suffix

                myTuple[] L = new myTuple[N];
                for (int index=0 ; index < L.length ; index++) {
                    L[index] = new myTuple();
                }

                // Iterate log(n) times i.e. till when all the suffixes are sorted
                // 'stp' keeps the track of number of iteration
                // 'cnt' store length of suffix which is going to be compared

                // On each iteration we initialize tuple for each suffix array
                // with values computed from previous iteration

                for(int cnt = 1, stp = 1; cnt < N; cnt *= 2, ++stp) {

                    for(int i = 0; i < N; ++i) {
                        L[i].firstHalf = suffixRank[stp - 1][i];
                        L[i].secondHalf = i + cnt < N ? suffixRank[stp - 1][i + cnt] : -1;
                        L[i].originalIndex = i;
                    }
                    print("Tuples", L);

                    // On the basis of tuples obtained sort the tuple array
                    Arrays.sort(L);
                    print("After Sorting", L);


                    // Initialize rank for rank 0 suffix after sorting to its original index
                    // in suffixRank array

                    suffixRank[stp][L[0].originalIndex] = 0;

                    for(int i = 1, currRank = 0; i < N; ++i) {

                        // compare ith ranked suffix ( after sorting ) to (i - 1)th ranked suffix
                        // if they are equal till now assign same rank to ith as that of (i - 1)th
                        // else rank for ith will be currRank ( i.e. rank of (i - 1)th ) plus 1, i.e ( currRank + 1 )

                        if(L[i - 1].firstHalf != L[i].firstHalf || L[i - 1].secondHalf != L[i].secondHalf)
                            ++currRank;

                        suffixRank[stp][L[i].originalIndex] = currRank;
                    }
                    print("Suffix array after recreating", suffixRank);

                }

                // Print suffix array

                for(int i = 0; i < N; ++i) {
                    System.out.println(L[i].originalIndex);
                }
    }

    private static void print(String message, int[][] array) {
        System.out.println(message);
        System.out.print("{ ");
        for (int[] row: array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println(" } ");
    }

    private static void print(String message, myTuple[] array) {
        System.out.println(message);
        System.out.print(" { ");
        for(myTuple element : array) {
            System.out.println(element);
        }
        System.out.println( " } ");
    }
}
