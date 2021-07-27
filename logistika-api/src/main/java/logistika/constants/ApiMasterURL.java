package logistika.constants;

public class ApiMasterURL {
    private final static String BASE_URL = "https://api.dev.logistika.com.my";

    //POSTALCODE
    public final static String URL_PORTALCODE = BASE_URL + "/api/master/postalCodes";
    public final static String URL_CREATEALLPORTALCODE = BASE_URL + "/api/master/postalCodes/postalCode";
    public final static String URL_GETCITIES = BASE_URL + "/api/master/postalCodes/cities";
    public final static String URL_GETSTATES = BASE_URL + "/api/master/postalCodes/states";
    public final static String URL_GETCOUNTRIES = BASE_URL + "/api/master/postalCodes/countries";
    public final static String URL_CREATEVOLUMEDATA = BASE_URL + "/api/master/volume";
    public final static String volumeType = "volumeType";
    public final static String URL_GETVOLUMEDATA = BASE_URL + "/api/master/volume/{" + volumeType + "}";

    //MAPPING
    public static final String URL_SYNTSCONFIG = BASE_URL + "/api/master/transform";
    public static final String URL_TRANSFORMTSTOLGSHIPMENTS = BASE_URL + "/api/master/transform/convertToLogistika";
    public static final String rowId = "rowId";
    public static final String URL_TRANSFORMLGTOTSSHIPMENTWITHROWID = BASE_URL + "/api/master/transform/convertToTigersheet/{" + rowId + "}";
    public static  final  String URL_TRANSFORMLGTOTSSHIPMENT=BASE_URL+"/api/master/transform/convertToTigersheet";

    //MAPING TEMPLATE
    public static final String URL_CREATETEMPLATE = BASE_URL + "/api/master/header/mapping-template";
    public static final String URL_GETLISTOFTEMPLATE = BASE_URL + "/api/master/header/mapping-template";
    public static final String TEMPLATEID = "templateid";
    public static final String URL_UPDATETEMPLATE = BASE_URL + "/api/master/header/mapping-template/{" + TEMPLATEID + "}";
    public static  final  String URL_GETTEMPLATEMAPPING=BASE_URL+"/api/master/header/mapping-template/{" + TEMPLATEID + "}";
    public static  final  String URL_DELETETEMPLATE=BASE_URL+"/api/master/header/mapping-template/{" + TEMPLATEID + "}";

}
