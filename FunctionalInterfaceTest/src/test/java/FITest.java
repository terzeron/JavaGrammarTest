import com.terzeron.grammar.Foo;
import com.terzeron.grammar.FooExtended;
import com.terzeron.grammar.UseFoo;
import com.terzeron.grammar.UseFooExtended;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Function;

public class FITest {
    private UseFoo useFoo;
    private UseFooExtended useFooExtended;

    @Before
    public void setUp() {
        useFoo = new UseFoo();
        useFooExtended = new UseFooExtended();
    }

    @Test
    public void test() {
        Foo foo = parameter -> parameter + " from lambda";
        String result = useFoo.add("a flower", foo);
        Assert.assertEquals("a flower from lambda", result);
    }

    @Test
    public void testWithFI() {
        Function<String, String> fn = parameter -> parameter + " from lambda";
        String result = useFoo.addWithStandardFI("a box", fn);
        Assert.assertEquals("a box from lambda", result);
    }

    @Test
    public void testWithFooExtended() {
        FooExtended foo = parameter -> parameter + " from lambda (extended)";
        String result = useFooExtended.add("a letter", foo);
        Assert.assertEquals("a letter from lambda (extended)", result);
    }

    private String value = "enclosing scope value";

    @Test
    public void testScope() {
        Foo fooIC = new Foo() {
            String value = "inner class value";

            @Override
            public String method(String string) {
                // 여기서 this는 내부 클래스(Foo)의 인스턴스(fooIC)를 가리킴
                return this.value;
            }
        };
        String resultIC = fooIC.method("meaningless parameter");
        Assert.assertEquals("inner class value", resultIC);

        Foo fooLambda = parameter -> {
            String value = "lambda value";
            // 여기서 this는 lambda 자체가 아니라 enclosing class(FITest)의 인스턴스를 가리킴
            return this.value;
        };
        String resultLambda = fooLambda.method("meaningless parameter");
        Assert.assertEquals(resultLambda, "enclosing scope value");
    }
}
