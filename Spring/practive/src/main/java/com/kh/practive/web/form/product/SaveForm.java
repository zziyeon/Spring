package com.kh.practive.web.form.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaveForm {
    private String pname;       //상품명 PNAME	VARCHAR2(30 BYTE)
    private Integer quantity;   //수량 QUANTITY	NUMBER(10,0)
    private Integer price;      //가격 PRICE	NUMBER(10,0)
}