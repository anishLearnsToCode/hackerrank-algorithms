// https://www.hackerrank.com/challenges/designer-pdf-viewer/problem

package implimentation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DesignerPdfViewer {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Map<Character, Integer> alphabetHeights = getAlphabetHeights();
        String word = scanner.next();
        System.out.println(area(word, alphabetHeights));
    }

    private static int area(String word, Map<Character, Integer> alphabetHeights) {
        int maxHeight = getMaxHeight(word, alphabetHeights);
        return maxHeight * word.length();
    }

    private static int getMaxHeight(String word, Map<Character, Integer> heights) {
        int result = 0;
        for (int index = 0 ; index < word.length() ; index++) {
            char character = word.charAt(index);
            result = Math.max(result, heights.get(character));
        }
        return result;
    }

    private static Map<Character, Integer> getAlphabetHeights() {
        Map<Character, Integer> heights = new HashMap<>();
        for (char character = 'a' ; character <= 'z' ; character++) {
            heights.put(character, scanner.nextInt());
        }
        return heights;
    }
}
