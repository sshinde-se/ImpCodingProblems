package OOPS;
class Parent1 {
    static void display() {
        System.out.println("Static method in Parent class");
    }
}

class Child1 extends Parent1 {
    static void display() {
        System.out.println("Static method in Child class");
    }
}

//It is called method hiding because the static method in the subclass(Child1) does not override the method
//in the superclass(Parent1). Instead, it hides the superclass’s method. The superclass’s method is still
// accessible, but it requires using the class name of the superclass to access it directly.
public class OverridingStaticMethod {
    public static void main(String[] args){
        Parent1 parent1 = new Parent1();
        parent1.display(); // Instead write this Parent1.display() as it is static method

        Child1 child1 = new Child1();
        child1.display();


        Parent1 parent11 = new Child1();
        //When parent11.display() is called, it still invokes the display method in the Parent1 class,
        //even though parent11 is a reference to an object of the Child1 class. This is because
        //the method resolution is done at compile-time based on the reference type
        //(Parent1 in this case), not the actual object type.
        parent11.display();
    }
}
