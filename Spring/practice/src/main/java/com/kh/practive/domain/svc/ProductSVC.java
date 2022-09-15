package com.kh.practive.domain.svc;

import com.kh.practive.domain.Product;

import java.util.List;

public interface ProductSVC {
    /**
     * 상품 등록
     * @param product 상품 정보
     * @return 등록된 상품 정보
     */
    Product save(Product product);

    /**
     * 상품조회
     * @param productId 조회할 상품 아이디
     * @return 상품 정보
     */
    Product findById(Long productId);

    /**
     * 상품 정보 수정
     * @param productId 수정할 상품 아이디
     * @param product 수정할 상품 정보
     */
    int update(Long productId, Product product);

    /**
     * 상품 삭제
     * @param productId 삭제할 상품 아이디
     */
    int delete(Long productId);

    /**
     * 상품 목록
     * @return 등록된 상품 목록
     */
    List<Product> findAll();

}
