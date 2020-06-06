// https://www.hackerrank.com/challenges/acm-icpc-team/problem

package implimentation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AcmIcpcTeam {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        scanner.nextInt();
        String[] teams = getArray(length);
        printMaxPossibleTeamsWithHighestTopics(teams);
    }

    private static void printMaxPossibleTeamsWithHighestTopics(String[] array) {
        Map<Integer, Integer> frequency = getTopicsFrequency(array);
        int maxKnowledge = frequency.keySet().stream().max(Integer::compareTo).get();
        int maxTeams = frequency.get(maxKnowledge);
        System.out.println(maxKnowledge);
        System.out.println(maxTeams);
    }

    private static Map<Integer, Integer> getTopicsFrequency(String[] array) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0 ; i < array.length ; i++) {
            for (int j = i + 1 ; j < array.length ; j++) {
                int knowledge = knowledge(array[i], array[j]);
                frequencies.put(knowledge, frequencies.getOrDefault(knowledge, 0) + 1);
            }
        }
        return frequencies;
    }

    private static int knowledge(String first, String second) {
        int knowledge = 0;
        for (int index = 0 ; index < first.length() ; index++) {
            knowledge += Math.max(first.charAt(index), second.charAt(index)) - 48;
        }
        return knowledge;
    }

    private static String[] getArray(int length) {
        String[] array = new String[length];
        for (int index = 0 ; index < length ; index++) {
            array[index] = scanner.next();
        }
        return array;
    }
}
