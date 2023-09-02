package com.reactive.tx;

import com.reactive.tx.repository.CustomerRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

@SpringBootTest
class TxApplicationTests implements WithAssertions {

    @Autowired
    CustomerRepository repo;

    @Test
    void testDatabaseHasInitialised() {
        StepVerifier.create(repo.count()).consumeNextWith(count -> {
            assertThat(count).isEqualTo(3);
        }).verifyComplete();
    }

}
