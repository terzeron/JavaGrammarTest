package com.terzeron.grammar;

@FunctionalInterface // 구현해야 할 추상 메소드가 하나만 정의된 인터페이스
public interface Foo {
    // 이 메소드는 구현되지 않고 사용되지만 이 메소드를 가지는 클래스가 lambda나 function 타입이라면 그 기능대로 동작하게 됨
    // 예를 들어, Foo 타입으로 선언된 클래스가 더하기 기능을 하는 lambda라면 method()는 더하기 기능으로 동작함
    String method(String string);

    default void defaultMethod() {
    }
}
