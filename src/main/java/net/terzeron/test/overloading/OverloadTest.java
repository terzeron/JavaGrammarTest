package net.terzeron.test.overloading;

/**
 * Created by terzeron on 2017. 5. 15..
 */
public class OverloadTest {
    public void print(int i){
        System.out.println("Overloaded method : print(int)");
    }
    public void print(int i, int j, long k){
        System.out.println("Overloaded method : print(int,int,long)");
    }
    public void print(char i, int j){
        System.out.println("Overloaded method : print(char,int)");
    }
    public void print(int i, String str){
        System.out.println("Overloaded method : print(int,string)");
    }
    public void print(long i, int j){
        System.out.println("Overloaded method : print(int,string)");
    }
    public void print(int i, long j){
        System.out.println("Overloaded method : print(int,string)");
    }

    public static void main (String args[]){
        OverloadTest demo = new OverloadTest();
        demo.print(10);
        //This is ambiguious since method parameters not able to resolve the suitable method
        //demo.print(10,10);
        demo.print(10,"string");
        demo.print(10,10,10);

        //Implicit promotion of second parameter to int
        demo.print('a','b');
    }
}
