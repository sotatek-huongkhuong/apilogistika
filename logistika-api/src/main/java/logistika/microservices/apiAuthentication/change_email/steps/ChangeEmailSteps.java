package logistika.microservices.apiAuthentication.change_email.steps;

import logistika.constants.ApiAuthenticationURL;
import logistika.core.BaseAPI;
import logistika.microservices.apiAuthentication.change_email.models.ChangeEmailInput;

import static org.junit.Assert.assertEquals;

public class ChangeEmailSteps extends BaseAPI {
    public ChangeEmailSteps whenResetPassword(String  user_name, String newEmail)
    {
        ChangeEmailInput change_email_input = new ChangeEmailInput(user_name, newEmail);
        sendPut(ApiAuthenticationURL.URL_CHANGE_EMAIL,change_email_input);
        return this;
    }
    public ChangeEmailSteps verifyStatusCode(int code) {
        validateStatusCode(code);
        return this;
    }
    public ChangeEmailSteps verifyMessage(String message) {
        assertEquals(getJsonValue("message"), message);
        return this;
    }
    public ChangeEmailSteps verifyError(String name) {
        assertEquals(getJsonValue("name"), name);
        return this;
    }
}
