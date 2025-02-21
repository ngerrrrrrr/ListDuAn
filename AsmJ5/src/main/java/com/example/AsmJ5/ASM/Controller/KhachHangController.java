package com.example.AsmJ5.ASM.Controller;

import com.example.AsmJ5.ASM.Model.KhachHang;
import com.example.AsmJ5.ASM.Repository.KhachHangRepo;
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
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    KhachHangRepo khachHangRepo;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute KhachHang khachHang) {
        model.addAttribute("danhSachKh", khachHangRepo.findAll());
        return "KhachHang/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        khachHangRepo.deleteById(id);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("khachHang", khachHangRepo.findById(id).get());
        return "KhachHang/view-update";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute @Valid KhachHang khachHang, Errors errors) {
        if (errors.hasErrors()){
            model.addAttribute("danhSachKh", khachHangRepo.findAll());
            return "KhachHang/hien-thi";
        }
        khachHangRepo.save(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute @Valid KhachHang khachHang, Errors errors) {
        if (errors.hasErrors()){
            model.addAttribute("danhSachKh", khachHangRepo.findAll());
            return "KhachHang/hien-thi";
        }
        khachHangRepo.save(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }
}
