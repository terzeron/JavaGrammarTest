package com.terzeron.grammar.flow;

import com.terzeron.grammar.flow.EndSubscriber2;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;

import static com.jayway.awaitility.Awaitility.await;
import static org.assertj.core.api.Assertions.assertThat;

public class EndSubscriber2Test {
    @Test
    public void whenRequestForOnlyOneElement_thenShouldConsumeOne()
            throws InterruptedException {

        // given
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        EndSubscriber2<String> subscriber = new EndSubscriber2<>(2);
        publisher.subscribe(subscriber);
        List<String> items = List.of("1", "x", "2", "x", "3", "x");
        List<String> expected = List.of("1", "x");

        // when
        assertThat(publisher.getNumberOfSubscribers()).isEqualTo(1);
        items.forEach(publisher::submit);
        publisher.close();

        // then
        await().atMost(1000, TimeUnit.MILLISECONDS)
                .until(() ->
                        assertThat(subscriber.consumedElements)
                                .containsExactlyElementsOf(expected)
                );
    }
}
