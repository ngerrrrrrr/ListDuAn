package com.example.AsmJ5.ASM.Controller;

import com.example.AsmJ5.ASM.Model.HoaDon;
import com.example.AsmJ5.ASM.Model.HoaDonChiTiet;
import com.example.AsmJ5.ASM.Model.KichThuoc;
import com.example.AsmJ5.ASM.Model.MauSac;
import com.example.AsmJ5.ASM.Model.SanPham;
import com.example.AsmJ5.ASM.Model.SanPhamChiTiet;
import com.example.AsmJ5.ASM.Repository.HoaDonChiTietRepo;
import com.example.AsmJ5.ASM.Repository.HoaDonRepo;
import com.example.AsmJ5.ASM.Repository.KichThuocRepo;
import com.example.AsmJ5.ASM.Repository.MauSacRepo;
import com.example.AsmJ5.ASM.Repository.SanPhamChiTietRepo;
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

import java.util.List;

@Controller
@RequestMapping("/san-pham-chi-tiet")
public class SanPhamChiTietController {
    @Autowired
    SanPhamChiTietRepo sanPhamChiTietRepo;

    @Autowired
    SanPhamRepo sanPhamRepo;

    @Autowired
    MauSacRepo mauSacRepo;

    @Autowired
    KichThuocRepo kichThuocRepo;

    @ModelAttribute("ListSanPham")
    List<SanPham> getListSanPhams() {
        return sanPhamRepo.findAll();
    }

    @ModelAttribute("ListMauSac")
    List<MauSac> getListMauSacs() {
        return mauSacRepo.findAll();
    }

    @ModelAttribute("ListKichThuoc")
    List<KichThuoc> getListKichThuocs() {
        return kichThuocRepo.findAll();
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute SanPhamChiTiet sanPhamChiTiet) {
        model.addAttribute("danhSachSpct", sanPhamChiTietRepo.findAll());
        return "SanPhamChiTiet/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        sanPhamChiTietRepo.deleteById(id);
        return "redirect:/san-pham-chi-tiet/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("sanPhamChiTiet", sanPhamChiTietRepo.findById(id).get());
        return "SanPhamChiTiet/view-update";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute @Valid SanPhamChiTiet sanPhamChiTiet, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("danhSachSpct", sanPhamChiTietRepo.findAll());
            return "SanPhamChiTiet/hien-thi";
        }
        sanPhamChiTietRepo.save(sanPhamChiTiet);
        return "redirect:/san-pham-chi-tiet/hien-thi";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute @Valid SanPhamChiTiet sanPhamChiTiet, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("danhSachSpct", sanPhamChiTietRepo.findAll());
            return "SanPhamChiTiet/hien-thi";
        }
        sanPhamChiTietRepo.save(sanPhamChiTiet);
        return "redirect:/san-pham-chi-tiet/hien-thi";
    }
}
