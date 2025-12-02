package strings;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class P41to45 {

    public static boolean checkEndMatches(String actual, String target){
        boolean continues = true; // 7 - 4 = 0,1,2,3

        int j=0;
        for (int i = actual.length()-target.length(); i < actual.length(); i++) {
            if (target.charAt(j) != actual.charAt(i)){
                continues = false;
            }
            System.out.println(actual.charAt(i) + " : " + target.charAt(j) + " = " + continues);
            j++;
        }

        return continues;
    }
    public static String removeFirstOccurrenceOfChar(String str, char c){
        StringBuilder sb = new StringBuilder();
        boolean isFirstCharRemoved = false;
        // Laravel , a(5) = Lravel
        for (int i = 0; i < str.length(); i++) {
            if (!isFirstCharRemoved && str.toLowerCase().charAt(i) == c){
                    isFirstCharRemoved = true;
                    continue;
            }
             sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    public static String removeLastOccurrenceOfChar(String str, char c){
        StringBuilder sb = new StringBuilder();
        boolean isLastCharRemoved = false;
        // Laravel , a(5) = Lravel
        for (int i = str.length()-1; i >= 0; i--) {
            if (!isLastCharRemoved && str.toLowerCase().charAt(i) == c){
                isLastCharRemoved = true;
                continue;
            }
            sb.append(str.charAt(i));
        }
        return sb.reverse().toString();
    }

    public static String removeAllOccurrenceOfChar(String str, char c){
        StringBuilder sb = new StringBuilder();
        // Laravel , a(5) = Lravel
        for (int i = str.length()-1; i >= 0; i--) {
            if (str.toLowerCase().charAt(i) != c){
                sb.append(str.charAt(i));
            }
        }
        return sb.reverse().toString();
    }

    public static byte[] byteArr(String str){
        byte [] arr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
                arr[i] = (byte)str.charAt(i);
        }
        return arr;
    }


    public static void main(String[] args) {
// Check if string ends with another string (manually)
        final boolean checkEndMatchesResult = checkEndMatches("Program", "gram");
        System.out.println("CheckEndMatches : " + checkEndMatchesResult);
        final boolean checkEndMatchesResult2 = checkEndMatches("Program", "grat");
        System.out.println("CheckEndMatches : " + checkEndMatchesResult2);
// Remove first occurrence of a character
        final String removedFirstCharOccurrence = removeFirstOccurrenceOfChar("Laravel", 'l');
        System.out.println("removedFirstCharOccurrence : " + removedFirstCharOccurrence);
        final String removedFirstCharOccurrence2 = removeFirstOccurrenceOfChar("Laravel", 'a');
        System.out.println("removedFirstCharOccurrence : " + removedFirstCharOccurrence2);

// Remove last occurrence of a character
        final String removedLastCharOccurrence1 = removeLastOccurrenceOfChar("Laravel", 'l');
        System.out.println("removedLastCharOccurrence : " + removedLastCharOccurrence1);
        final String removedLastCharOccurrence2 = removeLastOccurrenceOfChar("Laravel", 'a');
        System.out.println("removedLastCharOccurrence : " + removedLastCharOccurrence2);

// Remove all occurrences of a character
        final String removeAllOccurrenceOfChar1 = removeAllOccurrenceOfChar("Laravel", 'l');
        System.out.println("removeAllOccurrenceOfChar : " + removeAllOccurrenceOfChar1);
        final String removeAllOccurrenceOfChar2 = removeAllOccurrenceOfChar("Laravel", 'a');
        System.out.println("removeAllOccurrenceOfChar : " + removeAllOccurrenceOfChar2);

// Convert string to byte array (without using `getBytes`)
        final byte [] byteArr = byteArr("Harun");
        for (byte b : byteArr){
            System.out.print(b + ", ");
        }
        System.out.println();
        for (byte b : "Harun".getBytes(StandardCharsets.UTF_8)){
            System.out.print(b + ", ");
        }

    }

}
