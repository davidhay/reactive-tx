package com.reactive.tx.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

@Table("customer")
public record Customer(@Id Long id, String name) {

    public Customer(String name) {
        this(null, name);
    }

    @PersistenceCreator
    public Customer {
    }

}
