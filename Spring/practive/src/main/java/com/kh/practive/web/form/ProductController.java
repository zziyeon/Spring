package com.kh.practive.web.form;

import com.kh.practive.domain.Product;
import com.kh.practive.domain.svc.ProductSVC;
import com.kh.practive.web.form.product.EachInfoForm;
import com.kh.practive.web.form.product.EditForm;
import com.kh.practive.web.form.product.SaveForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductSVC productSVC;

    //등록 양식
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("form", new SaveForm());

        return "product/addForm";
    }

    //등록 처리
    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("form") SaveForm saveForm, BindingResult bindingResult,
                      RedirectAttributes redirectAttributes){
        Product product = new Product();
        product.setPname(saveForm.getPname());
        product.setQuantity(saveForm.getQuantity());
        product.setPrice(saveForm.getPrice());

        Product savedProduct = productSVC.save(product);

        Long id = savedProduct.getProductId();
        redirectAttributes.addAttribute("id", id);
        return "redirect:/product/{id}";
    }

    //상품 개별 조회
    @GetMapping("/{id}")
    public String findByProductId(
            @PathVariable("id") Long id,
            Model model
    ){
        Product findedProduct = productSVC.findById(id);

        EachInfoForm eachInfoForm = new EachInfoForm();
        eachInfoForm.setProductId(findedProduct.getProductId());
        eachInfoForm.setPname(findedProduct.getPname());
        eachInfoForm.setQuantity(findedProduct.getQuantity());
        eachInfoForm.setPrice(findedProduct.getPrice());

        model.addAttribute("form", eachInfoForm);

        return "product/EachInfoForm";
    }

    //수정 화면
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable("id") Long id, Model model) {
        Product findedProduct = productSVC.findById(id);

        EditForm editForm = new EditForm();

        editForm.setProductId(findedProduct.getProductId());
        editForm.setPname(findedProduct.getPname());
        editForm.setQuantity(findedProduct.getQuantity());
        editForm.setPrice(findedProduct.getPrice());

        model.addAttribute("form", editForm);

        return "product/editForm";
    }

    //수정처리
    @PostMapping("{id}/edit")
    public String edit(@PathVariable("id") Long id, @Valid @ModelAttribute("form") EditForm editForm, BindingResult bindingResult) {
        Product product = new Product();
        product.setPname(editForm.getPname());
        product.setQuantity(editForm.getQuantity());
        product.setPrice(editForm.getPrice());

        int updatedRow = productSVC.update(id,product);
        if (updatedRow == 0) {
            return "product/editForm";
        }
        return "redirect:/product/{id}";
    }

    //삭제처리
    @GetMapping("/{id}/del")
    public String delete(@PathVariable("id") Long id) {
        int deletedRow = productSVC.delete(id);
        if (deletedRow == 0){
            return "redirect:/product/"+id;
        }
        return "redirect:/product";
    }

    //목록 화면
    @GetMapping("")
    public String all(Model model) {
        List<Product> list = productSVC.findAll();
        model.addAttribute("list", list);

        return "product/list";
    }
}
