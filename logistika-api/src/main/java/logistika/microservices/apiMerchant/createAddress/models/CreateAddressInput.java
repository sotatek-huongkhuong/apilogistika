package logistika.microservices.apiMerchant.createAddress.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateAddressInput {
    private String name,phoneNumber,address1,address2,postcode,city,state,country,pickupInstruction;

}
