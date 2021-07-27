package logistika.microservices.apiMaster.mapping.syncTsConfig.steps;

import logistika.constants.ApiMasterURL;
import logistika.core.BaseAPI;

public class SyncTsConfigSteps extends BaseAPI {
    public SyncTsConfigSteps whenSyncTigerSheetConfig()
    {
        sendPost(ApiMasterURL.URL_SYNTSCONFIG);
        return this;
    }
    public SyncTsConfigSteps verifyStatusCode(int code)
    {
        validateStatusCode(code);
        return this;
    }
}
