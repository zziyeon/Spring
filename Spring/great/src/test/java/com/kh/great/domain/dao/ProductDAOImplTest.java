package com.kh.great.domain.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ProductDAOImplTest {
  @Autowired
  private ProductDAO productDAO;

  private static Product testProduct;
  //등록
//  @Test
//  @DisplayName("상품등록")
//  void save() {
//    Product newProduct = new Product(44l, "여기가게", "맛좀 보시오", "딸기케이크","한식");
//
//    testProduct = productDAO.save(newProduct);
//    Assertions.assertThat(testProduct.getP_number()).isEqualTo(newProduct.getP_number());
//    Assertions.assertThat(testProduct.getStore_name()).isEqualTo(newProduct.getStore_name());
//    Assertions.assertThat(testProduct.getP_title()).isEqualTo(newProduct.getP_title());
//    Assertions.assertThat(testProduct.getP_name()).isEqualTo(newProduct.getP_name());
//    Assertions.assertThat(testProduct.getP_category()).isEqualTo(newProduct.getP_category());
//
//  }

//  @Test
//  @DisplayName("조회")
//  void findByProductNum() {
//    Long p_number= 11l;
//    Product findedProduct = productDAO.findByProductNum(p_number);
//    log.error("{}=>", findedProduct.getPNumber());
//    Assertions.assertThat(findedProduct.getPNumber()).isEqualTo(11);
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