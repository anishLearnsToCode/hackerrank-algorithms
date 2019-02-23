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
                        int replacementIndex =  
                    }
                }

                char[] sortedString = string
            }
        }


        return "no answer";
    }

    private static char[] getMinPositionsOf(String string) {
        char[] array = new char[string.length()];
        array[0] = string.charAt(0);
        for (int index=1 ; index < string.length()-1 ; index++) {
            array[index] = (char)Math.min(array[index-1], string.charAt(index));
        }
        return array;
    }

    private static HashMap<Character, Integer> createPositionMap(String string) {
        HashMap<Character, Integer> positionMap = new HashMap<>();
        for (int index=0 ; index < string.length() ; index++) {
            positionMap.put(string.charAt(index), index);
        }
        return positionMap;
    }
}
