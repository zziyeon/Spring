package com.kh.practive.domain.svc;

import com.kh.practive.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
@Slf4j

class ProductSVCImplTest {

    @Autowired
    private ProductSVC productSVC;
    private static Product product;


    @Test
    @DisplayName("상품 번호 생성")
    @Order(1)
    void generatePid() {

    }

    @DisplayName("상품 등록")
    @Order(2)
    @Test
    void save() {
        Product newProduct = new Product("딸기 케이크",3,6500);
        product = productSVC.save(newProduct);
        Assertions.assertThat(product.getPname()).isEqualTo(newProduct.getPname());
        Assertions.assertThat(product.getQuantity()).isEqualTo(newProduct.getQuantity());
        Assertions.assertThat(product.getPrice()).isEqualTo(newProduct.getPrice());
    }

    @Test
    @DisplayName("상품 조회")
    @Order(3)
    void findById() {
        Product findedProduct = productSVC.findById(product.getProductId());
        Assertions.assertThat(findedProduct).isEqualTo(product);
    }

    @Test
    @DisplayName("상품 수정")
    @Order(4)
    void update() {
    }

    @Test
    @DisplayName("상품 삭제")
    @Order(5)
    void delete() {
    }

    @Test
    @DisplayName("상품 목록")
    @Order(6)
    void findAll() {
    }

}