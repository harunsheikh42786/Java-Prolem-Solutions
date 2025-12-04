package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P26to30 {
    public static void main(String[] args) {


//        16. Find the second highest number in a list.
//        (Without sorting the original list)
        final List<Integer> integers = List.of(13, 45, 68, 21, 45, 65, 15);
        Integer max = integers.stream().max(Integer::compareTo).get();
        Integer secondMax = integers.stream()
                .filter(n -> n < max)
                .max(Integer::compareTo)
                .orElse(Integer.MIN_VALUE);

        System.out.println("Original : " + integers);
        System.out.println("SecondHighest : " + secondMax);
//        17. Convert a comma-separated string into List<Integer>.
        String numberString = "12,56,78,9,1,2,45,35";
//        Example: `"1,2,3,4"`
        final String[] splitArr = numberString.split("[,]");
        final List<Integer> integerList = Arrays.stream(splitArr).map(Integer::parseInt).toList();
        System.out.println("Original : " + numberString);
        System.out.println("IntegerList : " + integerList);

//        18. Find the longest string from a list.
        final List<String> strings = List.of("Program", "Generics", "Palindrome", "Mediator", "Interpreter");
        final String longestString = strings.stream().max(Comparator.comparing(String::length)).get();
        System.out.println("Original : " + strings);
        System.out.println("LongestList : " + longestString);

//        19. Find duplicate elements from a list using Streams.
//        Input: `[1,2,2,3,4,4,5]`
//        Output: `[2,4]`
        final List<Integer> dulicateNumbersList = List.of(1, 2, 2, 3, 4, 4, 5).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).toList();
        System.out.println("Original : [1,2,2,3,4,4,5]");
        System.out.println("duplicateNumbersList : " + dulicateNumbersList);

//        20. Find the highest occurring character in a string using Streams.
//        Input: `"Mississippi"`
//        Output: `i`
        String str = "Mississippi";
        final Optional<Map.Entry<Character, Long>> maxChar = Optional.of(str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().reduce((a, b) -> a.getValue() > b.getValue() ? a : b).get());
        System.out.println("Original : "+str);
        System.out.println("CharMap : " + maxChar);



    }
}
