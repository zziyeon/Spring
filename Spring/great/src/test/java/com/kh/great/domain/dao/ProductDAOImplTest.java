package com.kh.great.domain.dao;

import com.kh.great.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ProductDAOImplTest {
  @Autowired
  private ProductDAO productDAO;

  private static Product testProduct;
  //등록
  @Test
  @DisplayName("상품등록")
  void save() {
    Product newProduct = new Product(1l, "여기가게", "맛좀 보시오", "딸기케이크");

    testProduct = productDAO.save(newProduct);
    Assertions.assertThat(testProduct.getP_number()).isEqualTo(newProduct.getP_number());
    Assertions.assertThat(testProduct.getStore_name()).isEqualTo(newProduct.getStore_name());
    Assertions.assertThat(testProduct.getP_title()).isEqualTo(newProduct.getP_title());
    Assertions.assertThat(testProduct.getP_name()).isEqualTo(newProduct.getP_name());

  }

//  @Test
//  @DisplayName("조회")
//  void findByProductNum() {
//
//    Long p_number=33l;
//    Product findedProduct = productDAO.findByProductNum(p_number);
//    Assertions.assertThat(findedProduct.getP_number()).isEqualTo("33");
//    log.info("findedProduct={}", findedProduct);
//  }

  @Test
  void update() {
  }

  @Test
  void findAll() {
  }

  @Test
  void deleteByProductNum() {
  }
}