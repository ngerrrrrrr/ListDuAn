package com.example.AsmJ5.ASM.Controller;


import com.example.AsmJ5.ASM.Model.SanPham;

import com.example.AsmJ5.ASM.Repository.SanPhamRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController {
    @Autowired
    SanPhamRepo sanPhamRepo;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute SanPham sanPham) {
        model.addAttribute("danhSachSp", sanPhamRepo.findAll());
        return "SanPham/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        sanPhamRepo.deleteById(id);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("sanPham", sanPhamRepo.findById(id).get());
        return "SanPham/view-update";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute @Valid SanPham sanPham, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("danhSachSp", sanPhamRepo.findAll());
            return "SanPham/hien-thi";
        }
        sanPhamRepo.save(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute @Valid SanPham sanPham, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("danhSachSp", sanPhamRepo.findAll());
            return "SanPham/view-update";
        }
        sanPhamRepo.save(sanPham);
        return "redirect:/san-pham/hien-thi";
    }
}
