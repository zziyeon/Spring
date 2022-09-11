package com.kh.practive.web.form;

import com.kh.practive.domain.Product;
import com.kh.practive.domain.svc.ProductSVC;
import com.kh.practive.web.form.product.EachInfoForm;
import com.kh.practive.web.form.product.SaveForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductSVC productSVC;

    //등록 양식
    @GetMapping("add")
    public String addForm(){
        return "product/addForm";
    }

    //등록 처리
    @PostMapping
    public String add(SaveForm saveForm){
        Product product = new Product();
        product.setPname(saveForm.getPname());
        product.setQuantity(saveForm.getQuantity());
        product.setPrice(saveForm.getPrice());

        Product savedProduct = productSVC.save(product);
        return "redirect:/products/"+savedProduct.getProductId();
    }

    //상품 개별 조회
    @GetMapping("/{pid}")
    public String findByProductId(
            @PathVariable("pid") Long pid,
            Model model
    ){
        Product findedProduct = productSVC.findById(pid);

        EachInfoForm eachInfoForm = new EachInfoForm();
        eachInfoForm.setProductId(findedProduct.getProductId());
        eachInfoForm.setPname(findedProduct.getPname());
        eachInfoForm.setQuantity(findedProduct.getQuantity());
        eachInfoForm.setPrice(findedProduct.getPrice());

        model.addAttribute("eachInfoForm", eachInfoForm);

        return "product/EachInfoForm";
    }
}
