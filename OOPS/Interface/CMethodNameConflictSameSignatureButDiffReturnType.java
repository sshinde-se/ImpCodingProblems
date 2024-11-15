package OOPS.Interface;
interface Left2
{
    public void methodOne2();
}
interface Right2
{
    public int methodOne2();
}
//If two interfaces contain a method with same signature but different return types then it
//is not possible to implement both interfaces simultaneously

//public class MethodNameConflictSameSignatureButDiffReturnType implements Left2,Right2{
//    @Override
//    public int methodOne2() {
//
//        return 0;
//    }
//}
