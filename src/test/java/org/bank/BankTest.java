package org.bank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    @Test
    void accountsAreAddedCorrectly() {
        Bank bank = new Bank();
        bank.addAccount(new BankAccount("1", "Alena", 100));
        bank.addAccount(new BankAccount("2", "Bob", 200));

        assertEquals(300, bank.getTotalAssets(), 1e-9);
    }

    @Test
    void addAccountNullThrowsException() {
        Bank bank = new Bank();
        assertThrows(IllegalArgumentException.class, () -> bank.addAccount(null));
    }

    @Test
    void totalAssetsCalculatedCorrectly() {
        Bank bank = new Bank();
        bank.addAccount(new BankAccount("1", "Alena", 100));
        bank.addAccount(new BankAccount("2", "Bob", 200));
        assertEquals(300, bank.getTotalAssets(), 1e-9);
    }

    @Test
    void transferSucceedsForValidAmount() {
        BankAccount from = new BankAccount("1", "A", 500);
        BankAccount to = new BankAccount("2", "B", 100);

        Bank bank = new Bank();
        bank.transfer(from, to, 200);

        assertEquals(300, from.getBalance(), 1e-9);
        assertEquals(300, to.getBalance(), 1e-9);
    }

    @Test
    void transferFailsForInsufficientBalanceAndDoesNotChangeBalances() {
        BankAccount from = new BankAccount("1", "A", 100);
        BankAccount to = new BankAccount("2", "B", 100);

        Bank bank = new Bank();

        assertThrows(IllegalArgumentException.class,
                () -> bank.transfer(from, to, 200));

        assertEquals(100, from.getBalance(), 1e-9);
        assertEquals(100, to.getBalance(), 1e-9);
    }
}