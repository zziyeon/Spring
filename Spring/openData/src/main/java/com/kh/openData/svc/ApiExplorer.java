package com.kh.openData.svc;

public interface ApiExplorer {
    RfcOpenApi apiCall();
    RfcOpenApi apiCall(FaciReq faciReq);
}
