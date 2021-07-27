package logistika.microservices.apiAuthentication.reset_password.steps;

import logistika.constants.ApiAuthenticationURL;
import logistika.core.BaseAPI;
import logistika.microservices.apiAuthentication.reset_password.models.ResetPasswordInput;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ResetPasswordSteps extends BaseAPI {
    public ResetPasswordSteps whenResetPassword(String user_name, String confirmation_code , String newPassword , String comfirmPassword)
    {
        ResetPasswordInput reset_password_input= new ResetPasswordInput(newPassword,comfirmPassword);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_name",user_name);
        map.put("confirmation_code",confirmation_code);
          sendPostWithParams(ApiAuthenticationURL.URL_RESET_PASSWORD,reset_password_input,map);
        return this;
    }
    public ResetPasswordSteps verifyStatusCode(int code) {
        validateStatusCode(code);
        return this;
    }
    public ResetPasswordSteps verifyMessage(String message) {
        assertEquals(getJsonValue("message"), message);
        return this;
    }
    public ResetPasswordSteps verifyError(String name) {
        assertEquals(getJsonValue("error"), name);
        return this;
    }
}
