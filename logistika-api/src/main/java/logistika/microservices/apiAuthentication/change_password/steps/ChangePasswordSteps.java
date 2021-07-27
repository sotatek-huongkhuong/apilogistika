package logistika.microservices.apiAuthentication.change_password.steps;

import io.restassured.response.Response;
import logistika.constants.ApiAuthenticationURL;
import logistika.core.BaseAPI;
import logistika.microservices.apiAuthentication.change_password.models.ChangePasswordInput;

import static org.junit.Assert.assertEquals;

public class ChangePasswordSteps extends BaseAPI {

    Response res;
    public ChangePasswordSteps whenChangePassword(String username, String password, String newPassword, String confirmPassword)
    {
        ChangePasswordInput change_password_input= new ChangePasswordInput(username,password,newPassword,confirmPassword);
        res= sendPut(ApiAuthenticationURL.URL_CHANGE_PASSWORD,change_password_input);
        return this;
    }
    public ChangePasswordSteps verifyStatusCode(int code) {
        validateStatusCode(code);
        return this;
    }
    public ChangePasswordSteps verifyMessage(String message) {
        assertEquals(getJsonValue("message"), message);
        return this;
    }
    public ChangePasswordSteps verifyIsSuccess(String isSuccess) {
        assertEquals(getJsonValue("isSuccess"), isSuccess);
        return this;
    }
    public ChangePasswordSteps verifyData(String data) {
        System.out.print(res.asString());
        assertEquals(data,getJsonValue("data") );
        return this;
    }
    public ChangePasswordSteps verifyError(String name) {
        assertEquals(getJsonValue("error"), name);
        return this;
    }
}
