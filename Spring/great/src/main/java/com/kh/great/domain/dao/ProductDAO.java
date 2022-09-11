package com.kh.great.domain.dao;

import com.kh.great.domain.Product;

import java.util.List;

public interface ProductDAO {
    /**
     * 상품 등록
     *
     * @param product 상품정보
     * @return 등록된 상품 정보
     */
    int save(Product product);

    /**
     * 상품 조회
     * @param productNumber 상품 번호
     * @return  상품
     */
    Product findByNumber(Integer productNumber);

    /**
     * 상품 정보 수정
     * @param productNumber 수정할 상품 번호
     * @param product       수정할 상품 정보
     */
    void updatae(Integer productNumber, Product product);

    /**
     * 상품 삭제
     *
     * @param productNumber 삭제할 상품 번호
     * @return
     */
    int delete(Integer productNumber);

    /**
     * 상품 목록
     * @return  상품전체
     */
    List<Product> findAll();
}
