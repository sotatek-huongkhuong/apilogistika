package logistika.microservices.apiMaster.postalcode.steps;

import logistika.constants.ApiMasterURL;
import logistika.core.BaseAPI;

public class GetCountriesSteps extends BaseAPI {
    public GetCountriesSteps whenGetCities()
    {
        sendGet(ApiMasterURL.URL_GETCOUNTRIES);
        return this;
    }
    public GetCountriesSteps verifyStatusCode(int code)
    {
        validateStatusCode(code);
        return this;
    }
}
