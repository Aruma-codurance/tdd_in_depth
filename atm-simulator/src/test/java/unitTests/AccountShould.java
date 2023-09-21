package unitTests;

import com.codurance.atm.account.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountShould {

    private Account account;

    @BeforeEach
    void setUp(){
        account = new Account( "123456", 1000);
    }
    @Test public void
    return_the_account_number() {
        assertEquals("123456", account.accountNumber());
    }

    @Test public void
    return_the_account_balance() {
        assertEquals("1000", account.balance());
    }
}
