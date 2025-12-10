package streams;

import streams.entities.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class P36to40 {
    public static void main(String[] args) {
//        26. Remove empty strings and null values from a list.
        final LinkedList<String> strings = new LinkedList<>();
        strings.add("Harun");
        strings.add("Musa");
        strings.add("");
        strings.add(null);
        strings.add("");

        final List<String> removedNullAndEmpty = strings.stream()
                .filter(s -> s != null && !s.isEmpty())
                .toList();
        System.out.println("Original : " + strings);
        System.out.println("RemovedNullAndEmpty : " + removedNullAndEmpty);

//        27. Group words by their starting letter.
//        Input: `[apple, bat, ball, ant]`
//        Output: `{a=[apple, ant], b=[bat, ball]}`
        final List<String> words = List.of("Apple", "Ant", "Ball", "Cat", "Dog", "Dolphin", "Apartment", "Braces", "Egg");
        final Map<Character, List<String>> mapOfFirstCharGroup = words.stream().collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("Original : " + words);
        System.out.println("mapOfFirstCharGroup : " + mapOfFirstCharGroup);

//        28. Given a list of Employees, find the department with the highest average salary.
        final List<Employee> employees = List.of(
                new Employee("Harun", "harun@gmail.com", "01-01-2000", 65000.00, "Developer"),
                new Employee("Umar", "umar@gmail.com", "31-07-2000", 65000.00, "Developer"),
                new Employee("Sufiyan", "sufiyan@gmail.com", "22-06-2000", 5000.00, "DataAnalyst"),
                new Employee("Muhammed", "muhammad@gmail.com", "28-08-2000", 35000.00, "Debugger"),
                new Employee("Shad", "shad@gmail.com", "16-07-2000", 85000.00, "Debugger"),
                new Employee("Bilal", "bilal@gmail.com", "12-08-2000", 15000.00, "Developer")
        );

// Step 1: Group employees by department and compute average salary
        Map<String, Double> avgSalaryMap =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.averagingDouble(Employee::getSalary)));
// Step 2: Find the department with highest average salary
        Map.Entry<String, Double> highestAvgDept =
                avgSalaryMap.entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                        .orElse(null);
        System.out.println("highestAvgDept : "+highestAvgDept);

//        29. Parallel stream: find sum of large list of numbers using parallelStream().
//        (And compare performance)
        // Large list (1 to 10 million)
        int size = 10_000_000;

        // Normal Stream
        long start1 = System.currentTimeMillis();
        long sum1 = IntStream.range(0, size).sum();
        long end1 = System.currentTimeMillis();

        System.out.println("Normal Stream Sum = " + sum1);
        System.out.println("Normal Stream Time = " + (end1 - start1) + " ms");

        // Parallel Stream
        long start2 = System.currentTimeMillis();
        long sum2 = IntStream.range(0, size).parallel().sum();
        long end2 = System.currentTimeMillis();

        System.out.println("Parallel Stream Sum = " + sum2);
        System.out.println("Parallel Stream Time = " + (end2 - start2) + " ms");

//        30. Partition integers into even and odd buckets using `Collectors.partitioningBy`.
//        Output example:
//        {
//            TRUE: [2,4,6],
//            FALSE: [1,3,5]
//        }
        final Map<Boolean, List<Integer>> evenOdd = IntStream.range(0, 10).mapToObj(n -> (int) n).collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even : " + evenOdd.get(true));
        System.out.println("Odd : " + evenOdd.get(false));

    }
}
