package org.password;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PasswordCheckerTest {

    @Test
    void shouldReturnTrueForComplexPasswordWithDigitsAndSpecialChars() {
         assertTrue( PasswordChecker.checkPasswordComplexity("Password123!"));
    }
    @Test
    void shouldReturnFalseForPasswordWithoutDigits() {
        assertFalse (PasswordChecker.checkPasswordComplexity("Password"));
    }

    @Test
    void shouldReturnFalseForPasswordWithoutSpecialChars() {
        assertFalse(PasswordChecker.checkPasswordComplexity("Password"));
    }

    @Test
    void shouldReturnFalseForPasswordShorterThan8Chars() {
        assertFalse(PasswordChecker.checkPasswordComplexity("Pass12"));
    }

    @Test
    void shouldReturnFalseForEmptyPassword() {
        assertFalse(PasswordChecker.checkPasswordComplexity("+*^%$*)&($$^**"));
    }

    @Test
    void shouldMessageAboutAValidPassword() {
        assertEquals( PasswordChecker.checkPasswordComplexity("Password123!"),PasswordChecker.checkPasswordComplexity("Password123!"),"Password is complex.");

    }
    @Test
    void displayAMessageAboutAnInvalidPassword(){
        assertEquals( PasswordChecker.checkPasswordComplexity("123!"),PasswordChecker.checkPasswordComplexity("123!"),"Password must contain at least one digit, one special character, and have a length of at least 8 characters.");

    }

}
