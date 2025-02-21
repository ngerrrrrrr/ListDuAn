package com.example.AsmJ5.ASM.Controller;

import com.example.AsmJ5.ASM.Model.HoaDon;
import com.example.AsmJ5.ASM.Model.HoaDonChiTiet;
import com.example.AsmJ5.ASM.Model.KhachHang;
import com.example.AsmJ5.ASM.Model.SanPham;
import com.example.AsmJ5.ASM.Model.SanPhamChiTiet;
import com.example.AsmJ5.ASM.Repository.HoaDonChiTietRepo;
import com.example.AsmJ5.ASM.Repository.HoaDonRepo;
import com.example.AsmJ5.ASM.Repository.KhachHangRepo;
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
@RequestMapping("/hoa-don-chi-tiet")
public class HoaDonChiTietController {
    @Autowired
    HoaDonChiTietRepo hoaDonChiTietRepo;

    @Autowired
    SanPhamChiTietRepo sanPhamChiTietRepo;

    @Autowired
    HoaDonRepo hoaDonRepo;

    @ModelAttribute("danhSachSanPhamChiTiet")
    List<SanPhamChiTiet> getListSanPhamChiTietss(){
        return sanPhamChiTietRepo.findAll();
    }

    @ModelAttribute("ListHoaDon")
    List<HoaDon> getListHoaDons(){
        return hoaDonRepo.findAll();
    }

    @GetMapping("/hien-thi")
    public String hienThi(Model model, @ModelAttribute HoaDonChiTiet hoaDonChiTiet) {
        model.addAttribute("danhSachHdct", hoaDonChiTietRepo.findAll());
        return "HoaDonChiTiet/hien-thi";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        hoaDonChiTietRepo.deleteById(id);
        return "redirect:/hoa-don-chi-tiet/hien-thi";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") Integer id) {
        model.addAttribute("hoaDonChiTiet", hoaDonChiTietRepo.findById(id).get());
        return "HoaDonChiTiet/view-update";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute @Valid HoaDonChiTiet hoaDonChiTiet, Errors errors) {
        if (errors.hasErrors()){
            model.addAttribute("danhSachHdct", hoaDonChiTietRepo.findAll());
            return "HoaDonChiTiet/hien-thi";
        }
        hoaDonChiTietRepo.save(hoaDonChiTiet);
        return "redirect:/hoa-don-chi-tiet/hien-thi";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute @Valid HoaDonChiTiet hoaDonChiTiet, Errors errors) {
        if (errors.hasErrors()){
            model.addAttribute("danhSachHdct", hoaDonChiTietRepo.findAll());
            return "HoaDonChiTiet/hien-thi";
        }
        hoaDonChiTietRepo.save(hoaDonChiTiet);
        return "redirect:/hoa-don-chi-tiet/hien-thi";
    }
}
