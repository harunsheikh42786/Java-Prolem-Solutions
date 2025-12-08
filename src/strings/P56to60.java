package strings;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P56to60 {



    public static void main(String[] args) {
//      Count frequency of chars using Streams
        final Map<Character, Long> charCount = "Progamming".chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Programming : "+charCount);
//      Convert each character to ASCII values using streams
        final List<Integer> ASCII = "ABCDEFGhijklm".chars().boxed().toList();
        System.out.println("ABCDEFGhijklm : " + ASCII);
//      Sort characters by frequency using streams
        final LinkedHashMap<Character, Long> sortByFreq = charCount.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
        System.out.println("SortByFreq : " + sortByFreq);
//      Find first non-repeated using streams
        final Character firstNonRepeatedChar = charCount.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().map(entry -> entry.getKey()).get();
        System.out.println("FirstNonRepeatedChar : " + firstNonRepeatedChar);
//      Group characters into vowels & consonants using streams
        final List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        final Map<Boolean, List<Character>> vowelsAndConsonant = "Hypocritic".chars().mapToObj(c -> (char) c).collect(Collectors.partitioningBy(c -> vowels.contains(c)));
        System.out.println("Vowels : "+vowelsAndConsonant.get(true));
        System.out.println("Consonants : "+vowelsAndConsonant.get(false));
    }
}
