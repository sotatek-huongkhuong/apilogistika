package logistika.microservices.apiMerchant.createAddress.steps;

import logistika.constants.ApiMerchantURL;
import logistika.core.BaseAPI;
import logistika.microservices.apiMaster.mapping.transformTsToLgShipments.steps.TransformTsToLgShipmentsSteps;
import logistika.microservices.apiMerchant.createAddress.models.CreateAddressInput;

import static org.junit.Assert.assertEquals;

public class CreateAddressSteps extends BaseAPI {

    public CreateAddressSteps whenCreateAddress(String name, String phoneNumber, String address1, String address2, String postcode,String city,String state,String country,String pickupInstruction)
    {
        CreateAddressInput createAddressInput= new CreateAddressInput(name,phoneNumber,address1,address2,postcode,city,state,country,pickupInstruction);
        sendPost(ApiMerchantURL.URL_ADDRESS,createAddressInput);
        return this;
    }
    public CreateAddressSteps verifyResponse(String name, String phoneNumber, String address1, String address2, String postcode,String city,String state,String country,String pickupInstruction,String userId)
    {
        assertEquals(name,getJsonValue("name"));
        assertEquals(phoneNumber,getJsonValue("phoneNumber"));
        assertEquals(address1,getJsonValue("address1"));
        assertEquals(address2,getJsonValue("address2"));
        assertEquals(postcode,getJsonValue("postcode"));
        assertEquals(city,getJsonValue("city"));
        assertEquals(state,getJsonValue("state"));
        assertEquals(country,getJsonValue("country"));
        assertEquals(pickupInstruction,getJsonValue("pickupInstruction"));
        assertEquals(userId,getJsonValue("userId"));
        return this;
    }
    public CreateAddressSteps verifyStatusCode(int code)
    {
        validateStatusCode(code);
        return this;
    }
    public CreateAddressSteps verifyMessage(String message)
    {
        assertEquals(message,getJsonValue("message"));
        return this;
    }
}
