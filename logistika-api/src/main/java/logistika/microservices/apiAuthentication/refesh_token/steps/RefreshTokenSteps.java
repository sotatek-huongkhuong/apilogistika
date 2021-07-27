package logistika.microservices.apiAuthentication.refesh_token.steps;

import logistika.constants.ApiAuthenticationURL;
import logistika.core.BaseAPI;
import logistika.microservices.apiAuthentication.login.steps.LoginSteps;
import logistika.microservices.apiAuthentication.refesh_token.models.RefreshTokenInput;

import static org.junit.Assert.assertEquals;

public class RefreshTokenSteps extends BaseAPI {


    public RefreshTokenSteps whenRefreshToken(String refreshToken) {
        RefreshTokenInput refresh_token_input = new RefreshTokenInput(refreshToken);
         sendPost(ApiAuthenticationURL.URL_REFRESH_TOKEN, refresh_token_input);
        return this;
    }
    public RefreshTokenSteps whenRefreshToken(String username, String password) {
        LoginSteps loginSteps= new LoginSteps();
        String refreshToken= loginSteps.whenLogin(username,password).getValueByField("refresh_token");
        RefreshTokenInput refresh_token_input = new RefreshTokenInput(refreshToken);
         sendPost(ApiAuthenticationURL.URL_REFRESH_TOKEN, refresh_token_input);
        return this;
    }

    public RefreshTokenSteps verifyStatusCode(int statuscode) {
        validateStatusCode(statuscode);
        return this;
    }

    public RefreshTokenSteps verifyMessage(String userid) {
        assertEquals(getJsonValue("message"), userid);
        return this;
    }
    public RefreshTokenSteps verifyUserID(String Message) {
        assertEquals(getJsonValue("user_id"), Message);
        return this;
    }

    public RefreshTokenSteps verifyError(String error) {
        assertEquals(getJsonValue("error"), error);
        return this;
    }

}
