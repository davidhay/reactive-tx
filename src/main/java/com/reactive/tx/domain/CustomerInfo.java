package com.reactive.tx.domain;

import javax.validation.constraints.*;

public class CustomerInfo {
    @Min(1)
    @Max(100)
    private int age;

    @NotNull
    @NotBlank
    private String first;
    @NotNull
    @NotBlank    private String last;

    @Email
    private String email;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
