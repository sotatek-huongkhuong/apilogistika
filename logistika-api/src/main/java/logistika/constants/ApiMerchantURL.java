package logistika.constants;

public class ApiMerchantURL {

    private final static String BASE_URL="https://api.dev.logistika.com.my";
    public final static String ADDRESS_ID="id";
    public final static String URL_ADDRESS=BASE_URL+"/api/merchant/address";
    public final static String URL_UPDATE_ADDRESS=BASE_URL+"/api/merchant/address/{"+ ADDRESS_ID+"}";

}
