package com.kh.practive.web.form.product;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SaveForm {
    @NotBlank
    private String pname;       //상품명 PNAME	VARCHAR2(30 BYTE)
    @NotNull
    @Max(999999999)
    private Integer quantity;   //수량 QUANTITY	NUMBER(10,0)
    @NotNull
    @Max(999999999)
    private Integer price;      //가격 PRICE	NUMBER(10,0)
}