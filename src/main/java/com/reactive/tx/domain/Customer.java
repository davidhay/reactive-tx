package com.reactive.tx.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("customer")
public record Customer(@Id Long id, String name,
                       @CreatedDate LocalDateTime created,
                       @LastModifiedDate LocalDateTime updated) {

    public Customer(String name) {
        this(null, name, null, null);
    }

    @PersistenceCreator
    public Customer {
    }

}
