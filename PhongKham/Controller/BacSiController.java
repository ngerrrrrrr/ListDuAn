package com.example.sof3022_buoi1.PhongKham.Controller;

import com.example.sof3022_buoi1.PhongKham.Model.BacSi;
import com.example.sof3022_buoi1.PhongKham.Model.PhongKham;
import com.example.sof3022_buoi1.PhongKham.Repository.BacSiRepository;
import com.example.sof3022_buoi1.PhongKham.Repository.PhomKhamRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/bac-si")
public class BacSiController {
    @Autowired
    BacSiRepository bacSiRepository;

    @Autowired
    PhomKhamRepository phomKhamRepository;

    @ModelAttribute("ListPhongKham")
    List<PhongKham> getListPhongKhams() {
        return phomKhamRepository.findAll();
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute BacSi bacSi) {
        model.addAttribute("ListBacSi", bacSiRepository.findAll());
        return "/bacSi/hien-thi";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute @Valid BacSi bacSi, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("ListBacSi", bacSiRepository.findAll());
            return "/bacSi/hien-thi";
        }
        bacSiRepository.save(bacSi);
        return "redirect:/bac-si/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String showDetail(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("bacSi", bacSiRepository.findById(id).get());
        return "/bacSi/detail";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("bacSi", bacSiRepository.findById(id).get());
        return "/bacSi/view-update";
    }

    @PostMapping("/update")
    public String update(BacSi bacSi) {
        bacSiRepository.save(bacSi);
        return "redirect:/bac-si/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        bacSiRepository.deleteById(id);
        return "redirect:/bac-si/hien-thi";
    }

    @GetMapping("/phan-trang")
    public String phanTrang(@RequestParam(name = "page", defaultValue = "0", required = false) Integer page, Model model) {
        int size = 3;
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        model.addAttribute("page", bacSiRepository.findAll(pageable));
        return "/bacSi/phan-trang";
    }
}
