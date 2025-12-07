package designPatterns.creational;

public class BuilderPattern {
    public static void main(String[] args) {
        Teacher teacher = new Teacher.Builder().age(16).name("Merchin").build();
        System.out.println(teacher);
    }
}

class Teacher{
   private final int age;
   private final String name;
    Teacher(Builder builder){
        this.age = builder.age;
        this.name = builder.name;
    }
    public String toString(){
        return "age : " + age + ", name : "+name;
    }

    static class Builder{
        private int age;
        private String name;
        private Builder builder;
        public Builder age(int age){
            this.age = age;
            return this;
        }
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Teacher build(){
            Teacher teacher1 = new Teacher(this);
            return teacher1;
        }
    }
}
