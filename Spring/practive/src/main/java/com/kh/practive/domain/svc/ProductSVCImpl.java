package com.kh.practive.domain.svc;

import com.kh.practive.domain.Product;
import com.kh.practive.domain.dao.ProductDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductSVCImpl implements ProductSVC {

    private final ProductDAO productDAO;

    //상품 등록
    @Override
    public Product save(Product product) {
        //상품 아이디 생성
        Long generatePid = productDAO.generatePid();
        product.setProductId(generatePid);
        productDAO.save(product);
        return productDAO.findById(generatePid);
    }
    //조회
    // @Override
    public Product findById(Long productId) {
        return productDAO.findById(productId);
    }

    @Override
    public int update(Long productId, Product product) {
        return productDAO.update(productId, product);
    }

    @Override
    public void delete(Long productId) {
        productDAO.delete(productId);
    }

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Long generatePid(){
        return productDAO.generatePid();
    }
}
