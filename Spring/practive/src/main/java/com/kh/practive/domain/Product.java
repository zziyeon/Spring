package com.kh.practive.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private Long productId;     //상품아이디 PRODUCT_ID	NUMBER(10,0)
    private String pname;       //상품명 PNAME	VARCHAR2(30 BYTE)
    private Integer quantity;   //수량 QUANTITY	NUMBER(10,0)
    private Integer price;      //가격 PRICE	NUMBER(10,0)

    public Product(String pname, Integer quantity, Integer price) {
        this.pname = pname;
        this.quantity = quantity;
        this.price = price;
    }
}

