package streams.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee{
    private String name;
    private String email;
    private LocalDate dob;
    private double salary;
    private String Department;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public Employee(String name, String email, String dob, double salary, String department) {
        this.name = name;
        this.email = email;
        this.dob = LocalDate.parse(dob, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.salary = salary;
        this.Department = department;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", salary=" + salary +
                ", Department='" + Department + '\'' +
                '}';
    }
}