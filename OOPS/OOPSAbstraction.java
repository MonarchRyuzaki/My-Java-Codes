public class OOPSAbstraction{
    public static void main (String args[])
    {
        Horse h = new Horse();
        h.eat();
        h.walk;
        Chicken c = new Chicken();
        c.eat();
        c.walk();
        
        Animal a = new Animal();//error

    }
}
abstract class Animal {
    String color;
    Animal(){
        color="brown";
    }
    void eat() {
        System.out.println("Animal eats");
    }
    abstract void walk();
}
class Horse extends Animal{
    void changeColor(){
        color = "dark brown";
    }
    void walk() {
        System.out.println("walks on 4 legs");
    }
}

class Chicken extends Animal {
    void changeColor() {
        color="yellow";
    }
    void walk() {
        System.out.println("walks of 2 legs");
    }
}