package com.kh.great.domain.svc;

import com.kh.great.domain.dao.ProductDAO;
import com.kh.great.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductSVCImpl implements ProductSVC {
    private final ProductDAO productDAO;

    @Override
    public Long generatePnum() {
        return productDAO.generatePnum();
    }

    //상품 등록
    @Override
    public Product save(Product product) {
        Long generatePnum= productDAO.generatePnum();
        product.setP_number(generatePnum);
        productDAO.save(product);

        return productDAO.findByProductNum(generatePnum);
    }
    //상품 조회
    @Override
    public Product findByProductNum(Long pNum) {
        return productDAO.findByProductNum(pNum);
    }
    //상품 수정
    @Override
    public int update(Long pNum, Product product) {
        return productDAO.update(pNum, product);
    }
    //상품 목록
    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }
    //상품 삭제
    @Override
    public int deleteByProductNum(Long pNum) {
        return productDAO.deleteByProductNum(pNum);
    }
}
