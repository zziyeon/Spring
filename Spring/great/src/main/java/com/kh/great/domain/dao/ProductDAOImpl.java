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
    private  final JdbcTemplate jt;

    //신규 상품 번호 생성
    public Integer generateProductNumber() {
        String sql = "select product_productNumber_seq.nextval from dual ";
        Integer productNumber = jt.queryForObject(sql, Integer.class);
        return productNumber;
    }

    //등록
    @Override
    public int save(Product product) {
        int result = 0;
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO PRODUCT_INFO ");
        sql.append("(P_NUMBER, 1, P_TITLE, P_NAME, DEADLINE_TIME, CATEGORY, TOTAL_COUNT, REMAIN_COUNT, NORMAL_PRICE, SALE_PRICE, DISCOUNT_RATE, PAYMENT_OPTION, DETAIL_INFO,  P_STATUS) ");
        sql.append("VALUES (?, ?, ?, ?, TO_DATE(?,'YYYY-MM-DD \"T\"HH24:MI:SS'),?, ?, ?, ?, ?, ?, ?, ?, ?) ");

        jt.update(sql.toString(), product.getProductNumber(), product.getTitle(), product.getPName(), product.getDeadlineTime(), product.getCategory(), product.getTotalCount(), product.getRemainCount(), product.getNormalPrice(), product.getSalePrice(), product.getDiscountRate(), product.getPaymentOption(), product.getDetailInfo(), product.getPStatus());

        return result;
    }

    /**
     * 상품 조회 by 상품별 번호
     * @param productNumber 상품 번호
     * @return  상품 정보
     */
    @Override
    public Product findByNumber(Integer productNumber) {
        StringBuffer sql = new StringBuffer();
//        sql.append("SELECT ")
        return null;
    }

    @Override
    public void updatae(Integer productNumber, Product product) {

    }

    @Override
    public int delete(Integer productNumber) {
        int result = 0;
        String sql = "delete from product_info where productNumber=? ";

        result = jt.update(sql, productNumber);
        return result;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
