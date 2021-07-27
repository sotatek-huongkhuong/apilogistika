package logistika.test_suite.apiAuthentication;

import logistika.base.Base_Test;
import logistika.constants.Account_Constans;
import logistika.microservices.apiAuthentication.fogot_password.steps.ForgotPasswordSteps;
import org.testng.annotations.Test;

public class TS_Forgot_Password  extends Base_Test {
    ForgotPasswordSteps forgot_password_steps = new ForgotPasswordSteps() ;
    @Test
    public void TC001_enterInvalidEmail()
    {
        forgot_password_steps.whenForgotPassword("huongkhuong")
                .verifyStatusCode(400)
                .verifyMessage("[username must be an email]")
                .verifyError("Bad Request");
    }
    @Test
    public void TC002_enterEmailDoNotExistInDB()
    {
        forgot_password_steps.whenForgotPassword("huongkhuong@gmail.com")
                .verifyStatusCode(400)
                .verifyMessage("username = huongkhuong@gmail.com not found.")
                .verifyError("Bad Request");
    }
    @Test
    public void TC003_entervalidEmailAndExistInDB()
    {
        forgot_password_steps.whenForgotPassword(Account_Constans.USERNAME_LOGISTIKA)
                .verifyStatusCode(201)
                .verifyMessage("Check your email for reset instructions");
    }
}
