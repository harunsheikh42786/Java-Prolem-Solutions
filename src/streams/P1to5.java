package streams;

import streams.entities.Employee;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class P1to5 {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Harun", "harun@email.com", "01-01-2000", 85000.00, "Developer"),
                new Employee("Danish", "danish@email.com", "13-06-2000", 45000.00, "Designer"),
                new Employee("Aabid", "aabid@email.com", "19-03-2000", 75000.00, "Designer"),
                new Employee("Junaid", "junaid@email.com", "31-05-2000", 65850.00, "FrondEnd"),
                new Employee("Faizan", "faizan@email.com", "24-09-2000", 95850.00, "Developer")
        );

        // Filter
        final List<Employee> empSalaryMoreThan70K = employees.stream().filter(e -> e.getSalary() > 70000).toList();
        System.out.println("Salary More than 70k : " + empSalaryMoreThan70K);
        // Map
        final List<String> empSalaryMoreThan70KNames = empSalaryMoreThan70K.stream().map(Employee::getName).toList();
        System.out.println("Salary More than 70k Names : " + empSalaryMoreThan70KNames);
        // Reduce
        final double totalSalary = employees.stream()
                .reduce(0.0,
                        (sum, emp) -> sum + emp.getSalary(),
                        Double::sum);
        System.out.println("Total salary of employees : " + totalSalary);
        // Sorted DESC
        final List<Employee> sortedBySalary =  employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).toList();
        System.out.println("Soted by salary desc order : " + sortedBySalary);
        // Min Skip Limit Peek
        final Employee employee = sortedBySalary.stream().peek(System.out::println).skip(1).limit(2).min(Comparator.comparing(Employee::getSalary)).get();
        System.out.println("Min salary emp in top 3 : "+employee);
    }

}
