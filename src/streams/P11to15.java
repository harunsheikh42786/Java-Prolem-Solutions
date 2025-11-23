package streams;


import java.util.Comparator;
import java.util.List;

public class P11to15 {
    public static void main(String[] args) {
//         1. Convert a List of integers to a List of squares.
//         Input: `[1, 2, 3, 4]` → Output: `[1,4,9,16]`
        final List<Integer> list1 = List.of(1, 2, 3, 4);
        System.out.println("Original : " + list1);
        final List<Integer> squareList = list1.stream().map(n -> (int)Math.pow(n,2)).toList();
        System.out.println("squareList : " + squareList);

//        2. Filter even numbers from a list.
//        Input: `[3,4,2,7,8]` → Output: `[4,2,8]`
        final List<Integer> list2 = List.of(3,4,2,7,8);
        System.out.println("Original : " + list2);
        final List<Integer> evenNumList = list2.stream().filter(e-> e%2==0).toList();
        System.out.println("evenNumList : " + evenNumList);


//        3. Convert a list of strings to uppercase.
//        Input: `["harun", "java"]` → Output: `["HARUN", "JAVA"]`
        final List<String> list3 = List.of("harun", "java");
        System.out.println("Original : " + list3);
        final List<String> upperList = list3.stream().map(String::toUpperCase).toList();
        System.out.println("upperList : " + upperList);


//        4. Count how many strings start with the letter “A”.
//        Input: `["Apple", "Cat", "Ant", "Boy"]` → Output: `2`
        final List<String> list4 = List.of("Apple", "Cat", "Ant", "Boy");
        System.out.println("Original : " + list4);
        final List<String> startWithAList = list4.stream().filter(s->s.toUpperCase().charAt(0) == 'A').toList();
        System.out.println("startWithAList : " + startWithAList);


//        5. Find the maximum element from a list.
        final List<Integer> list5 = List.of(1,45,1,5,4,64,75,12);
        System.out.println("Original : " + list5);
        final Integer max = list5.stream().max(Comparator.naturalOrder()).get();
        System.out.println("max : " + max);

    }
}
