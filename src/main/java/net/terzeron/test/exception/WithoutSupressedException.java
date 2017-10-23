package net.terzeron.test.exception;

import static java.lang.System.err;

public class WithoutSupressedException {
    public static void test() throws Exception {
        Resource resource = new Resource();
        try {
            resource.use(); // 여기서 runtime 예외가 발생하면
        } finally {
            resource.close(); // 여기서 발생한 nullpointer 예외는 catch가 안 됨
        }
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            err.println("Exception encountered: " + e.toString());
            final Throwable[] suppressedExceptions = e.getSuppressed(); // 차단된 예외를 끌어올림
            final int numSuppressed = suppressedExceptions.length;
            if (numSuppressed > 0) {
                // 여기는 실행되지 않음
                err.println("There are " + numSuppressed + " suppressed exceptions:");
                for (final Throwable exception : suppressedExceptions) {
                    err.println("" + exception.toString());
                }
            }
        }
    }
}
