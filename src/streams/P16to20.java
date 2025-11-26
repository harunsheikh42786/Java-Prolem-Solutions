package streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P16to20 {
    public static void main(String[] args) {
//         6. Find the minimum element from a list.
        List<Integer> list1 = List.of(45,12,11,56,91,16);
        final Integer min = list1.stream().min(Comparator.naturalOrder()).get();
        System.out.println("\n Original : "+list1);
        System.out.println("Minimum element : "+min);
// 7. Sort a list of numbers using streams.
        List<Integer> list2 = List.of(45,12,11,56,91,16);
        final List<Integer> sortedList = list2.stream().sorted().toList();
        System.out.println("\n Original : "+list2);
        System.out.println("Sorted : "+sortedList);

// 8. Remove duplicates from a list.
//Input: `[1,2,2,3,3,4]` → Output: `[1,2,3,4]`
// 🔶 MEDIUM LEVEL – Stream Questions
        List<Integer> list3 = List.of(1,2,2,3,3,4);
        final List<Integer> uniqueList = list3.stream().distinct().toList();
        System.out.println("\n Original : "+list3);
        System.out.println("Unique : "+uniqueList);

// 9. Find the frequency of each element in a list.
//Input: `[1,1,2,3,3]`
//Output: `{1=2, 2=1, 3=2}`
        final List<Integer> list4 = List.of(1, 1, 2, 3, 3);
        final Map<Integer, Long> frequencyOfEach = list4.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("\n Original : "+list4);
        System.out.println("FrequencyElem : "+frequencyOfEach);

// 10. Find the first non-repeated character in a string using streams.
//Input: `"swiss"` → Output: `w`
        String str = "swiss";
        final Map<Character, Long> freqChars = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        final Character firstNoneRepeatedChar = freqChars.entrySet().stream().filter(e -> e.getValue() == 1).findFirst().get().getKey();
        System.out.println("\n Original String : "+str);
        System.out.println("First none repeated char : "+firstNoneRepeatedChar);

    }
}
