package logistika.microservices.apiMaster.postalcode.steps;

import logistika.constants.ApiMasterURL;
import logistika.core.BaseAPI;

public class PortalCodeSteps extends BaseAPI {
    public PortalCodeSteps whenGetPortalCode()
    {
        sendGet(ApiMasterURL.URL_PORTALCODE);
        return this;
    }

    public PortalCodeSteps verifyStatusCode(int code)
    {
        validateStatusCode(code);
        return this;
    }
}
