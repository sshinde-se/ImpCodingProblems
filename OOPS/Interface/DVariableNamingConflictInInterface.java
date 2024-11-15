package OOPS.Interface;
interface Left3
{
    int x=10;
}
interface Right3
{
    int x=20;
}
public class DVariableNamingConflictInInterface implements Left3,Right3{
    public void method(){
        //System.out.println(x); //it will give error saying x is ambiguous so do it like below
        System.out.println(Left3.x);
        System.out.println(Right3.x);
    }
}
