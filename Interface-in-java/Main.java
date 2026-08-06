interface A{
    default void method1(){
        System.out.println("This is method1 of interface A");
    }
}

interface B{
    default void method2(){
        System.out.println("This is method2 of interface B");
    }
}

class C implements A, B{
   
    @Override
    public void method1() {
        A.super.method1();
        B.super.method2();
        System.out.println("This is method1 of class C");
    }
}

public class Main {
    public static void main(String[] args) {
        C obj = new C();
        obj.method1();
    }
}