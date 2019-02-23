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



        char[] minPositions = getMinPositionsOf(string);
        System.out.print("Min Positions[]");
        System.out.println(minPositions);
//        HashMap<Character, Integer> positionMap = createPositionMap(string);
//        System.out.println(positionMap);

        for (int index = string.length()-1 ; index > 0 ; index--) {
            if (string.charAt(index) > minPositions[index-1]) {
                // lexicographically shorter string can be created

//                for (char character = (char)(string.charAt(index)-1) ; character >= 'a' ; character--) {
//                    if (positionMap.containsKey(character)) {
//                        int replaceCharacterIndex = positionMap.get(character);
//                        char[] sortedString = string
//                                        .substring(replaceCharacterIndex, index)
//                                        .concat(string.substring(index+1))
//                                        .toCharArray();
//                        System.out.print("Sorted String: ");
//                        Arrays.sort(sortedString);
//                        System.out.println(sortedString);
//                        return string
//                                .substring(0, replaceCharacterIndex)
//                                .concat(string.charAt(index) + "")
//                                .concat(new String(sortedString));
//                    }
//                }

                int currentCharacter = string.charAt(index);

                for (int replaceIndex = index-1 ;  replaceIndex >= 0 ; replaceIndex--) {
                    if (currentCharacter > string.charAt(replaceIndex)) {
                        char[] sortedString = string
                                .substring(replaceIndex, index)
                                .concat(string.substring(index+1))
                                .toCharArray();
                        System.out.print("Sorted String: ");
                        Arrays.sort(sortedString);
                        System.out.println(sortedString);
                        return string
                                .substring(0, replaceIndex)
                                .concat(string.charAt(index) + "")
                                .concat(new String(sortedString));
                    }
                }
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
