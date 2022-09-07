package com.kh.myapp1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/")
public class ProductController {
    @GetMapping
    public String formOfSum(){

        return "writeProduct";
    }

//    //상품 등록
//    @PostMapping("/register")
//    public String result(
//            @RequestParam("op1") int op1,
//            @RequestParam("op2") int op2,
//            Model model
//    ){
//        int sum = op1 + op2;
//
//        model.addAttribute("op1", op1);
//        model.addAttribute("op2", op2);
//        model.addAttribute("result", sum);
//
//        return "addForm";
//    }
}
