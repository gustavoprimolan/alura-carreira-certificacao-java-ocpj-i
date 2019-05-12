class B {
    void x() {
        System.out.println("vazio");
    }
    void x(String... args) {
        System.out.println(args.length);
    }
}
class C {
    void x(String... args) {
        System.out.println(args.length);
    }
    void x() {
        System.out.println("vazio");
    }
}
class A {
    public static void main(String[] args) {
        new B().x();
        new C().x();
    }
}