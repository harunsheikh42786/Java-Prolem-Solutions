package strings;

import java.util.*;

public class P26to30 {


    public static int largestPalindrome(String s) {
        if (s == null || s.isEmpty()) throw new RuntimeException("String should not be null or empty");
        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindromes
            max = Math.max(max, expand(s, i, i));
            // Even length palindromes
            max = Math.max(max, expand(s, i, i + 1));
        }
        return max;
    }

    private static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // palindrome length
    }

    public static int longPal(String str) {
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {

                String sub = str.substring(i, j + 1); // FIX 1

                if (checkPal(sub)) {
                    max = Math.max(max, j - i + 1); // FIX 2
                }
            }
        }
        return max;
    }

    public static boolean checkPal(String str) {
        if (str.length() <= 1) return true;

        return (str.charAt(0) == str.charAt(str.length() - 1))
                && checkPal(str.substring(1, str.length() - 1)); // Still OK
    }
    public static boolean balancedBrackets(String str){
        if(str == null || str.isEmpty()) throw new RuntimeException("String should not be null or empty");
        Stack<Character> s = new Stack<>();
        //{[( )]}
        for (int i=0; i<str.length(); i++){
            final char c = str.charAt(i);
            if (c == '{' || c == '[' || c == '('){
                s.push(c);
            }else{
                final Character pop = s.pop();
                if (pop == '{' && c != '}' || pop == '[' && c != ']' || pop == '(' && c != ')'){
                    return false;
                }
            }
        }
        return s.isEmpty();
    }
    public static String prefix(String [] arr){
        StringBuilder prefix = new StringBuilder();
        String firstStr = arr[0];
        for (int i=0; i<firstStr.length(); i++){
            char c = firstStr.charAt(i);
            boolean consider = true;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j].length() <= i || arr[j].charAt(i) != c){
                    consider = false;
                    break;
                }
            }
            if (consider)
                prefix.append(c);
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        //22️⃣ Find largest palindrome substring
        //("babad" → "bab")
        String str1 = "babad";
        final int largestPalindrome = largestPalindrome(str1);
        System.out.println("LargestPalindrome of " + str1 + ", Result : " + largestPalindrome);
        final int largestPalindrome2 = longPal(str1);
        System.out.println("LargestPalindrome of " + str1 + ", Result : " + largestPalindrome2);
        
        //23️⃣ Check if a string has balanced brackets
        //{ [ ( ) ] } → valid
        String str2 = "{[()]}";
        final boolean isBalanced = balancedBrackets(str2);
        System.out.println(str2 + " : " + isBalanced);
        String str3 = "{[(])}";
        final boolean isBalanced2 = balancedBrackets(str3);
        System.out.println(str3 + " : " + isBalanced2);

        //24️⃣ Find longest common prefix among strings
        //(["flower","flow","flight"] → "fl")
        final String prefix = prefix(new String[]{"flower", "flow", "flight"});
        System.out.println("Prefix : " + prefix);

        // Find longest common substring
        //(dynamic programming)
        String [] arr = {"Prorgram","Ramasis","Gram","Ikram","Ram"};
        final String commonSubstring = commonSubstring(arr);
        System.out.println("CommonSubstring : " + commonSubstring);

        // Implement your own substring() logic
        String str = "Programming";
        final String subStr = subStringLogic(str, 2, 5);
        System.out.println("Original : " + str +", Substring : "+ subStr);
    }
    public static String commonSubstring(String[] arr) {

        if (arr == null || arr.length == 0) return "";

        // Find shortest string
        int shortStrInd = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() < arr[shortStrInd].length()) {
                shortStrInd = i;
            }
        }

        String shortest = arr[shortStrInd].toLowerCase(); // ram
        String longestCommon = "";

        // Check all substrings of the shortest string
        for (int i = 0; i < shortest.length(); i++) {
            for (int j = i + 1; j <= shortest.length(); j++) {

                String sub = shortest.substring(i, j);  // current substring // 0,1 r

                // Skip if smaller than existing best
                if (sub.length() <= longestCommon.length()) continue;

                boolean presentInAll = true;

                for (String s : arr) {
                    if (!s.toLowerCase().contains(sub)) {
                        presentInAll = false;
                        break;
                    }
                }

                if (presentInAll) longestCommon = sub;
            }
        }

        return longestCommon;
    }
    public static String subStringLogic(String str, int start, int end){
        if (start < 0 || end > str.length()) throw new RuntimeException("String should be in range 0 to "+str.length());
        StringBuilder sb = new StringBuilder();
        for (int i=start; i<end; i++){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }




}
