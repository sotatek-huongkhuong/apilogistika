package logistika.microservices.apiMaster.mapping.transformTsToLgShipments.steps;

import logistika.constants.ApiMasterURL;
import logistika.core.BaseAPI;
import logistika.microservices.apiMaster.mapping.syncTsConfig.steps.SyncTsConfigSteps;
import logistika.microservices.apiMaster.mapping.transformTsToLgShipments.model.TransformTsToLgShipmentsInput;

import static org.junit.Assert.assertEquals;

public class TransformTsToLgShipmentsSteps extends BaseAPI {
    public  TransformTsToLgShipmentsSteps whenTransformTsToLgShipments(String column_173,String column_184,String column_431,String column_392,String column_393 )
    {
        TransformTsToLgShipmentsInput transformTsToLgShipmentsInput=new TransformTsToLgShipmentsInput(column_173,column_184,column_431,column_392,column_393);
        sendPost(ApiMasterURL.URL_TRANSFORMTSTOLGSHIPMENTS,transformTsToLgShipmentsInput);
        return this;
    }
    public TransformTsToLgShipmentsSteps verifyStatusCode(int code)
    {
        validateStatusCode(code);
        return this;
    }
    public  TransformTsToLgShipmentsSteps verifyResponseBody(String column_173,String column_184,String column_431,String column_392,String column_393)
    {
        assertEquals(column_173,getJsonValue("shipmentId"));
        assertEquals(column_184,getJsonValue("workflowStatus"));
        assertEquals(column_431,getJsonValue("workflowStatusForUser"));
        assertEquals(column_392,getJsonValue("senderAddress1"));
        assertEquals(column_393,getJsonValue("senderAddress2"));
        return this;
    }
}
