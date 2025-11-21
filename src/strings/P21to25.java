package strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P21to25 {
    public static String removeAllSpecial(String str){
//        final Pattern compile = Pattern.compile("[A-Za-z0-9]");
        return str.replaceAll("[^A-Za-z0-9]","");
    }
    public static char maxFreqChar(String str){
        return str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }
    public static String sortChar(String str){
        return str.chars().mapToObj(c->String.valueOf((char)c)).sorted().collect(Collectors.joining(""));
    }
    public static String multiSpacesToOne(String str){
        StringBuilder result  = new StringBuilder();
        for (int i=0; i<str.length(); i++){
//            if (!Character.isWhitespace(str.charAt(i)) && Character.isWhitespace(str.charAt(i+1))){
            if(str.charAt(i) == ' ' && str.charAt(i+1) != ' '){
                result.append(str.charAt(i));
            } else if (!Character.isWhitespace(str.charAt(i))) {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        //Remove all special characters
        //(/[A-Za-z0-9]/ allowed only)
        String str1 = "Harun is a programmer, and looking for a job.";
        final String removedAllSpecial = removeAllSpecial(str1);
        System.out.printf("Original : %s, \nRemovedAllSpecial : %s \n",str1,removedAllSpecial);

        // Print character with maximum frequency
        //("abbccc" → c)
        String str2 = "abbccc";
        final char maxFreqChar = maxFreqChar(str2);
        System.out.printf("Original : %s, \nMaxFreqChar : %s \n",str2,maxFreqChar);

        // Sort characters of a string alphabetically
        String str3 = "Harun Sheikh";
        final String sortChars = sortChar(str3);
        System.out.printf("Original : %s, \nSortChars : %s \n",str3,sortChars);

        // Replace multiple spaces with a single space
        //("This is me" → "This is me")
        String str4 = "Harun     Sheikh is  a  programmer   .";
        final String replacedMultipleSpacesToOne = multiSpacesToOne(str4);
        System.out.printf("Original : %s, \nReplacedMultipleSpacesToOne : %s \n",str4,replacedMultipleSpacesToOne);

        // Find all permutations of a string
        //(recursion / backtracking)
        String str5 = "ABC";
        permute(str5, "");

    }
    public static void permute(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i); // A
            String left = str.substring(0, i); //
            String right = str.substring(i + 1); // BC
            String rest = left + right; //ABC
            permute(rest, ans + ch);
        }
    }
}
