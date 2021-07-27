package logistika.microservices.apiMaster.volume.steps;

import logistika.constants.ApiMasterURL;
import logistika.core.BaseAPI;

public class CreateVolumeDataSteps extends BaseAPI {
    public CreateVolumeDataSteps whenCreateVolumeData()
    {
        sendGet(ApiMasterURL.URL_PORTALCODE);
        return this;
    }

    public CreateVolumeDataSteps verifyStatusCode(int code)
    {
        validateStatusCode(code);
        return this;
    }
}
