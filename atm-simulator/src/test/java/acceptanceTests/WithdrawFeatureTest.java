package acceptanceTests;

import com.codurance.atm.account.Account;
import com.codurance.atm.account.AccountService;
import com.codurance.atm.infrastructure.CliPrompt;
import com.codurance.atm.infrastructure.Printer;
import com.codurance.atm.screens.Screen;
import com.codurance.atm.screens.WelcomeScreen;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WithdrawFeatureTest {

    @Mock private CliPrompt cliPrompt;

    @Test public void
    withdraw_money_from_account_and_update_balance() {
        Account account = new Account("123456", 100);
        when(cliPrompt.accountNumber()).thenReturn("123456");
        when(cliPrompt.pin()).thenReturn("123456");
        AccountService accountService = new AccountService();
        accountService.findBy("123456","123456");
        WelcomeScreen welcomeScreen = new WelcomeScreen(cliPrompt,accountService);
        Screen transaction = welcomeScreen.show();
        Screen withdraw = transaction.show();
        account.wihdraw(50);

        assertEquals("Your current balance is 50", withdraw.show());

    }
}
