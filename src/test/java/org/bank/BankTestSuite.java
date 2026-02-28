package org.bank;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        BankAccountTest.class,
        BankTest.class,
        BankParameterizedTest.class
})
public class BankTestSuite {
}