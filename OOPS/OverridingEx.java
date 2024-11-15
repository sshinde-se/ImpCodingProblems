package OOPS;
class Parent {
    void display() {
        System.out.println("method in Parent class");
    }
}

class Child extends Parent {
    void display() {
        System.out.println("method in Child class");
    }
}
public class OverridingEx {
    public static void main(String[] args){
        Parent p = new Parent();
        p.display();

        Child c = new Child();
        c.display();

        Parent p1 = new Child();
        p1.display();
    }
}
