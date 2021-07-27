package logistika.test_suite.apiAuthentication;

import logistika.base.Base_Test;
import logistika.constants.Account_Constans;
import logistika.microservices.apiAuthentication.change_password.steps.ChangePasswordSteps;
import org.testng.annotations.Test;

public class TS_Change_Password extends Base_Test {
    ChangePasswordSteps change_password_steps= new ChangePasswordSteps();
    @Test
    public void TC001_changePasswordSuccessfully()
    {
        change_password_steps.whenChangePassword(Account_Constans.USERNAME_LOGISTIKA, Account_Constans.PASSWORD_LOGISTIKA,"Lucikhuong2!","Lucikhuong2!")
                .verifyStatusCode(200)
                .verifyData("SUCCESS");
        initReqSpec();
        loginSteps.whenLogin(Account_Constans.USERNAME_LOGISTIKA,"Lucikhuong2!");
        change_password_steps.whenChangePassword(Account_Constans.USERNAME_LOGISTIKA,"Lucikhuong2!",Account_Constans.PASSWORD_LOGISTIKA,Account_Constans.PASSWORD_LOGISTIKA)
                .verifyData("SUCCESS");
    }
    @Test
    public void TC002_enterIncorrectPassword()
    {
        change_password_steps.whenChangePassword(Account_Constans.USERNAME_LOGISTIKA, "incorrectPass","Lucikhuong2!","Lucikhuong2!")
                .verifyStatusCode(400)
                .verifyMessage("Incorrect username or password.")
                .verifyError("Bad Request");
    }
    @Test
    public void TC003_enterIncorrectUsername()
    {
        change_password_steps.whenChangePassword( Account_Constans.USERNAME_LOGISTIKA,"incorrectPass","Lucikhuong2!","Lucikhuong2!")
                .verifyStatusCode(400)
                .verifyMessage("Incorrect username or password.")
                .verifyError("Bad Request");
    }
    @Test
    public void TC004_enterInvalidNewPasword()
    {
        change_password_steps.whenChangePassword(Account_Constans.USERNAME_LOGISTIKA, Account_Constans.PASSWORD_LOGISTIKA,"Lucig2!","Lucig2!")
                .verifyStatusCode(400)
                .verifyMessage("[newPassword must be 8 or more characters with at least one number, one symbol, newPassword must be longer than or equal to 8 characters]")
                .verifyError("Bad Request")
                .whenChangePassword(Account_Constans.USERNAME_LOGISTIKA, Account_Constans.PASSWORD_LOGISTIKA,"Lucigaaaa","Lucigaaaa")
                .verifyStatusCode(400)
                .verifyMessage("[newPassword must be 8 or more characters with at least one number, one symbol]")
                .verifyError("Bad Request");

    }
    @Test
    public void TC005_enterConfirmPasswordDoesNotMatchNewPassword()
    {
        change_password_steps.whenChangePassword(Account_Constans.USERNAME_LOGISTIKA, Account_Constans.PASSWORD_LOGISTIKA,"Lucikhuong2!","Lucikhuong3!")
                .verifyStatusCode(400)
                .verifyMessage("[confirmPassword must be equal to newPassword]")
                .verifyError("Bad Request");
    }


}
