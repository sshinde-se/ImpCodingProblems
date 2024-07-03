/******************************************************************************

The class named hack3 extends hack2 and implements the hack1 interface.
It inherits the myMethod implementation from hack2 and satisfies the contract of the hack1 interface
by providing an implementation for the myMethod method.

*******************************************************************************/

public class InterfaceEx
{
	public static void main(String[] args) {
		hack3 a = new hack3();
		a.myMethod();
	}
}
interface hack1{
    void myMethod();
}
class hack2{
    public void myMethod(){
        System.out.println("I love hackerearth");
    }
}
class hack3 extends hack2 implements hack1{}