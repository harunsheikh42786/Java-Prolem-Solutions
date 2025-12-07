package designPatterns.creational;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

//    Pepsi pepsi = new Pepsi(); private Constructor

        final Pepsi pepsi = Pepsi.getInstance();
        pepsi.setAmount(10);
        System.out.println(pepsi.hashCode());

        final Constructor<Pepsi> constructor = Pepsi.class.getDeclaredConstructor();
        constructor.setAccessible(true);  // ✔ Reflection ko private constructor call karne ki permission

        final Pepsi pepsi1 = constructor.newInstance(); // Throw exception, because we already created instance,
        System.out.println(pepsi1.hashCode()); // and changed private to public constructor, but failed because instance is not null

    }

}
class Pepsi{
    private static Pepsi pepsi;
    int amount;

    private Pepsi(){
        if (pepsi != null)
            throw new RuntimeException("You can't create instance using Reflection.");
    }

    public static Pepsi getInstance(){
        if (pepsi == null) {
            pepsi = new Pepsi();   // ✔ FIX
        }
        return pepsi;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }
    public int getAmount(){
        return amount;
    }
}
