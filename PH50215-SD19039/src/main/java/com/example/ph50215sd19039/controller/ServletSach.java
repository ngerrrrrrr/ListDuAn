package com.example.ph50215sd19039.controller;

import com.example.ph50215sd19039.entity.Sach;
import com.example.ph50215sd19039.entity.TacGia;
import com.example.ph50215sd19039.repository.SachRepo;
import com.example.ph50215sd19039.repository.TacGiaRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;

@WebServlet(name = "ServletSach", value = {
        "/sach/hienthi",
        "/sach/detail",
        "/sach/delete",
        "/sach/view-update",
        "/sach/add",
        "/sach/update",
        "/sach/search"
})
public class ServletSach extends HttpServlet {
    private SachRepo rp = new SachRepo();
    private TacGiaRepo tacGiaRepo = new TacGiaRepo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hienthi")) {
            this.hienthi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("search")) {
            this.search(request, response);
        } else {
            this.viewUpdate(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        List<Sach> list = rp.search(ten);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/bang.jsp").forward(request, response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Sach s = rp.getOne(id);
        request.setAttribute("detail", s);
        request.setAttribute("listTg", tacGiaRepo.getAll());
        request.setAttribute("list", rp.getAll());
        request.getRequestDispatcher("/view/update.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Sach s = rp.getOne(id);
        rp.delete(s);
        request.setAttribute("list", rp.getAll());
        request.getRequestDispatcher("/view/bang.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Sach s = rp.getOne(id);
        request.setAttribute("detail", s);
        request.setAttribute("listTg", tacGiaRepo.getAll());
        request.setAttribute("list", rp.getAll());
        request.getRequestDispatcher("/view/bang.jsp").forward(request, response);
    }

    private void hienthi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");

        Integer no = (pageNo != null) ? Integer.parseInt(pageNo) : 0;
        Integer size = (pageSize != null) ? Integer.parseInt(pageSize) : 5;

        List<Sach> list = rp.phanTrang(no, size);

        Integer totalSach = rp.getAll().size();
        Integer totalPage = (int) Math.ceil((double) totalSach / size);

        request.setAttribute("list", list);
        request.setAttribute("pageHienTai", no);
        request.setAttribute("tongPage", totalPage);
        request.setAttribute("listTg", tacGiaRepo.getAll());
        request.getRequestDispatcher("/view/bang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/sach/add")) {
            try {
                this.add(request, response);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                this.update(request, response);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        Integer nam = Integer.parseInt(request.getParameter("nam"));
        String theLoai = request.getParameter("theLoai");
        Long tacGiaId = Long.parseLong(request.getParameter("tacGiaId"));
        TacGia tacGia = tacGiaRepo.getOne(tacGiaId);
        Sach sach = new Sach(id, ma, ten, nam, theLoai, tacGia);

        rp.update(sach);

        response.sendRedirect("/sach/hienthi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        Integer nam = Integer.parseInt(request.getParameter("nam"));
        String theLoai = request.getParameter("theLoai");
        Long tacGiaId = Long.parseLong(request.getParameter("tacGiaId"));
        TacGia tacGia = tacGiaRepo.getOne(tacGiaId);
        Sach sach = new Sach(ma, ten, nam, theLoai, tacGia);
        rp.add(sach);

        response.sendRedirect("/sach/hienthi");


    }
}
