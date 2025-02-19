package com.example.sof3022_buoi1.PhongKham.Controller;

import com.example.sof3022_buoi1.PhongKham.Model.PhongKham;
import com.example.sof3022_buoi1.PhongKham.Repository.PhomKhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/phong-kham")
public class PhongKhamController {
    @Autowired
    PhomKhamRepository phomKhamRepository;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("danhSach", phomKhamRepository.findAll());
        return "/phongKham/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("phongKham", phomKhamRepository.findById(id).get());
        return "phongKham/detail";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("phongKham", phomKhamRepository.findById(id).get());
        return "phongKham/view-update";
    }

    @PostMapping("/update")
    public String update(PhongKham phongKham) {
        phomKhamRepository.save(phongKham);
        return "redirect:/phong-kham/hien-thi";
    }

    @PostMapping("/add")
    public String add(PhongKham phongKham) {
        phomKhamRepository.save(phongKham);
        return "redirect:/phong-kham/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        phomKhamRepository.deleteById(id);
        return "redirect:/phong-kham/hien-thi";
    }
}
