package logistika.microservices.apiMaster.postalcode.steps;

import logistika.constants.ApiMasterURL;
import logistika.core.BaseAPI;

public class GetCitiesSteps extends BaseAPI {
    public GetCitiesSteps whenGetCities()
    {
        sendGet(ApiMasterURL.URL_GETCITIES);
        return this;
    }
    public GetCitiesSteps verifyStatusCode(int code)
    {
        validateStatusCode(code);
        return this;
    }
}
