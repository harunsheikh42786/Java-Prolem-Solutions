package strings;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P16to20 {
    //Find the first repeating character
    //(e.g., "aabbcc" → 'a')
    public static char firstRepeatingChar(String str){
        List<Character> characters = new ArrayList<>();
        for (char c : str.toCharArray()) {
            if (!characters.contains(c)){
                characters.add(c);
            }else{
                return c;
            }
        }
        return ' ';
    }
    public static String reverseString(String str){
        return new StringBuilder(str).reverse().toString();
    }
    // Reverse each word in a sentence
    public static String reverseEachWord(String str){
        final String[] strArr = str.split("[\\s.,-]");
        return Arrays.stream(strArr).map(s-> reverseString(s)).collect(Collectors.joining(" "));
    }
    // Reverse each word in a sentence
    public static String longestWord(String str){
        final String[] strArr = str.split("[\\s.,-]");
        return Arrays.stream(strArr)
                .collect(Collectors.toMap(
                    Function.identity(),
                    String::length,
                    (existing, replacement) -> existing,
                    LinkedHashMap::new
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }
    public static boolean containsOnlyDigits(String str){
        for (char c : str.toCharArray()){
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }
    public static boolean checkRotation(String str, String rotated, int rotationIndex, String side){
        if (side.toLowerCase().equals("left")){
            System.out.println(str.substring(rotationIndex)+str.substring(0,2));
            return rotated.equals(str.substring(rotationIndex)+str.substring(0,2));
        }
        // 5-2 = 3->end + 0 -> 3
        // un+Har str.substring(str.length-rotation) + str.substring(0,str.length-rotation)
        System.out.println(str.substring(str.length()-rotationIndex)+str.substring(0, str.length()-rotationIndex));
        return rotated.equals(str.substring(str.length()-rotationIndex)+str.substring(0, str.length()-rotationIndex)); // Harun -> unHar // un+Har
    }
    public static void main(String[] args) {
        // Find the first repeating character
        // (e.g., "aabbcc" → 'a')
        final char firstRepeatingChar = firstRepeatingChar("aabbcc");
        System.out.println("FirstRepeatingChar : " + (firstRepeatingChar != ' '? firstRepeatingChar : "not found"));
        final char firstRepeatingChar2 = firstRepeatingChar("abcd");
        System.out.println("FirstRepeatingChar : " + (firstRepeatingChar2 != ' '? firstRepeatingChar2 : "not found"));

        // Reverse each word in a sentence
        String str = "String is immutable, Changes in string create another reference in string pool.";
        final String reversedEachWord = reverseEachWord(str);
        System.out.println("Original : " + str);
        System.out.println("Reversed : " + reversedEachWord);

        // Find longest word in a sentence
        final String longerWord = longestWord(str);
        System.out.println("LongestWord : " + longerWord);

        // Check if a string contains only digits
        String str1 = "123456879";
        final boolean result1 = containsOnlyDigits(str1);
        System.out.println("Original : " + str1 + ", Result : " + result1);
        String str2 = "1234v56879c";
        final boolean result2 = containsOnlyDigits(str2);
        System.out.println("Original : " + str2 + ", Result : " + result2);

        // Check if string is rotation of another
        String normal = "abcd", rotated = "cdab";
        final boolean res1 = checkRotation(normal, rotated, 2, "left");
        System.out.printf("Normal : %s, rotated : %s, Result : %b \n",normal, rotated, res1);
        String normal2 = "abcd", rotated2 = "cdab";
        final boolean res2 = checkRotation(normal2, rotated2, 2, "right");
        System.out.printf("Normal : %s, rotated : %s, Result : %b \n",normal2, rotated2, res2);
    }
}
