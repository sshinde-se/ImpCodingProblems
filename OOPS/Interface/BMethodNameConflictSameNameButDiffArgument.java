package OOPS.Interface;
interface Left1
{
    public void methodOne1();
}
interface Right1
{
    public void methodOne1(int i);
}
//if two interfaces contain a method with same name but different arguments in the
//implementation class we have to provide implementation for both methods and these
//methods acts as a overloaded methods
public class BMethodNameConflictSameNameButDiffArgument implements Left1,Right1 {
    @Override
    public void methodOne1() {

    }

    @Override
    public void methodOne1(int i) {

    }
}
