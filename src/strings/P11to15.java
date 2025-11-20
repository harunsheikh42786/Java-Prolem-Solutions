package strings;

import java.util.*;

public class P11to15 {

    // Remove all spaces from string
    public static String removeAllSpacesFromString(String str){
        return str.replace(" ","");
    }
    // Remove duplicate characters from a string
    public static String removeDuplicateCharacter(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            boolean isContains = sb.toString().indexOf(str.charAt(i)) >= 0;
            if (!isContains){
                sb.append(str.charAt(i));
            }
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }
    // Find frequency of each character in a string
    //(use Map<Character,Integer>)
    public static Map<Character, Integer> countChar(String str){
        final HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<str.length(); i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0)+1);
        }
        return map;
    }
    //    Convert string to integer without using Integer.parseInt()
    public static int parseInt(String str) {
        if (!str.matches("^[\\d]+$")) {
            throw new RuntimeException("String should not contain non-digit characters.");
        }
        int integer = 0;
        final char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            integer = integer * 10 + (charArray[i] - '0');
        }
        return integer;
    }
    // Find the none-repeating char
    public static char firstNoneRepeatingChar(String str){
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i),0)+1);
        }
        return map.entrySet().stream().filter(entry-> entry.getValue()==1).findFirst().map(Map.Entry::getKey).orElse(' ');
    }


    public static void main(String[] args) {
        // Remove all spaces from string
        String s1 = "Harun is a java backend developer, Looking for a chance to join IT company.";
        final String stringWithoutSpaces = removeAllSpacesFromString(s1);
        System.out.println("Real String : " +s1);
        System.out.println("Result String : " +stringWithoutSpaces);

        // Remove duplicate characters from a string
        String s2 = "Harun Sheikh is a nice guy";
        final String removeDuplicateCharacter = removeDuplicateCharacter(s2);
        System.out.println("RemoveDuplicateCharacter : "+removeDuplicateCharacter);

        // Find frequency of each character in a string
        //(use Map<Character,Integer>)
        final Map<Character, Integer> characterCount = countChar("Harun Sheikh is looking for a match");
        System.out.println("Count Character : "+characterCount);

        // Convert string to integer without using Integer.parseInt()
//        parseInt("Harun is backend developer."); // it will throw an exception
        final int integer = parseInt("1231465479");
        System.out.println("Integer : " + integer);

        //Find the first non-repeating character
        //(e.g., "swiss" → 'w')
        final char firstNoneRepeatingChar = firstNoneRepeatingChar("swiss");
        System.out.println("firstNoneRepeatingChar : "+firstNoneRepeatingChar);

    }
}
