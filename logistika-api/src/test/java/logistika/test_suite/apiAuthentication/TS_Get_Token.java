package logistika.test_suite.apiAuthentication;

import logistika.base.Base_Test;
import logistika.constants.Account_Constans;
import logistika.microservices.apiAuthentication.steps.TokenSteps;
import org.testng.annotations.Test;

public class TS_Get_Token extends Base_Test {
    TokenSteps token_steps= new TokenSteps();

    @Test
    public void TC001_enterValidToken()
    {
        token_steps.setAuthorization(Account_Constans.USERNAME_LOGISTIKA,Account_Constans.PASSWORD_LOGISTIKA)
                .whenGetToken()
                .verifyStatusCode(200)
                .verifyMessage("Authorized");

    }
    @Test
    public void TC002_enterInvalidToken()
    {
        token_steps.setAuthorization("aaaa")
                .whenGetToken()
                .verifyStatusCode(401)
                .verifyMessage("Unauthorized");

    }
}
