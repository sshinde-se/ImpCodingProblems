package PerforceCompany;

public class FirstRoundQuestions {
}

/*
a.b.c.Class Test {
  private String x1;
  protected String x2;
  public String x3;
  String x4;
  }

which variable is accessible from a.b.c.Test to x.y.z.SubClassTest
a.b.c SubclassTest extends Test


which variable is accessible from a.b.c.Test to a.b.c.SubClassTest
a.b.c SubclassTest

 */


//What is output of below program
class Test{
    public void test(Object s){
        System.out.println("Method 1 ");
    }
    public void test(String s){
        System.out.println("Method 2 ");
    }

    public static void main(String[] args){
        new Test().test(null);
    }
}


class A{
    public void test(String s){
        System.out.println("classAtest(Objects)");
    }
}

class B extends A {
    public void test(String s){
        System.out.println("classBtest(Strings)");
    }
    public void test1(String s){
        System.out.println("classBtest1(Strings)");
    }
}

class C extends A{
    public void test(String s){
        System.out.println("classCtest(Strings)");
    }
}

class Test1 {
    public static void main(String[] args) {//Question 1
        A a = new A();
        a.test(""); //classAtest(Objects)
        a = new B();
        a.test("");//classBtest(Objects)
        a = new C();
        a.test("");//classCtest(Objects)
    }
}

class Test2 {
    public static void main(String[] args) {
        A a = new B();
        //a.test1("");//method not
    }
}
class Test3 {
    public static void main(String[] args) {
        //B b = new A();
        //b.test("");
    }
}


class Student{
    static Student t=null;
    static synchronized Student getStudent(){
        if(t==null)
            return new Student();
        else
            return t;
    }
    private Student(){
    }
}

/*

Public double getDiscount(int cartTotal) {
        double discount = 0;
        if (cartTotal > 100 && cartTotal < 200) {
        discount = cartTotal * 0.10;
        } else if (cartTotal > 200 && cartTotal < 300) {
        discount = cartTotal * 0.20;
        } else if (cartTotal > 300) {
        discount = cartTotal * 0.30;
        }
        return discount;
        }


 */