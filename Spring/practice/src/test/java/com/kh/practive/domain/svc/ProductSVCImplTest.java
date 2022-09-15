package com.kh.practive.domain.svc;

import com.kh.practive.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductSVCImplTest {

    @Autowired
    private ProductSVC productSVC;
    private static Product product;
    @DisplayName("상품 등록")
    @Order(1)
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
    @Order(2)
    void findById() {
        Product findedProduct = productSVC.findById(product.getProductId());
        Assertions.assertThat(findedProduct).isEqualTo(product);
    }
    @Test
    @DisplayName("상품 수정")
    @Order(3)
    void update() {
        String pname = "바나나푸딩";
        Integer quantity = 9;
        Integer price = 9000;

        //수정 정보
        Product product1 = new Product();
        product1.setPname(pname);
        product1.setQuantity(quantity);
        product1.setPrice(price);

        //수정
        productSVC.update(product.getProductId(), product1);
        //조회
        Product findedProduct=productSVC.findById(product.getProductId());

        Assertions.assertThat(findedProduct.getPname()).isEqualTo(pname);
        Assertions.assertThat(findedProduct.getQuantity()).isEqualTo(quantity);
        Assertions.assertThat(findedProduct.getPrice()).isEqualTo(price);
    }
//    @Test
//    @DisplayName("상품 삭제")
//    @Order(5)
//    void delete() {
//        productSVC.delete(product.getProductId());
//        Product findedProduct = productSVC.findById(product.getProductId());
//        Assertions.assertThat(findedProduct).isNull();
//    }
    @Test
    @DisplayName("상품 목록")
    @Order(6)
    void findAll() {
        List<Product> list = productSVC.findAll();
        Product findedProduct = productSVC.findById(product.getProductId());
        Assertions.assertThat(list).containsAnyOf(findedProduct);
    }

}