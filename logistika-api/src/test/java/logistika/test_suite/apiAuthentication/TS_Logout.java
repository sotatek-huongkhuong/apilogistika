package logistika.test_suite.apiAuthentication;

import logistika.base.Base_Test;
import logistika.microservices.apiAuthentication.logout.steps.LogoutSteps;
import org.testng.annotations.Test;

public class TS_Logout extends Base_Test {
    @Test
    public void TC001_successfulLogout()
    {
        LogoutSteps logoutSteps =  new LogoutSteps();
        logoutSteps.whenLogout()
                .verifyStatusCode(200)
                .verifyMessage("successfully logged out");

    }
    @Test
    public void TC002_logoutFailed()
    {
        LogoutSteps logoutSteps =  new LogoutSteps();
        logoutSteps.whenLogout()
                .verifyStatusCode(200)
                .verifyMessage("successfully logged out")
                .whenLogout()
                .verifyStatusCode(401)
                .verifyMessage("Unauthorized");

    }
}
