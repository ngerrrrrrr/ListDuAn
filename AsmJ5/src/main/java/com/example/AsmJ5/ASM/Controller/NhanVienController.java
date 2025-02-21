package com.example.AsmJ5.ASM.Controller;

import com.example.AsmJ5.ASM.Model.NhanVien;
import com.example.AsmJ5.ASM.Repository.NhanVienRepo;
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
@RequestMapping("/nhan-vien")
public class NhanVienController {
    @Autowired
    NhanVienRepo nhanVienRepo;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute NhanVien nhanVien) {
        model.addAttribute("danhSachNv", nhanVienRepo.findAll());
        return "NhanVien/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        nhanVienRepo.deleteById(id);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("nhanVien", nhanVienRepo.findById(id).get());
        return "NhanVien/view-update";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute @Valid NhanVien nhanVien, Errors errors) {
        if (errors.hasErrors()){
            model.addAttribute("danhSachNv", nhanVienRepo.findAll());
            return "NhanVien/hien-thi";
        }
        nhanVienRepo.save(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute @Valid NhanVien nhanVien, Errors errors) {
        if (errors.hasErrors()){
            model.addAttribute("danhSachNv", nhanVienRepo.findAll());
            return "NhanVien/view-update";
        }
        nhanVienRepo.save(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
}
