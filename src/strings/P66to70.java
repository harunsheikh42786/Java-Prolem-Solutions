package strings;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P66to70 {

    //Sol : 1
    public static boolean checkIsomorphic(String str1, String str2){
        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty() || str1.length() != str2.length()){
            throw new IllegalArgumentException("String Can't be null.");
        }
        final Map<Character, Character> map = Map.of('a', 'w', 'b', 'q', 'c', 'r', 'd', 'p');

        for (int i = 0; i < str1.length(); i++) {
            if(map.get(str1.charAt(i)) != str2.charAt(i)){
                System.out.println("Error : "+map.get(str1.charAt(i)) + " : " + str2.charAt(i));
                return false;
            }
        }
        return true;
    }
    // Sol : 2
    public static boolean checkMetaStrings(String str1, String str2){
        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty() || str1.length() != str2.length()){
            throw new IllegalArgumentException("String Can't be null.");
        }
        return str1.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .equals(str2.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }
    // Sol : 3
    public static String containsPatternSubstring(String str, String regex) {
        if (str == null || regex == null || str.isEmpty() || regex.isEmpty()) {
            throw new IllegalArgumentException("String can't be null or empty");
        }

        Pattern pattern = Pattern.compile(regex);
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String sub = str.substring(i, j);
                Matcher matcher = pattern.matcher(sub);

                if (matcher.find()) {
                    if (result.isEmpty() || sub.length() < result.length()) {
                        result = sub;
                    }
                    break; // smallest for this `i`
                }
            }
        }
        return result;
    }
    public static int distinctCharCount(String str){
        return str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).size();
    }
    // Sol : 4
    public static String longestKDistinctSubstring(String str, int k) {
        int longestStringSize = 0;
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String substring = str.substring(i, j + 1);
                int size = distinctCharCount(substring);

                if (size == k && substring.length() > longestStringSize) {
                    result = substring;
                    longestStringSize = substring.length();
                }
            }
        }
        return result;
    }
    // Sol : 5
    public static String atMostKDistinctSubstring(String str, int k) {
        int longestLength = 0;
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String substring = str.substring(i, j + 1);
                int distinct = distinctCharCount(substring);

                if (distinct <= k && substring.length() > longestLength) {
                    result = substring;
                    longestLength = substring.length();
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
// Check if two strings are isomorphic
        System.out.println("\nCheck Isomorphic String : ");
        String str1 = "acdb";
        String str2 = "wrqp";
        final boolean resultIsomorphic = checkIsomorphic(str1, str2);
        System.out.println("Str1 : " + str1 + ", Str2 : " + str2);
        System.out.println("Result : " + resultIsomorphic);

        String str3 = "acdb";
        String str4 = "wrpq";
        final boolean resultIsomorphic2 = checkIsomorphic(str3, str4);
        System.out.println("Str3 : " + str3 + ", Str4 : " + str4);
        System.out.println("Result2 : " + resultIsomorphic2);

// Check if strings are meta strings
        System.out.println("\nCheck Meta String : ");
        String str5 = "Hello";
        String str6 = "Holle";
        final boolean checkMetaStrings1 = checkMetaStrings(str5, str6);
        System.out.println("Str5 : " + str5 + ", Str6 : " + str6);
        System.out.println("Result2 : " + checkMetaStrings1);

        String str7 = "Hello";
        String str8 = "Hollo";
        final boolean checkMetaStrings2 = checkMetaStrings(str7, str8);
        System.out.println("Str7 : " + str7 + ", Str8 : " + str8);
        System.out.println("Result2 : " + checkMetaStrings2);


// Find smallest substring containing a given pattern
        System.out.println("\nSmallest substring containing given Pattern :");
        String str9 = "Programming";
        String regex = "m{2}";
        final String containsPatternSubstring = containsPatternSubstring(str9, regex);
        System.out.println("Str : "+ str9 + ", Regex : " + regex);
        System.out.println("Result : " + containsPatternSubstring);

        String str10 = "beautifuuulday";
        String regex2 = "[aeiouAEIOU]{3,}";
        final String containsPatternSubstring2 = containsPatternSubstring(str10, regex2);
        System.out.println("Str : "+ str10 + ", Regex : " + regex2);
        System.out.println("Result : " + containsPatternSubstring2);

// Find substring with exactly K distinct characters
        System.out.println("\nLongest substring with exactly K distinct character :");
        String str11 = "abecurcuex";
        final String result = longestKDistinctSubstring(str11, 3);
        System.out.println("Str11 : " + str11);
        System.out.println("Result : " + result);

// Find substring with at most K distinct characters
        System.out.println("\nLongest substring with at most K distinct character :");
        String str12 = "abecurabe";
        final String result2 = atMostKDistinctSubstring(str12, 3);
        System.out.println("Str12 : " + str12);
        System.out.println("Result2 : " + result2);

    }

}
