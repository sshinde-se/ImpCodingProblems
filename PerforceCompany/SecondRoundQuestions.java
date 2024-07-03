package PerforceCompany;

import java.util.HashMap;
import java.util.Map;


class A1 {
    public void methodA() {
        System.out.println("MethodA");
    }
}

class B1 extends A1 {
    public void methodA() {
        System.out.println("MethodA");
    }

    public void methodB() {
        System.out.println("MethodB");
    }
}

public class SecondRoundQuestions {
    public static void main(String args[]) {
        A1 a = new B1();
        //a.methodB();  will give error
    }
}

class Employee1 {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

class Sample {
    public static void main(String args[]) {
        Employee1 e = new Employee1();
        e.setName("Test");
        Map<Employee1, Integer> map = new HashMap<>();
        map.put(e, 10);
        System.out.println(map.get(e));//10

    }
}