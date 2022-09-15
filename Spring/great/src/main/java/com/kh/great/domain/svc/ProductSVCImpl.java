package com.kh.great.domain.svc;

import com.kh.great.domain.Product;
import com.kh.great.domain.dao.ProductDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductSVCImpl implements ProductSVC {
    private final ProductDAO productDAO;

    //등록
    @Override
    public Product save(Product product) {
        //상품번호 생성
        Long generatePnum = productDAO.generatePnum();
        product.setProductNumber(generatePnum);
        productDAO.save(product);
        return productDAO.findByNumber(generatePnum);
    }

    //조회
    @Override
    public Product findByNumber(Long productNumber) {
        return productDAO.findByNumber(productNumber);
    }

    //수정
    @Override
    public void updatae(Long productNumber, Product product) {
        productDAO.update(productNumber,product);
    }

    @Override
    public void delete(Long productNumber) {
        productDAO.delete(productNumber);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }
}
