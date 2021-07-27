package logistika.base;

import io.restassured.RestAssured;
import logistika.constants.Account_Constans;
import logistika.core.BaseAPI;
import logistika.microservices.apiAuthentication.login.steps.LoginSteps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base_Test { ;
protected LoginSteps loginSteps = new LoginSteps();
    @BeforeClass(alwaysRun = true)
    public void initReqSpec(){

    }

    @BeforeMethod
    public void BeforeMethod()
    {
        try
        {
            BaseAPI.initReqSpec();
            loginSteps.whenLogin(Account_Constans.USERNAME_LOGISTIKA,Account_Constans.PASSWORD_LOGISTIKA);
        }catch(Exception E)
        {

        }
    }

    @AfterSuite(alwaysRun = true)
    public void postconditions() {
        //AllureUtils.addAllureProperties();
        RestAssured.reset();
    }
}
