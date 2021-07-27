package logistika.microservices.apiAuthentication.login.steps;

import io.restassured.response.Response;
import logistika.constants.ApiAuthenticationURL;
import logistika.core.BaseAPI;
import logistika.microservices.apiAuthentication.login.models.LoginInput;

import static org.junit.Assert.assertEquals;

public class LoginSteps extends BaseAPI {

   // Response res;
    public LoginSteps whenLogin(String username, String  password) {
        removeHeaders();
        LoginInput login_input= new LoginInput(username,password);
        sendPost(ApiAuthenticationURL.URL_LOGIN, login_input);
        setHeader("authorization", getJsonValue("id_token"));
        return this;
    }

    public LoginSteps verifyStatusCode(int statuscode) {

        validateStatusCode(statuscode);
        return this;
    }

    public String getToken() {
      //  System.out.print(res.asString());
        return getJsonValue("id_token");
    }
    public String getValueByField(String fieldName)
    {
        return getJsonValue(fieldName);
    }

    public LoginSteps verifyTokenType(String tokenType) {
        assertEquals(getJsonValue("token_type"), tokenType);
        return this;
    }

    public LoginSteps verifyMessage(String Message) {
        assertEquals(getJsonValue("message"), Message);
        return this;
    }
    public void printmessage()
    {
        System.out.print(getJsonValue("message"));
    }

    public LoginSteps verifyError(String error) {
        assertEquals(getJsonValue("error"), error);
        return this;
    }

    public LoginSteps verifyUserID(String user_id) {
        assertEquals(getJsonValue("user_id"), user_id);
        return this;
    }
}
