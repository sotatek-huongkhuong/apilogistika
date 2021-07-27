package logistika.microservices.apiMerchant.getListAddress.steps;

import logistika.constants.ApiMerchantURL;
import logistika.core.BaseAPI;

public class GetListAddressSteps extends BaseAPI {
    public void whenGetListAddress()
    {
        sendGet(ApiMerchantURL.URL_ADDRESS);
    }
    public void verifyStatusCode(int code)
    {
        validateStatusCode(code);
    }
}
