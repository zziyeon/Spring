package com.kh.great.domain.dao;

import com.kh.great.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductDAOImpl implements ProductDAO{
    private final JdbcTemplate jt;
    @Override
    //신규 상품 번호 생성
    public Long generatePnum() {
        String sql = "select product_productNumber_seq.nextval from dual ";
        Long productNumber = jt.queryForObject(sql, Long.class);
        return productNumber;
    }

    //등록
    @Override
    public int save(Product product) {
        int result = 0;
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO PRODUCT_INFO ");
        sql.append("(P_NUMBER, OWNER_NUMBER, STORE_NAME, P_TITLE, P_NAME, DEADLINE_TIME, CATEGORY, TOTAL_COUNT, " );
        sql.append("NORMAL_PRICE, SALE_PRICE, PAYMENT_OPTION, DETAIL_INFO, UPDATE_DATE) ");
        sql.append("VALUES (?, 1, '베리베리스트로', ?, ?, ?, ?,?, ?, ?, ?, ?, ? ) ");

        jt.update(sql.toString(), product.getProductNumber(), product.getTitle(), product.getPName(), product.getDeadlineTime(), product.getCategory(), product.getTotalCount(), product.getNormalPrice(), product.getSalePrice(), product.getPaymentOption(), product.getDetailInfo(), product.getUdate() );

        return result;
    }

    /**
     * 상품 조회 by 상품별 번호
     * @param productNumber 상품 번호
     * @return  상품 정보
     */
    @Override
    public Product findByNumber(Long productNumber) {
        StringBuffer sql = new StringBuffer();
//        sql.append("SELECT ")
        return null;
    }

    @Override
    public int update(Long productNumber, Product product) {

        return 0;
    }

    @Override
    public int delete(Long productNumber) {
        int result = 0;
        String sql = "delete from product_info where P_NUMBER=? ";

        result = jt.update(sql, productNumber);
        return result;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

}
