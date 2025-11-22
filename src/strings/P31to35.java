package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class P31to35 {
    public static String removeDuplicateWord(String str){
        final String[] arr = str.split("[\\s.,-]");
        return Arrays.stream(arr).distinct().collect(Collectors.joining(" "));
    }
    public static String convertingToTitleCase(String str) {
        return Arrays.stream(str.split("[\\s.,-]+"))
                .filter(s -> !s.isEmpty())
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .collect(Collectors.joining(" "));
    }
    public static List<String> subStrings(String str){
        List<String> list = new ArrayList<>();
        for (int i=0; i<str.length(); i++){
            for (int j=i; j<str.length(); j++){
                list.add(str.substring(i,j+1));
            }
        }
        return list;
    }
    public static int countSubstrings(String str){
        int n = str.length(); // ab = a, ab, b = 3
        return n*(n+1)/2; // 2(3)/2 = 3
    }

    public static void main(String[] args) {
        //27️⃣ Count number of substrings
        //in string length N → N*(N+1)/2
        // abc = a ab abc bc c b
        String str = "abc";
        final List<String> strings = subStrings(str);
        System.out.println("String : "+str +", Substrings : "+subStrings(str));
        System.out.println("String : "+str +", CountSubstrings : "+countSubstrings(str));

        // Remove duplicate words from a sentence
        //"I I love coding love" → "I love coding"
        String str1 = "I I love coding love";
        final String removedDuplicateWord = removeDuplicateWord(str1);
        System.out.println("Original : "+str1 + ", Removed : "+removedDuplicateWord);

        // Convert a string to title case
        //"my name is harun" → "My Name Is Harun"
        String str2 = "my name is harun";
        final String convertedToTitleCase = convertingToTitleCase(str2);
        System.out.println("Original : "+str2 + ", Removed : "+convertedToTitleCase);

        // Encode string using run-length encoding (RLE)
        //"aaabbc" → "a3b2c1"
        String str3 = "aaabbcdbb";
        final String rle = runLengthEncoding(str3);
        System.out.println("Original : "+str3 + ", runLengthEncoding : "+rle);


        // Convert string to char array manually
        String str4 = "Programming";
        final char[] charArr = toCharArr(str4);
        System.out.print("Original : " + str4 +", Result : ");
        for (char c : charArr) {
            System.out.print(c+", ");
        }
        System.out.println();
    }
    public static char [] toCharArr(String str){
        char [] arr= new char[str.length()];
        for (int i=0; i<str.length(); i++){
            arr[i] = str.charAt(i);
        }
        return arr;
//        return str.chars().mapToObj(c->(char)c).toArray();
    }
    public static String runLengthEncoding(String str){
        if (str==null) throw new RuntimeException("String should not be null");
        StringBuilder sb = new StringBuilder();
        int count = 0;
        //aaabbc
        for (int i=0; i<str.length(); i++){
            char currChar = str.charAt(i); // a
            if (i != str.length()-1 && str.charAt(i+1) == currChar){
                count++;
            }else{
                count++;
                sb.append(""+currChar+count);
                count = 0;
            }
        }
        return sb.toString();
    }
}
