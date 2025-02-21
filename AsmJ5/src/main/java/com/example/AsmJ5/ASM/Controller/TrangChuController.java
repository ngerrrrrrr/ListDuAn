package com.example.AsmJ5.ASM.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ban-hang")
public class TrangChuController {
    @GetMapping("/trang-chu")
    public String trangChu(Model model){
        model.addAttribute("tittle", "Chào mừng đến với hệ thống quản lý bán hàng");
        return "/TrangChu/trang-chu";
    }
}
