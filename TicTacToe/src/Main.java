public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        A a = new A();
        B b = new B();
        C c = new C();
        a.foo();
        b.foo();
        c.foo();
        ((B) c).foo();
        ((A) c).foo();  // C
        ((A) b).foo();  // B
        ((A) a).foo();  // A
    }
    static class A {
        public void foo() {
            System.out.println("A");
        }
    }
    static class B extends A {
        public void foo() {
            System.out.println("B");
        }
    }
    static class C extends B {
        public void foo() {
            System.out.println("C");
        }
    }
}
