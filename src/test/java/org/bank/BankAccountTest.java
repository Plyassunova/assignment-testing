package org.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    @Test
    void validInitialBalanceInitializesCorrectly() {
        BankAccount account = new BankAccount("1", "Alice", 100.0);
        assertEquals(100.0, account.getBalance(), 1e-9);
    }

    @Test
    void negativeInitialBalanceThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount("1", "Alice", -0.01));
    }

    @Test
    void normalDepositIncreasesBalance() {
        BankAccount account = new BankAccount("1", "Alice", 100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 1e-9);
    }

    @Test
    void zeroDepositThrowsException() {
        BankAccount account = new BankAccount("1", "Alice", 100.0);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));
        assertEquals(100.0, account.getBalance(), 1e-9);
    }

    @Test
    void negativeDepositThrowsException() {
        BankAccount account = new BankAccount("1", "Alice", 100.0);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-1.0));
        assertEquals(100.0, account.getBalance(), 1e-9);
    }

    @Test
    void normalWithdrawalReducesBalance() {
        BankAccount account = new BankAccount("1", "Alice", 100.0);
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance(), 1e-9);
    }

    @Test
    void withdrawalEqualToBalanceSucceeds() {
        BankAccount account = new BankAccount("1", "Alice", 100.0);
        account.withdraw(100.0);
        assertEquals(0.0, account.getBalance(), 1e-9);
    }

    @Test
    void withdrawalExceedingBalanceThrowsException() {
        BankAccount account = new BankAccount("1", "Alice", 100.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100.01));
        assertEquals(100.0, account.getBalance(), 1e-9);
    }

    @Test
    void zeroOrNegativeWithdrawalThrowsException() {
        BankAccount account = new BankAccount("1", "Alice", 100.0);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-5.0));

        assertEquals(100.0, account.getBalance(), 1e-9);
    }
}