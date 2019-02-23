// https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem?h_r=next-challenge&h_v=zen

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OrganizingContainersOfBalls {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int size = scanner.nextInt();
        int[][] container = new int[size][size];
        input(container);
//        print(container);
        String ans = isPossibleToOrganizeContainer(container, size);
        System.out.println(ans);
    }

    private static String isPossibleToOrganizeContainer(int[][] container, int size) {
        HashMap<Long, Integer> rowSums = getRowSums(container, size);
        HashMap<Long, Integer> columnSums = getColumnSums(container, size);

        print(rowSums);
        print(columnSums);

        for (Map.Entry<Long, Integer> entry : rowSums.entrySet()) {
            if(columnSums.get(entry.getKey()) == null) {
                return "Impossible";
            }

            if (!columnSums.get(entry.getKey()).equals(entry.getValue())) {
                return "Impossible";
            }
        }

        return "Possible";
    }

    private static void print(int[][] matrix) {
        for (int row=0 ; row < matrix.length ; row++) {
            for (int column=0 ; column < matrix[row].length ; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }

    private static void print (HashMap<Long, Integer> map) {
        System.out.print("{ ");
        for (Map.Entry<Long, Integer> entry : map.entrySet()) {
            System.out.print("(" + entry.getKey() + " , " + entry.getValue() + ")");
        }
        System.out.println(" } ");
    }

    private static HashMap<Long, Integer> getColumnSums (int[][] matrix, int size) {
        HashMap<Long, Integer> answer = new HashMap<>();
        for (int column=0 ; column < size ; column++) {
            long sum = sum(matrix, column);
            answer.put(sum, answer.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }

    private static HashMap<Long, Integer> getRowSums(int[][] container, int size) {
        HashMap<Long, Integer> answer = new HashMap<>();
        for (int row=0 ; row < size ; row++) {
            long sum = sum(container[row]);
            answer.put(sum, answer.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }

    private static long sum(int[][] matrix, int column) {
        int sum=0;
        for (int[] aMatrix : matrix) {
            sum += aMatrix[column];
        }
        return sum;
    }

    private static long sum (int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }

    private static void input(int[][] matrix) {
        for (int index=0 ; index < matrix.length ; index++) {
            for (int j=0 ; j < matrix[index].length ; j++) {
                matrix[index][j] = scanner.nextInt();
            }
        }
    }
}