package org.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void totalAssetsCalculatedCorrectly() {
        Bank bank = new Bank();
        BankAccount a1 = new BankAccount("1", "Alena", 100);
        BankAccount a2 = new BankAccount("2", "Bob", 200);

        bank.addAccount(a1);
        bank.addAccount(a2);

        assertEquals(300, bank.getTotalAssets());
    }

    @Test
    void transferSuccess() {
        BankAccount from = new BankAccount("1", "A", 500);
        BankAccount to = new BankAccount("2", "B", 100);

        Bank bank = new Bank();
        bank.transfer(from, to, 200);

        assertEquals(300, from.getBalance());
        assertEquals(300, to.getBalance());
    }

    @Test
    void transferInsufficientBalance() {
        BankAccount from = new BankAccount("1", "A", 100);
        BankAccount to = new BankAccount("2", "B", 100);

        Bank bank = new Bank();

        assertThrows(IllegalArgumentException.class,
                () -> bank.transfer(from, to, 200));

        assertEquals(100, from.getBalance());
        assertEquals(100, to.getBalance());
    }
}