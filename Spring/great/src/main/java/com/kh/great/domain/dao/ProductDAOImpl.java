package com.kh.great.domain.dao;

import com.kh.great.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO {
    private final JdbcTemplate jt;

    //상품번호 생성
    @Override
    public Long generatePnum() {
        String sql = "select product_p_number_seq.nextval from dual";
        Long productNum = jt.queryForObject(sql, Long.class);
        return productNum;
    }

    //상품등록
    @Override
    public Product save(Product product) {
        String sql = "insert into product_info(p_number,store_name,p_title, p_name) values(?, ?, ?,?) ";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jt.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"pid"});
                pstmt.setLong(1, product.getP_number());
                pstmt.setString(2, product.getStore_name());
                pstmt.setString(3, product.getP_title());
                pstmt.setString(4, product.getP_name());
                return pstmt;
            }
        }, keyHolder);

        Long pid = Long.valueOf(keyHolder.getKeys().get("pid").toString());
        product.setP_number(pid);
        return product;
    }
    //상품조회
    @Override
    public Product findByProductNum(Long pNum) {
        StringBuffer sql = new StringBuffer();
        sql.append("select ");
        sql.append("from product_info ");
        sql.append("where P_NUMBER = ? ");

        Product product = null;
        try {
            product=jt.queryForObject(sql.toString(), new BeanPropertyRowMapper<>(Product.class), pNum);
        } catch (DataAccessException e) {
            log.info("조회할 상품이 없습니다. 상품번호={}", pNum);
        }
        return product;
    }
    //상품수정
    @Override
    public int update(Long pNum, Product product) {
        int result = 0;
        StringBuffer sql = new StringBuffer();

        sql.append("update product_info ");
        sql.append("SET p_title = ?, P_NAME=?, DEADLINE_TIME = ?, CATEGORY=?, TOTAL_COUNT = ?, REMAIN_COUNT=?, NORMAL_PRICE = ?, SALE_PRICE = ?, DISCOUNT_RATE=?, PAYMENT_OPTION=?, detail_info=? ");
        sql.append("WHERE p_number = ? ");

//        result=jt.update(sql.toString(), product.getP_title(), product.getP_name(), product.getDeadline_time(), product.getP_category(), product.getTotal_count(), product.getRemain_count(), product.getNormal_price(), product.getSale_price(), product.getDiscount_rate(), product.getPayment_option(), product.getDetail_info(), product.getP_number() );

        return result;
    }

    //상품목록
    @Override
    public List<Product> findAll() {
        StringBuffer sql = new StringBuffer();

        sql.append("select p_name, DISCOUNT_RATE, SALE_PRICE, NORMAL_PRICE,DEADLINE_TIME ");
        sql.append(" from product_info");
        sql.append(" order by P_NUMBER desc");

        List<Product> result = jt.query(sql.toString(), new BeanPropertyRowMapper<>(Product.class));

        return result;
    }

    //상품 삭제
    @Override
    public int deleteByProductNum(Long pNum) {
        String sql = "delete from product_info where P_NUMBER=? ";

        return jt.update(sql, pNum);
    }
}
