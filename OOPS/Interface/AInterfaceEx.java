package OOPS.Interface;

interface Interf{
    int x = 10;
    void methodOne();
    void methodTwo();
}
public class AInterfaceEx implements Interf{
    public void methodOne(){
        System.out.println("Implemented interface");
        //x = 20; It will give us error as every variable in interface is public static final whether we are declaring or not
    }

    public void methodTwo() {
        System.out.println("Implemented interface with methodTwo");
    }
    // If we comment line 14-16 then it will give error as every method in interface is public and abstract whether we are declaring or not
    // if we are not implementing any method then we need declare that class as abstract and child class of
    // this class is responsible to provide implementation for that method
}
