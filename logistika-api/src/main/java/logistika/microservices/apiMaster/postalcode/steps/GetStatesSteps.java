package logistika.microservices.apiMaster.postalcode.steps;

import logistika.constants.ApiMasterURL;
import logistika.core.BaseAPI;

public class GetStatesSteps  extends BaseAPI {
    public GetStatesSteps whenGetCities()
    {
        sendGet(ApiMasterURL.URL_GETSTATES);
        return this;
    }
    public GetStatesSteps verifyStatusCode(int code)
    {
        validateStatusCode(code);
        return this;
    }
}
