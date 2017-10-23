package net.terzeron.test.exception;

/**
 * Created by terzeron on 2015-12-17.
 */
public class TryWithResourceWithSuppressedException {
    public static void main(String[] args) throws Exception {
        try (Resource resource = new Resource()) {
            resource.use();  // 예외가 발생하는데, 그 예외 메시지 중에 Suppressed가 추가적으로 노출됨
        }
    }
}
