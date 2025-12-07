package designPatterns.creational;

import java.util.Scanner;

public class Factory {
    public static Employee getEmployee(){
        Scanner sc = new Scanner(System.in);
        final String input = sc.next();

        if (input.equalsIgnoreCase("Backend")){
            return new BackendDeveloper("Harun");
        } else if (input.equalsIgnoreCase("Frontend")) {
            return new FrontendDeveloper("Junaid");
        }else {
            return new DevOpsDeveloper("Jakir");
        }
    }
}

interface Employee {
    String getName();
}

class Main{



    public static void main(String[] args) {
        final Employee instance1 = Factory.getEmployee();
        System.out.println(instance1);

        final Employee instance2 = Factory.getEmployee();
        System.out.println(instance2.getName());
        System.out.println(instance2);
        System.out.println(instance2 instanceof FrontendDeveloper);


    }
}

class BackendDeveloper implements Employee{
    String name;
    BackendDeveloper(String name){this.name = name;}
    public String getName(){return name;}
}

class FrontendDeveloper implements Employee{
    String name;
    FrontendDeveloper(String name){this.name = name;}
    public String getName(){return name;}
}
class DevOpsDeveloper implements Employee{
    String name;
    DevOpsDeveloper(String name){this.name = name;}
    public String getName(){return name;}
}