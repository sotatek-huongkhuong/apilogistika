package logistika.microservices.apiAuthentication.steps;

import logistika.constants.ApiAuthenticationURL;
import logistika.core.BaseAPI;
import logistika.microservices.apiAuthentication.login.steps.LoginSteps;

import static org.junit.Assert.assertEquals;

public class TokenSteps extends BaseAPI {
    public TokenSteps setAuthorization(String username, String password) {
        removeHeaders();
        initReqSpec();
        LoginSteps loginSteps = new LoginSteps();
        String token = loginSteps.whenLogin(username, password)
                .getToken();
        removeHeaders();
        initReqSpec();
        setHeader("authorization", getJsonValue("id_token"));
        return this;
    }

    public TokenSteps setAuthorization(String token) {
        removeHeaders();
        setHeader("authorization", token);
        return this;
    }

    public TokenSteps whenGetToken() {
        sendGet(ApiAuthenticationURL.URL_TOKEN);
        return this;
    }

    public TokenSteps verifyStatusCode(int code) {
        validateStatusCode(code);
        return this;
    }

    public TokenSteps verifyMessage(String message) {
        assertEquals(getJsonValue("message"), message);
        return this;
    }
}
