package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P6to10 {
    public static boolean checkAnagram(String str1, String str2) {
        // Using stream
//        return str1.toLowerCase().chars().mapToObj(c->(char)c).sorted().toList().equals(str2.toLowerCase().chars().mapToObj(c->(char)c).sorted().toList());

        // Using Arrays
//        char [] a = str1.toLowerCase().toCharArray();
//        char [] b= str2.toLowerCase().toCharArray();
//        Arrays.sort(a);
//        Arrays.sort(b);
//        return Arrays.equals(a, b);

        // Using Map
//        final Map<Integer, Long> map1 = str1.toLowerCase().chars().sorted().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        final Map<Integer, Long> map2 = str2.toLowerCase().chars().sorted().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(map1);
//        System.out.println(map2);
//        return map1.equals(map2);

        // Using Function
        final Function<String, List<Integer>> stringListFunction =
                (String s) -> s.toLowerCase()
                        .chars()
                        .sorted()
                        .boxed()
                        .collect(Collectors.toList());

            return stringListFunction.apply(str1).equals(stringListFunction.apply(str2));
        }

        // Count Vowels and Consonant using map
        public static Map<String, Integer> consonantAndVowels(String str){
            // Using Loop
            int vowel =0, consonant =0;
            for (int i=0; i<str.length(); i++){
                final List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
                if(vowels.contains(str.charAt(i)))
                    vowel++;
                else {
                    if(Character.isLetter(str.charAt(i)))
                        consonant++;
                }
            }
            final HashMap<String, Integer> map = new HashMap<>();
            map.put("Vowel",vowel);
            map.put("Consonant",consonant);
            return map;
        }

        // Count vowels and consonant using stream
        public static Map<String, Long> countVowelAndCons2(String str){
            return             str.chars()
                    .mapToObj(c -> (char)c)
                    .collect(Collectors.groupingBy(
                            c -> {
                                if("aeiou".indexOf(c) >= 0 )
                                    return  "Vowels";
                            else
                                if(Character.isLetter(c)) return "Consonants";
                                else return "Other";
                            },
                            Collectors.counting()
                    ));
    }
    // Count lower and upper case chars
    public static Map<String, Long> countLowerCaseAndUpperCase(String str){
        int a = 'a', z = 'z', A = 'A', Z = 'Z';
        int lowerCase = 0, upperCase = 0;
        for (int i = 0; i < str.length(); i++) {
            int c = str.charAt(i);
            if ( c >= a && c <= z){
                lowerCase++;
            }else if (c >= A && c <= Z){
                upperCase++;
            }
        }
        System.out.println("lower : " + lowerCase);
        System.out.println("upper : " + upperCase);
//        final HashMap<String, Integer> map = new HashMap<>();
//        map.put("LowerCase",lowerCase);
//        map.put("UpperCase",upperCase);
//        return map;
        Map<String, Long> counts =
                str.chars()
                        .mapToObj(c -> (char)c)
                        .collect(Collectors.groupingBy(
                                c -> {
                                    if (c >= 'a' && c <= 'z') {
                                        return "lowerCase";
                                    } else if (c >= 'A' && c <= 'Z') {
                                        return "upperCase";
                                    } else {
                                        return "other";
                                    }
                                },
                                Collectors.counting()
                        ));
        return counts;
    }
    // Count words in a sentence
    public static int countWords(String str){
        return (int) Arrays.stream(str.split("[\\s.,-]+"))
                .filter(s -> !s.isEmpty())
                .count();
    }

    public static void main(String[] args) {
        // Containing letters with same count
        final boolean isAnagram = checkAnagram("Silent", "Listen");
        System.out.println("Silent, Listen is anagram : "+isAnagram);

        // Consonant and vowels
        final Map<String, Integer> vowelAndConsonant = consonantAndVowels("Harun Sheikh");
        System.out.println(vowelAndConsonant);
        final Map<String, Long> vowelAndConsonant2 = countVowelAndCons2("Harun Sheikh");
        System.out.println(vowelAndConsonant2);

        // Count lower and upper case
        final Map<String, Long> upperLowerCount = countLowerCaseAndUpperCase("Harun Sheikh is good Programmer.");
        System.out.println(upperLowerCount); //95
        System.out.println(0+'a'); //95
        System.out.println(0+'z'); //122
        System.out.println(0+'A'); //65
        System.out.println(0+'Z'); //90

        // Count words in a sentence
        final int countWords = countWords("Harun is java backend developer, one year hand's on experience through self learning.");
        System.out.println("CountWords : " + countWords);
    }

}
