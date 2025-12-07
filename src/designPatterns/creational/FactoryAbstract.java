package designPatterns.creational;

public abstract class FactoryAbstract {
    abstract Employee2 createEmployee();
}

class Main2{
    public static void main(String[] args) {
        Employee2 employee = EmployeeFactory.getEmployee(new BackendFactory());
        System.out.println(employee.name() + " : " +employee.salary());
        Employee2 employee2 = EmployeeFactory.getEmployee(new FrontendFactory());
        System.out.println(employee2.name() + " : " +employee2.salary());
        Employee2 employee3 = EmployeeFactory.getEmployee(new DevOpsFactory());
        System.out.println(employee3.name() + " : " +employee3.salary());
    }
}

class EmployeeFactory {
    public static Employee2 getEmployee(FactoryAbstract factoryAbstract){
        return factoryAbstract.createEmployee();
    }
}

class BackendFactory extends FactoryAbstract{
    @Override
    Employee2 createEmployee() {
        return new Backend2(25000,"Harun");
    }
}

class FrontendFactory extends FactoryAbstract{
    @Override
    Employee2 createEmployee() {
        return new Frontend2(45000,"Sufiyan");
    }
}

class DevOpsFactory extends FactoryAbstract{
    @Override
    Employee2 createEmployee() {
        return new DevOps2(30000,"Umar");
    }
}
interface Employee2{
    int salary();
    String name();
}
class Backend2 implements Employee2{
    int salary ;
    String name;
    Backend2(int salary, String name){
        this.salary= salary;
        this.name = name;
    }

    @Override
    public int salary() {
        return salary;
    }

    @Override
    public String name() {
        return name;
    }
}
class Frontend2 implements Employee2{
    int salary ;
    String name;
    Frontend2(int salary, String name){
        this.salary= salary;
        this.name = name;
    }

    @Override
    public int salary() {
        return salary;
    }

    @Override
    public String name() {
        return name;
    }
}
class DevOps2 implements Employee2{
    int salary ;
    String name;
    DevOps2(int salary, String name){
        this.salary= salary;
        this.name = name;
    }

    @Override
    public int salary() {
        return salary;
    }

    @Override
    public String name() {
        return name;
    }
}