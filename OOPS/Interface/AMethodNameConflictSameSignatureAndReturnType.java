package OOPS.Interface;
interface Left
{
    public void methodOne();
}
interface Right
{
    public void methodOne();
}
public class AMethodNameConflictSameSignatureAndReturnType implements Left,Right {
    public void methodOne()
    {
        System.out.println("Implementation of methodOne");
    }
    //Here If two interfaces contain a method with same signature and same return type in the
    //implementation class only one method implementation is enough
}
