package Pubmatic;

public interface Interf {
    void methodOne();

    class Test {
        public static void main(String[] args) {
            Interf i = () -> System.out.println("MethodOne Execution");
            i.methodOne();
        }
    }
}