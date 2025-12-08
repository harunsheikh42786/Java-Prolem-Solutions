package strings;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P51to55 {
    public static String replaceVowelsWithStars(String str){
        final List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (vowels.contains(str.charAt(i))){
                sb.append("*");
            }else sb.append(str.charAt(i));

        }
        return sb.toString();
    }
    public static boolean containsUniqueOnly(String str){
        return str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().allMatch(entry-> entry.getValue()==1);
    }
    public static String camelCase(String str){
        String result = Arrays.stream(str.split("[ -,.]")).map(s-> s.toUpperCase().charAt(0)+s.substring(1)).collect(Collectors.joining(""));
        return result.toLowerCase().charAt(0)+result.substring(1);
    }
    public static void main(String[] args) {
//         Replace vowels with '*'
            String str1 = "Program";
        final String replaceVowelsWithStar = replaceVowelsWithStars(str1);
        System.out.println("Original : " + str1);
        System.out.println("ReplaceVowelsWithStars : " + replaceVowelsWithStar);
//         Print only unique characters
        String str2 = "Programming";
        str2.chars().distinct().mapToObj(c->(char)c).forEach(System.out::println);

//         Check if string is made up of only unique characters
        final boolean contains1 = containsUniqueOnly("Harun");
        System.out.println("Harun : " + contains1);
        final boolean contains2 = containsUniqueOnly("Sheikh");
        System.out.println("Sheikh : " + contains2);
//         Print string in zig-zag pattern
        String str = "Programming";
        int rows = 3;   // Zig-Zag rows

        if (rows == 1) {
            System.out.println(str);
        }

        StringBuilder[] arr = new StringBuilder[rows];
        for (int i = 0; i < rows; i++) arr[i] = new StringBuilder();

        int row = 0;
        boolean down = true; // direction

        for (char c : str.toCharArray()) {
            arr[row].append(c);

            // direction change
            if (row == 0) down = true;
            else if (row == rows - 1) down = false;

            row += down ? 1 : -1;
        }

        for (StringBuilder sb : arr) {
            System.out.println(sb);
        }
//         Convert string into CamelCase
        final String camelCase = camelCase("Hello java program");
        System.out.println(camelCase);
    }
}
