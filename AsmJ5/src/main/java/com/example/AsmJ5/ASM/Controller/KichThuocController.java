package com.example.AsmJ5.ASM.Controller;

import com.example.AsmJ5.ASM.Model.KichThuoc;
import com.example.AsmJ5.ASM.Repository.KichThuocRepo;
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
@RequestMapping("/kich-thuoc")
public class KichThuocController {
    @Autowired
    KichThuocRepo kichThuocRepo;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute KichThuoc kichThuoc) {
        model.addAttribute("danhSachKt", kichThuocRepo.findAll());
        return "KichThuoc/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        kichThuocRepo.deleteById(id);
        return "redirect:/kich-thuoc/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("kichThuoc", kichThuocRepo.findById(id).get());
        return "KichThuoc/view-update";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute @Valid KichThuoc kichThuoc, Errors errors) {
        if (errors.hasErrors()){
            model.addAttribute("danhSachKt", kichThuocRepo.findAll());
            return "KichThuoc/hien-thi";
        }
        kichThuocRepo.save(kichThuoc);
        return "redirect:/kich-thuoc/hien-thi";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute @Valid KichThuoc kichThuoc, Errors errors) {
        if (errors.hasErrors()){
            model.addAttribute("danhSachKt", kichThuocRepo.findAll());
            return "KichThuoc/hien-thi";
        }
        kichThuocRepo.save(kichThuoc);
        return "redirect:/kich-thuoc/hien-thi";
    }
}
