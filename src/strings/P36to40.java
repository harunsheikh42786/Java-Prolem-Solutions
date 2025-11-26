package strings;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P36to40 {
    public static char [] stringToCharArr(String str){
        char [] charArr = new char[str.length()];
        for (int i=0; i<str.length(); i++) {
            charArr[i] = str.charAt(i);
        }
        return charArr;
    }
    public static void main(String[] args) {
        //  Convert string to char array manually
        final char[] alphabets = stringToCharArr("Alphabet");
        System.out.print("Char [] : ");
        for (char c : alphabets){
            System.out.print(c+", ");
        }
        System.out.println();

        // Count alphabets, digits & special chars separately
        String str = "A string of 50 characters, mixed with letters (alpha), numbers (digit), and symbols (specia!) #@$%";
        Map<String, Long> characterCounts = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        // Corrected lambda expression for the classifier (key)
                        c -> {
                            if (Character.isDigit(c)) return "Digit";
                            else if (Character.isLetter(c)) return "Alphabet";
                            else return "Special char";
                        },
                        // Downstream collector (value)
                        Collectors.counting()
                ));
        System.out.println("Original : "+str);
        System.out.println("character counts : "+characterCounts);
        // Swap first and last character
        final List<String> wrongFruits = List.of("Eppla", "Aananb", "Srapeg", "Eineapplp");
        final List<String> fruits = wrongFruits.stream().map(P36to40::replaceFirstWithLastChar).toList();
        System.out.println("Original : "+wrongFruits);
        System.out.println("Fruits : "+fruits);
        // Convert every odd index char to uppercase
        String str2 = "Programming";
        final String convertEveryOddToUpperCase = IntStream.range(0, str2.length()).mapToObj(i -> {
            char c = str2.charAt(i);
            if (i % 2 != 0) {
                c = Character.toUpperCase(c);
            }
            return c;
        }).map(String::valueOf).collect(Collectors.joining());
        System.out.println("Original : "+str2);
        System.out.println("Convert : "+convertEveryOddToUpperCase);
        // Convert every even index char to lowercase
        final String convertEveryOddToLowerCase = IntStream.range(0, str2.length()).mapToObj(i -> {
            char c = str2.charAt(i);
            if (i % 2 == 0) {
                c = Character.toLowerCase(c);
            }
            return c;
        }).map(String::valueOf).collect(Collectors.joining());
        System.out.println("Original : "+str2);
        System.out.println("Convert : "+convertEveryOddToLowerCase);

    }
    public static String replaceFirstWithLastChar(String s){
//        return s.toUpperCase().charAt(s.length() - 1) + s.substring(1, s.length() - 1) + s.toLowerCase().charAt(0);
        return (char)(s.charAt(s.length() - 1)-32) + s.substring(1, s.length() - 1) + (char)(s.charAt(0)+32);
    }
}
