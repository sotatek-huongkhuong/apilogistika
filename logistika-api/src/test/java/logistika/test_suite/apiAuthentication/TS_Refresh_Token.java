package logistika.test_suite.apiAuthentication;

import logistika.base.Base_Test;
import logistika.constants.Account_Constans;
import logistika.microservices.apiAuthentication.refesh_token.steps.RefreshTokenSteps;
import org.testng.annotations.Test;

public class TS_Refresh_Token extends Base_Test {
    RefreshTokenSteps token_steps = new RefreshTokenSteps();

    @Test
    public void TC001_successfulRefreshToken() {

        token_steps.whenRefreshToken(Account_Constans.USERNAME_LOGISTIKA, Account_Constans.PASSWORD_LOGISTIKA)
                .verifyStatusCode(200)
                .verifyUserID(Account_Constans.USERID_LOGISTIKA);
    }

    @Test
    public void TC002_enterInvalidRefreshToken() {
        token_steps.whenRefreshToken("invalidToken")
                .verifyStatusCode(400)
                .verifyMessage("Invalid Refresh Token");
    }
}
