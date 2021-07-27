package logistika.microservices.apiMerchant.getListAddress.models;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class GetListAddressOutput {
    private String addressId,name,phoneNumber,address1,address2,postcode,city,state,pickupInstruction,userId;
}
