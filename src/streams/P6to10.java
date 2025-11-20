package streams;

import streams.entities.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P6to10 {
    public static void main(String[] args) {
        Student s1 = new Student(123, "Harun", "harun1521@email.com", "02-04-2000", 452, "Science", "Dudu");
        Student s2 = new Student(124, "Danish", "danish@mail.com", "15-06-2001", 389, "Commerce", "Jaipur");
        Student s3 = new Student(125, "Faizan", "faizan@mail.com", "20-09-2000", 478, "Science", "Ajmer");
        Student s4 = new Student(126, "Aabid", "aabid@mail.com", "11-12-2001", 350, "Arts", "Kishangarh");
        Student s5 = new Student(127, "Junaid", "junaid@mail.com", "07-03-2002", 410, "Computer", "Dudu");
        Student s6 = new Student(128, "Sameer", "sameer@mail.com", "19-07-2000", 499, "Science", "Jaipur");
        Student s7 = new Student(129, "Zeeshan", "zeeshan@mail.com", "26-02-2001", 320, "Commerce", "Ajmer");

        List<Student> scienceStudents = List.of(s1, s3, s6);
        List<Student> commerceStudents = List.of(s2, s7);
        List<Student> artsStudents = List.of(s4);
        List<Student> computerStudents = List.of(s5);

        final List<List<Student>> listOfList = List.of(scienceStudents, commerceStudents, artsStudents, computerStudents);

        // FlatMap
        final List<Student> flatList = listOfList.stream().flatMap(l -> l.stream()).toList();
        System.out.println("FlatList : "+flatList);
        //map to name
        final List<String> flatNames = flatList.stream().map(e -> e.getName()).toList();
        System.out.println("FlatList Names : "+flatNames);
        // GroupByDepartmentAndCount
        final Map<String, Long> mapDepartmentWiseCount = flatList.stream().collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
        System.out.println("Department Wise Count : "+mapDepartmentWiseCount);
        //GroupByCityAndStudentNames
        final Map<String, List<String>> groupByCityAndNames = flatList.stream().collect(Collectors.groupingBy(Student::getCity, Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println("Groupt by city and names : "+groupByCityAndNames);
        // GroupByDeptAndSortByNames
        Map<String, List<String>> groupByDeptAndSortByNames =
                flatList.stream()
                        .collect(Collectors.groupingBy(
                                Student::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparing(Student::getName))
                                                .map(Student::getName)
                                                .toList()
                                )
                        ));
        System.out.println("GroupByDeptAndSortByNames  : " +groupByDeptAndSortByNames);
    }
}
