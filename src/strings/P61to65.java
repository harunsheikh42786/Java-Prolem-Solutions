package strings;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P61to65 {
    public static void main(String[] args) {
//      Split words and sort them by length
        final String[] strings = "Hey this is Harun, Java developer. Looking for a job. Inform me if there is a match found.".split("[ ,.-]");
        final List<String> sortedStringByLength = Arrays.stream(strings).sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println(sortedStringByLength);
//      Remove duplicates using streams
        final String removedDuplicates = "Programming".chars().mapToObj(c -> ((char) c) + "").distinct().collect(Collectors.joining(""));
        System.out.println("RemoveDeplicate : " + removedDuplicates);
//      Reverse a string using Collectors
        final String reverseUsingCollectors = "Hello".chars().mapToObj(c -> (char) c).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
            Collections.reverse(list);
            return list.stream().map(String::valueOf).collect(Collectors.joining());
        }));
        System.out.println("Reverse : "+reverseUsingCollectors);
//      Count digits using Streams
        final long digits = "Hello Welcome, this is 2025's end day, let's repent for upcoming life from 1 jan to".chars().mapToObj(c -> (char) c).filter(Character::isDigit).count();
        System.out.println("Count digits : " + digits);
//      Find all substrings using streams
        String str = "ABCD";
        final List<String> substrings = IntStream.range(0, str.length()).boxed().flatMap(i -> IntStream.range(i + 1, str.length() + 1).mapToObj(j -> str.substring(i, j))).toList();
        System.out.println("Substrings : " + substrings);
    }
}
