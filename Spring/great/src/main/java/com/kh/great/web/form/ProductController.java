package com.kh.great.web.form;

import com.kh.great.domain.Product;
import com.kh.great.domain.svc.ProductSVC;
import com.kh.great.web.form.product.SaveForm;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/greats")
//@RequiredArgsConstructor
public class ProductController {
  private final ProductSVC productSVC;

  //등록 양식
  @GetMapping("/add")
  public String addForm(Model model) {
    model.addAttribute("form", new SaveForm());
    return "product/addForm";
  }

  //등록 처리
  @PostMapping("/add")
  public String add(@Valid @ModelAttribute("form") SaveForm saveForm, BindingResult bindingResult,
                    RedirectAttributes redirectAttributes) {
    Product product = new Product();
    BeanUtils.copyProperties(saveForm,product);
    Product savedProduct = productSVC.save(product);

    Long num = savedProduct.getProductNumber();
    redirectAttributes.addAttribute("num", num);
    return "redirect:/product/{num}";
  }
}
