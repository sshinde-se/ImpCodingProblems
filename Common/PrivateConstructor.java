package Common;

/******************************************************************************

It does not allow to create an object outside the class.
We cannot access a private constructor from any other class.
If all the methods are static then we can use a private constructor.
We can use a public function to call the private constructor if an object is not initialized.
We can return only the instance of that object if an object is already initialized.

*******************************************************************************/

public class PrivateConstructor
{
	public static void main(String[] args) {
		Examp e = Examp.set();
		e.print();
	}
}

class Examp{
    public int a;
    private Examp(){
        this.a=10;
    }
    public void print(){
        System.out.println(a);
    }
    public static Examp set(){
        return new Examp();
    }
    
}