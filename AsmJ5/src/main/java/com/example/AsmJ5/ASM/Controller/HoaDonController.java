package com.example.AsmJ5.ASM.Controller;

import com.example.AsmJ5.ASM.Model.HoaDon;
import com.example.AsmJ5.ASM.Model.KhachHang;
import com.example.AsmJ5.ASM.Model.NhanVien;
import com.example.AsmJ5.ASM.Repository.HoaDonRepo;
import com.example.AsmJ5.ASM.Repository.KhachHangRepo;
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

import java.util.List;

@Controller
@RequestMapping("/hoa-don")
public class HoaDonController {
    @Autowired
    HoaDonRepo hoaDonRepo;

    @Autowired
    KhachHangRepo khachHangRepo;

    @Autowired
    NhanVienRepo nhanVienRepo;

    @ModelAttribute("ListNhanVien")
    List<NhanVien> getListNhanViens() {
        return nhanVienRepo.findAll();
    }

    @ModelAttribute("ListKhachHang")
    List<KhachHang> getListKhachHangs() {
        return khachHangRepo.findAll();
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute HoaDon hoaDon) {
        model.addAttribute("danhSachHd", hoaDonRepo.findAll());
        return "HoaDon/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        khachHangRepo.deleteById(id);
        return "redirect:/hoa-don/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("hoaDon", hoaDonRepo.findById(id).get());
        return "HoaDon/view-update";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute @Valid HoaDon hoaDon, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("danhSachHd", hoaDonRepo.findAll());
            return "HoaDon/hien-thi";
        }
        hoaDonRepo.save(hoaDon);
        return "redirect:/hoa-don/hien-thi";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute @Valid HoaDon hoaDon, Errors errors) {
        if (errors.hasErrors()) {
            model.addAttribute("danhSachHd", hoaDonRepo.findAll());
            return "HoaDon/hien-thi";
        }
        hoaDonRepo.save(hoaDon);
        return "redirect:/hoa-don/hien-thi";
    }
}
