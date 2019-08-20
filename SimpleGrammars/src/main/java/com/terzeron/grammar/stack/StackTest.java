package com.terzeron.grammar.stack;

import java.util.Stack;

/**
 * Created by terzeron on 2015-12-17.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<Integer>();

        s1.push(123);
        s1.push(956);
        s1.push(89);

        System.out.println("check whether com.terzeron.grammar.stack is empty? " + s1.empty());
        System.out.println("Top element of com.terzeron.grammar.stack is: " + s1.peek());
        System.out.println("Element removed from com.terzeron.grammar.stack is: " + s1.pop());
        System.out.println("com.terzeron.grammar.stack element after removal:" + s1);
        System.out.println("Check for element '56' in com.terzeron.grammar.stack: " + s1.search(56));
    }
}
