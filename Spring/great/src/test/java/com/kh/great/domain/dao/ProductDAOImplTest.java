//package com.kh.great.domain.dao;
//
//import com.kh.great.domain.Product;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//@Slf4j
//class ProductDAOImplTest {
//  @Autowired
//  ProductDAO productDAO;
//
//
//  @DisplayName("상품등록")
//  void save() {
//    Product product = new Product();
//    product.setTitle("맛있는 딸기 케이크");
//    product.setPName("딸기 케이크");
//    product.setDeadlineTime("2022-09-17T21:10");
//    product.setQuantity(1);
//    product.setPrice(50000);
//
//    Product saveProduct = productDAO.save(product);
//    log.info("saveProduct = {}", saveProduct);
//}