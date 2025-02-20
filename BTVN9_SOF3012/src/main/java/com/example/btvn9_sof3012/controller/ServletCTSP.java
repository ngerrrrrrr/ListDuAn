package com.example.btvn9_sof3012.controller;

import com.example.btvn9_sof3012.entity.CTSanPham;
import com.example.btvn9_sof3012.entity.DonViTinh;
import com.example.btvn9_sof3012.repository.CTSanPhamRepo;
import com.example.btvn9_sof3012.repository.DonViTinhRePo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletCTSP", value = {
        "/ctsp/hienthi",
        "/ctsp/add",
        "/ctsp/delete"
})
public class ServletCTSP extends HttpServlet {
    private CTSanPhamRepo rp = new CTSanPhamRepo();
    private DonViTinhRePo repo = new DonViTinhRePo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hienthi")) {
            this.hienthi(request, response);
        } else {
            this.delete(request, response);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        CTSanPham ctsp = rp.getOne(id);
        rp.delete(ctsp);
        request.setAttribute("list", rp.getAll());
        request.getRequestDispatcher("/view/bang.jsp").forward(request, response);
    }

    private void hienthi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", rp.getAll());
        request.getRequestDispatcher("/view/bang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")){
            this.add(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer so = Integer.parseInt(request.getParameter("so"));
        Float gia = Float.parseFloat(request.getParameter("gia"));
        String ghiChu = request.getParameter("ghiChu");
        Long idDonViTinh = Long.parseLong(request.getParameter("idDonViTinh"));
        DonViTinh dvt = repo.getOne(idDonViTinh);

        response.sendRedirect("/ctsp/hienthi");
    }
}
