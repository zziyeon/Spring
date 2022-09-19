package com.kh.great.web.form.product;

import lombok.Data;

@Data
public class SaveForm {
  private Long p_number;
//    private Long owner_number;       //점주고객번호    OWNER_NUMBER	NUMBER(6,0)
    private String store_name;       //가게명    STORE_NAME	VARCHAR2(60 BYTE)
    private String p_title;          //상품 제목    P_TITLE	VARCHAR2(90 BYTE)
    private String p_name;           //상품명    P_NAME	VARCHAR2(60 BYTE)
//    private String deadline_time;    //마감일자    DEADLINE_TIME	DATE
//    private String p_category;      //업종카테고리    CATEGORY	VARCHAR2(17 BYTE)
//    private Integer total_count;     //총수량    TOTAL_COUNT	NUMBER(5,0)
//    private Integer normal_price;    //정상가    NORMAL_PRICE	NUMBER(8,0)
//    private Integer sale_price;      //할인가    SALE_PRICE	NUMBER(8,0)
//    private Integer discount_rate;   //할인율    DISCOUNT_RATE	NUMBER(2,0)
//    private Integer payment_option;  //결제방식    PAYMENT_OPTION	NUMBER(1,0)
//    private String detail_info;    //상품설명    DETAIL_INFO	CLOB
}
