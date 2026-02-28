package org.bank;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        accounts.add(account);
    }

    public double getTotalAssets() {
        return accounts.stream()
                .mapToDouble(BankAccount::getBalance)
                .sum();
    }

    public void transfer(BankAccount from, BankAccount to, double amount) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Accounts cannot be null");
        }
        from.withdraw(amount);
        to.deposit(amount);
    }
}