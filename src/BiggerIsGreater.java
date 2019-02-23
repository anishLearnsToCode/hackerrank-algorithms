import java.util.*;

public class BiggerIsGreater {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String string =  scanner.nextLine();
        System.out.println(nextUpperString(string));
    }

    private static String nextUpperString(String string) {
        if (string.length() == 1) {
            return "no answer";
        }

        char[] maxPositionArray = getMaxPosition(string);
        char[] minPositionArray = getMinPosition(string);
        HashMap<Character, Integer> positionMap = getPositions(string);

        for (int index=string.length()-2 ; index >= 0 ; index-- ) {
            if (string.charAt(index) < maxPositionArray[index]) {
                // next smaller lexicographical string exists

                for(char character = maxPositionArray[index] ; character <= 'z' ; character++){
                    if(positionMap.containsKey(character)) {

                    }
                }

                char[] sortedString = string.toCharArray();
            }
        }


        return "no answer";
    }

    private static char[] getMaxPosition(String string) {
        return new char[10];
    }

    private static char[] getMinPosition(String string) {
        return new char[10];
    }

    private static HashMap<Character, Integer> getPositions(String string) {
        return new HashMap<>();
    }
}
