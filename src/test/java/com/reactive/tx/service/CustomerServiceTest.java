package com.reactive.tx.service;

import com.reactive.tx.utils.Transaction;
import com.reactive.tx.domain.Customer;
import com.reactive.tx.repository.CustomerRepository;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
@Import(Transaction.class)
class CustomerServiceTest implements WithAssertions {

    @Autowired
    Transaction tx;

    @Autowired
    CustomerService service;

    @Autowired
    CustomerRepository repo;

    @Test
    void testSave() {
        Customer customer = new Customer("test");

        Mono<Customer> saving = service.save(customer);

        saving
                .as(Transaction::withRollback)
                .as(StepVerifier::create)
                .consumeNextWith(saved -> {
                    System.out.printf("saved is %s%n", saved);
                    assertThat(saved.id()).isGreaterThan(3);
                }).verifyComplete();
    }

    @AfterEach
    void tearDown() {
        repo.count().doOnNext(count -> {
            assertThat(count).isEqualTo(3);
        }).subscribe();
    }
}
