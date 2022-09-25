package com.kh.great.domain.svc.product;

import com.kh.great.domain.Product;
import com.kh.great.domain.dao.product.ProductDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class ProductSVCImpl implements ProductSVC {
    private final ProductDAO productDAO;

    //상품 등록
    @Override
    public Long save(Product product) {
        return productDAO.save(product);
    }
    //상품 조회
    @Transactional(readOnly = true)
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

    // 오늘 마감 상품 목록
    @Override
    public List<Product> today_deadline() {
        return productDAO.today_deadline();
    }

    //상품 관리 목록
    @Override
    public List<Product> pManage(Long ownerNumber) {
        return productDAO.pManage(ownerNumber);
    }
}
