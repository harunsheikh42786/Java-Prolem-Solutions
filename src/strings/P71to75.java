package strings;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P71to75 {

    // Sol : 1
    public static boolean checkSubsequencesExistence(String str, String subsequence){
        if (str == null || str.isEmpty() || subsequence == null || subsequence.isEmpty()) throw new RuntimeException("String can't be null.");
        int i = 0; // string pointer
        int j = 0; // subsequence pointer
        while(i < str.length() && j < subsequence.length()){
            if (str.charAt(i) == subsequence.charAt(j)){
                j++;
            }
            i++;
        }
        return j == subsequence.length();
    }
    // Sol : 2
    public static boolean checkIfStringCanBeAPalindromeIfAtMostOneCharRemoved(String str) {

        if (str == null || str.isEmpty())
            throw new RuntimeException("String can't be null or empty.");

        if (str.length() == 1) return true;

        boolean oneCharIgnored = false;
        int i = 0, j = str.length() - 1;

        while (i < j) {

            if (str.charAt(i) != str.charAt(j)) {

                if (oneCharIgnored) {
                    return false;
                }

                oneCharIgnored = true;

                if (isPalindromeRange(str, i + 1, j)) {
                    i++;
                } else if (isPalindromeRange(str, i, j - 1)) {
                    j--;
                } else {
                    return false;
                }

                continue;
            }

            i++;
            j--;
        }

        return true;
    }
    private static boolean isPalindromeRange(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Sol : 3
    public static boolean checkBothSubsequencesOfEachOther(String sub1, String sub2) {

        if (sub1 == null || sub2 == null) {
            throw new RuntimeException("Strings can't be null");
        }

        // check: sub2 is subsequence of sub1
        int i = 0, j = 0;
        while (i < sub1.length() && j < sub2.length()) {
            if (sub1.charAt(i) == sub2.charAt(j)) {
                j++;
            }
            i++;
        }
        if (j < sub2.length()) return false;

        // check: sub1 is subsequence of sub2
        int i2 = 0, j2 = 0;
        while (i2 < sub2.length() && j2 < sub1.length()) {
            if (sub2.charAt(i2) == sub1.charAt(j2)) {
                j2++;
            }
            i2++;
        }
        if (j2 < sub1.length()) return false;

        return true;
    }
    // Sol : 4
    public static String removedEveryChar(String str, String target){
        List<Character> list = target.chars().mapToObj(c->(char)c).toList();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (!list.contains(str.charAt(i)))
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    public static void printCharWithSortedFrequency(String str){
        str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue)).forEach(entry-> System.out.print(entry.getKey()+""+entry.getValue()));
    }
    public static void main(String[] args) {
// Check if subsequence exists
        System.out.println("Check subsequence exist :");
        String str = "Programming", subsequence = "oaig";
        final boolean resultSubsequenceExist = checkSubsequencesExistence(str, subsequence);
        System.out.println("String : " + str + ", Subsequence : " + subsequence);
        System.out.println("Result Subsequence Exist : " + resultSubsequenceExist);

        String str2 = "Programming", subsequence2 = "oaimg";
        final boolean resultSubsequenceExist2 = checkSubsequencesExistence(str2, subsequence2);
        System.out.println("String : " + str2 + ", Subsequence : " + subsequence2);
        System.out.println("Result Subsequence Exist : " + resultSubsequenceExist2);

// Check if string can be made palindrome after deleting at most 1 char
        System.out.println("\nCheck if string can be palindrome at most one removal of char :");
        String str3 = "madama";
        final boolean resultOfCheckPalindromePossibility = checkIfStringCanBeAPalindromeIfAtMostOneCharRemoved(str3);
        System.out.println("String : " + str3);
        System.out.println("Result Palindrome Possible : " + resultOfCheckPalindromePossibility);
        String str4 = "madiama";
        final boolean resultOfCheckPalindromePossibility2 = checkIfStringCanBeAPalindromeIfAtMostOneCharRemoved(str4);
        System.out.println("String : " + str4);
        System.out.println("Result Palindrome Possible : " + resultOfCheckPalindromePossibility2);


// Check if one string is subsequence of another
        System.out.println("\nCheck if both string are subsequence of each other :");
        String sub1 = "Program", sub2 = "rga";
        final boolean resultOfSubsequenceCheck = checkBothSubsequencesOfEachOther(sub1, sub2);
        System.out.println("Subsequence : " + sub1 + ", Subsequence : " + sub2);
        System.out.println("Result Subsequence each other : " + resultOfSubsequenceCheck);
        String sub3 = "Program", sub4 = "rgar";
        final boolean resultOfSubsequenceCheck2 = checkBothSubsequencesOfEachOther(sub3, sub4);
        System.out.println("Subsequence : " + sub3 + ", Subsequence : " + sub4);
        System.out.println("Result Subsequence each other : " + resultOfSubsequenceCheck2);
        String sub5 = "Program", sub6 = "Program";
        final boolean resultOfSubsequenceCheck3 = checkBothSubsequencesOfEachOther(sub5, sub6);
        System.out.println("Subsequence : " + sub5 + ", Subsequence : " + sub6);
        System.out.println("Result Subsequence each other : " + resultOfSubsequenceCheck3);

// Remove characters from 1 string that appear in another
        System.out.println("\nRemove Characters from 1 that appear in another :");
        String str7 = "majority", str8 = "ajr";
        final String resultAfterRemoved = removedEveryChar(str7, str8);
        System.out.println("Str7 : " + str7 + ", Target" + str8);
        System.out.println("Result : " + resultAfterRemoved);
// Print characters sorted by frequency
        System.out.println("\nPrinting character sorted by frequency : ");
        String str9 = "Programming";
        System.out.print("String : " +str9 +", Output : ");
        printCharWithSortedFrequency(str9);
        System.out.println();
    }
}
