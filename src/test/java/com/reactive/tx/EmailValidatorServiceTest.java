package com.reactive.tx;

import org.apache.commons.validator.routines.EmailValidator;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class EmailValidatorServiceTest implements WithAssertions {
    String USERNAME_64 = "a".repeat(64);
    String FIRST_63 = "d".repeat(63);
    String FIRST_64 = "d".repeat(64);
    EmailValidator validator = EmailValidator.getInstance();

    @Test
    void testSG() {
        String part2 = ".xn--clchc0ea0b2g2a9gcd";
        checkIsValid(USERNAME_64, FIRST_63, part2,true );
        checkIsValid(USERNAME_64, FIRST_64, part2, false );
    }

    @Test
    void testCO_UK() {
        String part2 = ".co.uk";
        checkIsValid(USERNAME_64, FIRST_63, part2,true );
        checkIsValid(USERNAME_64, FIRST_64, part2, false );
    }

    void checkIsValid(String username, String part1, String part2, boolean isValid) {
        assertThat(validator.isValid(username + "@" + part1 + part2)).isEqualTo(isValid);
    }
}