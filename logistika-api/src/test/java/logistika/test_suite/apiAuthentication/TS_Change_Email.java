package logistika.test_suite.apiAuthentication;

import logistika.base.Base_Test;
import logistika.constants.Account_Constans;
import logistika.microservices.apiAuthentication.change_email.steps.ChangeEmailSteps;
import org.testng.annotations.Test;

public class TS_Change_Email extends Base_Test {
    ChangeEmailSteps change_email_steps = new ChangeEmailSteps();
    @Test
    public void TC001_enterInvalidNewEmail() {
        change_email_steps.whenResetPassword(Account_Constans.USERNAME_LOGISTIKA, "huongkhuong")
                .verifyStatusCode(400)
                .verifyMessage("newEmail must be an email")
                .whenResetPassword(Account_Constans.USERNAME_LOGISTIKA, "huongkhuong@gmail")
                .verifyStatusCode(400)
                .verifyMessage("newEmail must be an email")
                .whenResetPassword(Account_Constans.USERNAME_LOGISTIKA, "huongkhuong1gmail.com")
                .verifyStatusCode(400)
                .verifyMessage("newEmail must be an email");
    }

    @Test
    public void TC002_enterUsernameDoNotExistInDB() {
        change_email_steps.whenResetPassword("huongkhong1@gmail.com", "huongkhuong.it@gmail.com")
                .verifyStatusCode(400)
                .verifyMessage("username is not exist");
    }

    @Test
    public void TC003_successfulChangeEmail() {
        change_email_steps.whenResetPassword(Account_Constans.USERNAME_LOGISTIKA, "huongkhuong.it@gmail.com")
                .verifyStatusCode(200)
                .verifyMessage("Email has changed successfully");
        loginSteps.whenLogin("huongkhuong.it@gmail.com",Account_Constans.PASSWORD_LOGISTIKA);
        change_email_steps.whenResetPassword("huongkhuong.it@gmail.com",Account_Constans.USERNAME_LOGISTIKA)
                .verifyStatusCode(200)
                .verifyMessage("Email has changed successfully");
    }

}
