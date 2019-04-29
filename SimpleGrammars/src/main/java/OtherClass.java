public class OtherClass {
    public static void main(String[] args) {
        OtherClass o = new OtherClass();
        o.method();
    }

    // access level
    //           inside class   inside package  other package by subclass other package
    // private   Y
    // default   Y              Y
    // protected Y              Y               Y
    // public    Y              Y               Y                         Y

    void method() {
        SuperClass class1 = new SuperClass();
        System.out.println(class1.i);
    }
}
