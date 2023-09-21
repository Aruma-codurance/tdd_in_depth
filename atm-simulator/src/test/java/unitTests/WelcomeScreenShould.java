package unitTests;

import com.codurance.atm.account.Account;
import com.codurance.atm.account.AccountService;
import com.codurance.atm.infrastructure.CliPrompt;
import com.codurance.atm.screens.Screen;
import com.codurance.atm.screens.WelcomeScreen;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WelcomeScreenShould {

    @Mock private CliPrompt cliPrompt;
    @Mock private AccountService accountService;


    @Test public void
    show_transactions_screen() {
        //Setup
        when(cliPrompt.accountNumber()).thenReturn("123456");
        when(cliPrompt.pin()).thenReturn("789012");
        when(accountService.findBy("123456","789012"))
                .thenReturn(new Account("123456", 0));

        //Action
        WelcomeScreen welcomeScreen = new WelcomeScreen(cliPrompt, accountService);
        Screen transaction = welcomeScreen.show();
        Screen withdraw = transaction.show();

        //Assertion
        assertNull(withdraw.show());
    }

}
