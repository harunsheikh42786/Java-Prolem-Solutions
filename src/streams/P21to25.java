package streams;

import streams.entities.Employee;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P21to25 {

    public static void main(String[] args) {
//      11. Flatten a list of lists into a single list.
//      Input: `[[1,2], [3,4], [5]]` → Output: `[1,2,3,4,5]`
        List<List<Integer>> listOfList = List.of(List.of(1,2),List.of(3,4),List.of(5,6));
        final List<Integer> flatList = listOfList.stream().flatMap(l -> l.stream()).toList();
        System.out.println("Original : "+ listOfList);
        System.out.println("Flatten List : "+ flatList);

//      12. Given a list of Employee objects, filter employees with salary > 50,000.
        List<Employee> employeeList = List.of(
                new Employee("Alok Sharma", "alok.s@comp.com", "05-12-1995", 32000.00, "IT"),
                new Employee("Priya Verma", "priya.v@comp.com", "14-05-1992", 92000.00, "HR"),
                new Employee("Rohan Das", "rohan.d@comp.com", "01-06-1978", 120000.50, "Finance"),
                new Employee("Sonia Malik", "sonia.m@comp.com", "02-04-1995", 35000.00, "Marketing"),
                new Employee("Vikram Singh", "vikram.s@comp.com", "19-05-1989", 77500.00, "IT"),
                new Employee("Neha Gupta", "neha.g@comp.com", "31-12-1980", 105000.00, "HR"),
                new Employee("Amit Joshi", "amit.j@comp.com", "15-07-1998", 48000.00, "Marketing")
        );
        System.out.println("Original : "+ employeeList);
        final List<Employee> salaried50Plus = employeeList.stream().filter(e -> e.getSalary() > 50000).toList();
        System.out.println("Salaried50+ : "+ salaried50Plus);

//      13. Convert a list of words into a map with word as key and length as value.
        List<String> words = List.of("Apple","Banana","Mango","Grapes","Pineapple");
        final Map<String, Integer> wordWithLength = words.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("Original : "+ words);
        System.out.println("wordWithLength : "+ wordWithLength);

//      14. Check if all elements in a list are even.
        final List<Integer> numbers = List.of(100, 40, 32, 58, 62, 16, 78, 64);
        final boolean evenNumber = numbers.stream().allMatch(n -> n % 2 == 0);
        System.out.println("Original : "+ numbers);
        System.out.println("Even : "+ evenNumber);

//      15. Calculate the sum of all odd numbers in a list.
        final List<Integer> oddNumbers = List.of(101, 43, 35, 57, 61, 165, 71, 69);
        final Integer sumOfOdd = oddNumbers.stream().reduce((a, b) -> Integer.sum(a, b)).get();
        System.out.println("Sum of odd numbers : "+sumOfOdd);
        System.out.println("Odd numbers list : "+oddNumbers);
    }
}
