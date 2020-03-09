package com.terzeron.grammar.functional_interface;

@FunctionalInterface
interface Foo {
    String method(String string);
}

class UseFoo1 {
    public String add(String string, Foo foo) {
        return foo.method(string);
    }
}

public class FITest1 {
    public static void main(String[] args) {
        // 클래스처럼 보이지만 실제로는 funtional method에 불과함
        Foo foo = parameter -> parameter + " from lambda";
        UseFoo1 useFoo = new UseFoo1();
        String result = useFoo.add("Message", foo);
        System.out.println(result);
    }
}
