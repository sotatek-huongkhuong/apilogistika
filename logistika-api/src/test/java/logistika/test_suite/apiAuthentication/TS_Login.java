package logistika.test_suite.apiAuthentication;

import logistika.base.Base_Test;
import logistika.constants.Account_Constans;
import logistika.microservices.apiAuthentication.login.steps.LoginSteps;
import org.testng.annotations.Test;
public class TS_Login extends Base_Test {

    @Test
    public void TC001_doNotEnterPassword() {
        loginSteps.whenLogin(Account_Constans.USERNAME_LOGISTIKA, "")
                .verifyStatusCode(400)
                .verifyError("Bad Request")
                .verifyMessage("[Password must be 8 or more characters with at least one number, one symbol, password must be longer than or equal to 8 characters, password should not be empty]")
                .printmessage();
    }

    @Test
    public void TC002_enterWrongPassword() {
        loginSteps.whenLogin(Account_Constans.USERNAME_LOGISTIKA, "Logita1@")
                .verifyStatusCode(400)
                .verifyMessage("Incorrect username or password.")
                .verifyError("Bad Request");
    }

    @Test
    public void TC003_enterPasswordWithLengthLessThan8() {
        loginSteps.whenLogin(Account_Constans.USERNAME_LOGISTIKA, "Logisti")
                .verifyStatusCode(400)
                .verifyError("Bad Request")
                .verifyMessage("[Password must be 8 or more characters with at least one number, one symbol, password must be longer than or equal to 8 characters]")
                .printmessage();
    }

    @Test
    public void TC004_loginSuccessfully() {
        loginSteps.whenLogin(Account_Constans.USERNAME_LOGISTIKA, Account_Constans.PASSWORD_LOGISTIKA)
                .verifyStatusCode(201)
                .verifyTokenType("Bearer")
                .verifyUserID(Account_Constans.USERID_LOGISTIKA).printmessage();
    }

    @Test
    public void TC005_enterDoNotExistEmail() {
        loginSteps.whenLogin("anyemai@gmail.com", Account_Constans.PASSWORD_LOGISTIKA)
                .verifyStatusCode(400)
                .verifyMessage("Incorrect username or password.")
                .verifyError("Bad Request");
    }

    @Test
    public void TC006_doNotEnterEmailAndPassword() {
        loginSteps.whenLogin("", "")
                .verifyStatusCode(400)
                .verifyMessage("[username must be an email, username should not be empty, Password must be 8 or more characters with at least one number, one symbol, password must be longer than or equal to 8 characters, password should not be empty]")
                .printmessage();
    }
    @Test
    public void TC007_enterInvalidEmail()
    {
        loginSteps.whenLogin("qqqqqqaaaaa", Account_Constans.PASSWORD_LOGISTIKA)
                .verifyStatusCode(400)
                .verifyError("Bad Request")
                .verifyMessage("[username must be an email]")
                .printmessage();
    }
}
