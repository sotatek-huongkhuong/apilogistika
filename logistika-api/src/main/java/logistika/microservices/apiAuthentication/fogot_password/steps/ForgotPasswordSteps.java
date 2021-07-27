package logistika.microservices.apiAuthentication.fogot_password.steps;

import logistika.constants.ApiAuthenticationURL;
import logistika.core.BaseAPI;
import logistika.microservices.apiAuthentication.fogot_password.models.ForgotPasswordInput;

import static org.junit.Assert.assertEquals;

public class ForgotPasswordSteps extends BaseAPI {
    public ForgotPasswordSteps whenForgotPassword(String username)
    {
        ForgotPasswordInput forgot_passwordInput= new ForgotPasswordInput();
        forgot_passwordInput.setUsername(username);
         sendPost(ApiAuthenticationURL.URL_FORGOT_PASSWORD,forgot_passwordInput);
        return this;
    }
    public ForgotPasswordSteps verifyStatusCode(int status)
    {
        validateStatusCode(status);
        return this;
    }
    public ForgotPasswordSteps verifyMessage(String message)
    {
        assertEquals(getJsonValue("message"), message);
        return this;
    }
    public ForgotPasswordSteps verifyError(String error)
    {
        assertEquals(getJsonValue("error"), error);
        return this;
    }

}
