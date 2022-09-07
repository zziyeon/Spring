package com.kh.openData.svc;

import lombok.Data;

import java.util.List;

@Data
public class RfcOpenApi {
    private Header header;
    @Data       //(@Getter, @Setter 을 다 포함하는 것)
    static class Header {
        private String resultCode;
        private String resultMsg;
    }
    private Body body;
    @Data
    static class Body {
        private String pageIndex;
        private String numOfRows;
        private String pageNo;
        private String totalCount;

//        @Data
//        static class Data {
//            private List<Lists> Data;
//        }


        private List<Lists> data;
        @Data
        static class Lists{
            private String company;
            private double lat;
            private float lng;
            private String foodType;
            private String city;
            private String address;
            private String phoneNumber;
            private String mainMenu;
        }
    }
}


