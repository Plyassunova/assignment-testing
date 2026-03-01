package org.bank;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BankParameterizedTest {
    @ParameterizedTest
    @CsvSource({
            "100, 50, 150",
            "100, 0.01, 100.01",
            "100, 250.75, 350.75"
    })
    void depositParameterized(double initial, double deposit, double expected) {
        BankAccount account = new BankAccount("1", "Test", initial);
        account.deposit(deposit);
        assertEquals(expected, account.getBalance(), 1e-9);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.0, -100.5})
    void depositInvalidValues(double amount) {
        BankAccount account = new BankAccount("1", "Test", 100);
        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(amount));
        assertEquals(100, account.getBalance(), 1e-9);
    }

    @ParameterizedTest
    @CsvSource({
            "500, 100, 400",
            "500, 500, 0"
    })
    void withdrawParameterized(double initial, double withdraw, double expected) {
        BankAccount account = new BankAccount("1", "Test", initial);
        account.withdraw(withdraw);
        assertEquals(expected, account.getBalance(), 1e-9);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -1.0, -100.5})
    void withdrawInvalidValues(double withdraw) {
        BankAccount account = new BankAccount("1", "Test", 100);
        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(withdraw));
        assertEquals(100, account.getBalance(), 1e-9);
    }

    @ParameterizedTest
    @ValueSource(doubles = {100.01, 1000.0})
    void withdrawExceedingBalanceThrows(double withdraw) {
        BankAccount account = new BankAccount("1", "Test", 100);
        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(withdraw));
        assertEquals(100, account.getBalance(), 1e-9);
    }
}