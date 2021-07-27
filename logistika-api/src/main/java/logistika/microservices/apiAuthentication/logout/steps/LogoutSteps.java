package logistika.microservices.apiAuthentication.logout.steps;

import logistika.constants.ApiAuthenticationURL;
import logistika.core.BaseAPI;

import static org.junit.Assert.assertEquals;

public class LogoutSteps extends BaseAPI {
    public LogoutSteps whenLogout() {

        sendGet(ApiAuthenticationURL.URL_LOGOUT);
        return this;
    }

    public LogoutSteps verifyStatusCode(int code) {
        validateStatusCode(code);
        return this;
    }
    public LogoutSteps verifyMessage(String message) {
        assertEquals(getJsonValue("message"), message);
        return this;
    }

    public LogoutSteps verifyError(String name) {
        assertEquals(getJsonValue("name"), name);
        return this;
    }
}
