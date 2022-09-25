package com.kh.great.web.product.Controller;

import com.kh.great.domain.Product;
import com.kh.great.domain.svc.product.ProductSVC;
import com.kh.great.web.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiProductController {
    private final ProductSVC productSVC;

    // 최신순 목록 GET /api/zonning/priceList
    @GetMapping("/zonning/priceList")
    public ApiResponse<List<Product>>  recentList(){
        List<Product> list = productSVC.recentList();

        //api 응답 메시지
        return ApiResponse.createApiResMsg("00", "성공", list);
    }

    // 높은 할인순순 목록 GET /api/zonning/discountListDesc
    @GetMapping("/zonning/priceListDesc")
    public ApiResponse<List<Product>>  discountListDesc(){
        List<Product> list = productSVC.discountListDesc();

        //api 응답 메시지
        return ApiResponse.createApiResMsg("00", "성공", list);
    }

    // 낮은 가격순 목록 GET /api/zonning/priceList
    @GetMapping("/zonning/priceList")
    public ApiResponse<List<Product>>  priceList(){
        List<Product> list = productSVC.priceList();

        //api 응답 메시지
        return ApiResponse.createApiResMsg("00", "성공", list);
    }

    // 높은 가격순 목록 GET /api/zonning/priceListDesc
    @GetMapping("/zonning/priceListDesc")
    public ApiResponse<List<Product>>  priceListDesc(){
        List<Product> list = productSVC.priceListDesc();

        //api 응답 메시지
        return ApiResponse.createApiResMsg("00", "성공", list);
    }
}
