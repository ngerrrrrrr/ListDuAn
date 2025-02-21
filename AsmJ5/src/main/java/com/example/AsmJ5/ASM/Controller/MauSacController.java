package com.example.AsmJ5.ASM.Controller;

import com.example.AsmJ5.ASM.Model.MauSac;
import com.example.AsmJ5.ASM.Repository.MauSacRepo;
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
@RequestMapping("/mau-sac")
public class MauSacController {
    @Autowired
    MauSacRepo mauSacRepo;

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute MauSac mauSac) {
        model.addAttribute("danhSachMs", mauSacRepo.findAll());
        return "MauSac/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        mauSacRepo.deleteById(id);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("mauSac", mauSacRepo.findById(id).get());
        return "MauSac/view-update";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute @Valid MauSac mauSac, Errors errors) {
        if (errors.hasErrors()){
            model.addAttribute("danhSachMs", mauSacRepo.findAll());
            return "MauSac/hien-thi";
        }
        mauSacRepo.save(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute @Valid MauSac mauSac, Errors errors) {
        if (errors.hasErrors()){
            model.addAttribute("danhSachMs", mauSacRepo.findAll());
            return "MauSac/view-update";
        }
        mauSacRepo.save(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
}
