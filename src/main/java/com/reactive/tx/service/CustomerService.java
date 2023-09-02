package com.reactive.tx.service;

import com.reactive.tx.domain.Customer;
import com.reactive.tx.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Mono;

@Service
@Transactional //every public method is transactional
public class CustomerService {
    private final TransactionalOperator operator;
    private final CustomerRepository repo;

    public CustomerService(TransactionalOperator operator, CustomerRepository repo) {
        this.operator = operator;
        this.repo = repo;
    }

    public Mono<Customer> save(Customer customer) {
        return repo.save(customer)
                //.as(operator::transactional)
                ;
    }
}
