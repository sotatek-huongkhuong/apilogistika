package logistika.test_suite.apiAuthentication;

import logistika.base.Base_Test;
import logistika.constants.Account_Constans;
import logistika.core.Nosubject;
import logistika.microservices.apiAuthentication.reset_password.steps.ResetPasswordSteps;
import org.testng.annotations.Test;

public class TS_Reset_Password extends Base_Test {
    String confirmationcode="";
    @Test
    public void TC001_enterInvalidUsernameOrConfirmcode()
    {
        ResetPasswordSteps reset_password_steps = new ResetPasswordSteps();
        reset_password_steps.whenResetPassword("aaa","1111", Account_Constans.PASSWORD_LOGISTIKA,  Account_Constans.PASSWORD_LOGISTIKA)
                .verifyStatusCode(400)
                .verifyMessage("ExpiredCodeException")
                .verifyError("Bad Request");
    }

    @Test
    public void TC002_enterInvalidNewpassword()
    {
        ResetPasswordSteps reset_password_steps = new ResetPasswordSteps();
        //get confirmationcode
        confirmationcode= Nosubject.getConfirmCodeFromEmail();//"503364";//
        reset_password_steps.whenResetPassword(Account_Constans.USERID_LOGISTIKA,confirmationcode, "1234Aa!",  "1234Aa!")
                .verifyStatusCode(400)
                .verifyMessage( "[newPassword must be 8 or more characters with at least one number, one symbol, newPassword must be longer than or equal to 8 characters]")
                .verifyError("Bad Request");
    }
    @Test
    public void TC003_enterConfirmPasswordDoesNotMatchNewPassword()
    {
        ResetPasswordSteps reset_password_steps = new ResetPasswordSteps();
        reset_password_steps.whenResetPassword(Account_Constans.USERID_LOGISTIKA,confirmationcode, "1234luciAa!",  "1234luciAb!")
                .verifyStatusCode(400)
                .verifyMessage("[confirmPassword must be equal to newPassword]")
                .verifyError("Bad Request");
    }
    @Test
    public void TC004_passwordChangedSuccessfully()
    {
        ResetPasswordSteps reset_password_steps = new ResetPasswordSteps();
        confirmationcode= Nosubject.getConfirmCodeFromEmail();
        reset_password_steps.whenResetPassword(Account_Constans.USERID_LOGISTIKA,confirmationcode, "Lucikhuong2!",  "Lucikhuong2!")
                .verifyStatusCode(201)
                .verifyMessage("Password changed successfully.");
        confirmationcode= Nosubject.getConfirmCodeFromEmail();
        reset_password_steps.whenResetPassword(Account_Constans.USERID_LOGISTIKA,confirmationcode, "Lucikhuong1!",  "Lucikhuong1!")
                .verifyStatusCode(201)
                .verifyMessage("Password changed successfully.");


    }
}
