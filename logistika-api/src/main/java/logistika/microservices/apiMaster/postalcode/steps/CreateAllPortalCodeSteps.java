package logistika.microservices.apiMaster.postalcode.steps;

import logistika.constants.ApiMasterURL;
import logistika.core.BaseAPI;

public class CreateAllPortalCodeSteps extends BaseAPI {
    public CreateAllPortalCodeSteps whenGetCities()
    {
        sendPost(ApiMasterURL.URL_PORTALCODE);
        return this;
    }
    public CreateAllPortalCodeSteps verifyStatusCode(int code)
    {
        validateStatusCode(code);
        return this;
    }
}
