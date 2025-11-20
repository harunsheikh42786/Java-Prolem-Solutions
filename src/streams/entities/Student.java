package streams.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student {

    private int id;
    private String name;
    private String email;
    private LocalDate dob;
    private double marks;
    private String department;
    private String city;

    public Student(int id, String name, String email, String dob, double marks, String department, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.marks = marks;
        this.department = department;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", marks=" + marks +
                ", department='" + department + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
