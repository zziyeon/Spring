package com.kh.great.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Clob;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer productNumber;      //상품번호  P_NUMBER	VARCHAR2(4 BYTE)	No
    private Integer owenerNumber;       //점주번호  OWNER_NUMBER	NUMBER(6,0)	No
    private String storeName;           //가게명   STORE_NAME	VARCHAR2(30 BYTE)	No
    private String title;               //글제목   P_TITLE	VARCHAR2(300 BYTE)	No
    private String pName;               //상품명   P_NAME	VARCHAR2(30 BYTE)	No
    private LocalDateTime deadlineTime; //마감시간  DEADLINE_TIME	DATE	Yes
    private String category;            //업종 카테고리   CATEGORY	VARCHAR2(17 BYTE)	No
    private Integer totalCount;         //총수량   TOTAL_COUNT	NUMBER(5,0)	No	0
    private Integer remainCount;        //남은 수량 REMAIN_COUNT	NUMBER(5,0)	Yes	"0
    private Integer normalPrice;        //정상가   NORMAL_PRICE	NUMBER(8,0)	No
    private Integer salePrice;          //할인가   SALE_PRICE	NUMBER(8,0)	No	0
    private Integer discountRate;       //할인율   DISCOUNT_RATE	NUMBER(2,0)	Yes	"0
    private Integer paymentOption;      //결제 방식 PAYMENT_OPTION	NUMBER(1,0)	No	2
    private Clob detailInfo;            //상세설명  DETAIL_INFO	CLOB	Yes
    private LocalDateTime udate;        //수정일(등록일)   UPDATE_DATE	DATE	Yes	"sysdate
    private String pStatus;             //판매 상태 P_STATUS	NUMBER(1,0)	No	0
}
