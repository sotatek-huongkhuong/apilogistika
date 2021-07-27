package logistika.microservices.apiMaster.volume.steps;

import logistika.constants.ApiMasterURL;
import logistika.core.BaseAPI;
import logistika.microservices.apiMaster.postalcode.steps.PortalCodeSteps;

import static org.junit.Assert.assertEquals;

public class GetVolumeDataSteps extends BaseAPI {
    public GetVolumeDataSteps whenGetVolumeData(String volumeType)
    {
        sendGet(ApiMasterURL.URL_GETVOLUMEDATA,ApiMasterURL.volumeType,volumeType);
        return this;
    }

    public GetVolumeDataSteps verifyID(String id)
    {
        assertEquals(getJsonValue("_id"), id);
        return this;
    }
    public GetVolumeDataSteps verifyVolumeType(String volumeType)
    {
        assertEquals(getJsonValue("volumeType"), volumeType);
        return this;

    }
    public GetVolumeDataSteps verifyItemWeight(String weight)
    {
        assertEquals(getJsonValue("itemWeight"), weight);
        return this;
    }

}
