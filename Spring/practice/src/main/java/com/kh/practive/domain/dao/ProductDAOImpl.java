package com.kh.practive.domain.dao;

import com.kh.practive.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO{
    private final JdbcTemplate jt;


    @Override
    public Long generatePid() {
        String sql = "select product_product_id_seq.nextval from dual";
        Long productId = jt.queryForObject(sql, Long.class);
        return productId;
    }

    //상품 등록
    @Override
    public Product save(Product product) {
        String sql = ("insert into product values (?, ?, ?, ?) ");

        jt.update(sql, product.getProductId(), product.getPname(), product.getQuantity(), product.getPrice());
        return product;
    }

    //상품 조회
    @Override
    public Product findById(Long productId) {
        StringBuffer sql = new StringBuffer();

        sql.append("select product_id, pname, quantity, price ");
        sql.append("from product ");
        sql.append("where product_id = ? ");

        Product findedProduct = null;

        try {
            findedProduct = jt.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(Product.class), productId);
        } catch (DataAccessException e) {
            log.info("찾고자하는 상품이 없습니다. = > {}", productId);
        }

        return findedProduct;
    }

    //상품 수정
    @Override
    public int update(Long productId, Product product) {
        StringBuffer sql = new StringBuffer();

        sql.append("update product ");
        sql.append("set pname=?, quantity=?, price=? ");
        sql.append("where product_id = ? ");

        return jt.update(sql.toString(), product.getPname(), product.getQuantity(), product.getPrice(), productId);
    }

    //상품 삭제
    @Override
    public int delete(Long productId) {
        String sql = "delete from product where product_id=? ";

        return jt.update(sql, productId);
    }

    //상품 목록
    @Override
    public List<Product> findAll() {
        StringBuffer sql = new StringBuffer();

        sql.append("select product_id, pname, quantity, price ");
        sql.append("from product ");
        sql.append("order by product_id desc");

        List<Product> result = jt.query(sql.toString(), new BeanPropertyRowMapper<>(Product.class));
        return result;
    }
}
