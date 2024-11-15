package OOPS.Interface;

//A marker interface is an interface that doesn’t have any methods or constants inside it.
// It provides run-time type information about objects, so the compiler and JVM have additional
// information about the object.
//https://www.baeldung.com/java-marker-interfaces

//remove implements Cloneable and check output of program
public class EMarkerInterfaceEx implements Cloneable{
    public static void main(String[] args) throws CloneNotSupportedException {
        EMarkerInterfaceEx obj1 = new EMarkerInterfaceEx();
        System.out.println(obj1);
        EMarkerInterfaceEx obj2 = (EMarkerInterfaceEx) obj1.clone();
        System.out.println(obj2);
        //If we try to clone an object that doesn’t implement this interface, the JVM throws a 
        // CloneNotSupportedException. Thus, the Cloneable marker interface is an indicator to the 
        // JVM that we can call the Object.clone() method.
    }
}
