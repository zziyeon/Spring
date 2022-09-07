package com.kh.openData.api;

import com.kh.openData.svc.ApiExplorer;
import com.kh.openData.svc.FaciReq;
import com.kh.openData.svc.RfcOpenApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/pub")
@RequiredArgsConstructor
public class ApiPubDateController {
    private final ApiExplorer apiExplorer;

    @GetMapping(value="/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public RfcOpenApi getXMLData() {

        RfcOpenApi res = apiExplorer.apiCall();
        log.info("res={}", res);
        return res;
    }

    @GetMapping(value="/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public RfcOpenApi getJsonData(@RequestParam("faciNm") String faciNm) {

        FaciReq faciReq = new FaciReq();

        faciReq.setPerPage("10");     //perPage 페이지 크기	10	0	1	페이지 크기(기본20)
        faciReq.setPageIndex("1");	//pageIndex 시작 페이지	10	0	0	시작 페이지(기본1)
        faciReq.setCity(faciNm);	    //city 시군구	10	0	중구	시군구


        RfcOpenApi res = apiExplorer.apiCall();
        log.info("res={}", res);
        return res;
    }

}
