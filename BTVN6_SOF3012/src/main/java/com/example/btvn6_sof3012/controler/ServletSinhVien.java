package com.example.btvn6_sof3012.controler;

import com.example.btvn6_sof3012.entity.SinhVien;
import com.example.btvn6_sof3012.repository.SinhVienRePo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "ServletSinhVien", value = {
        "/sinhvien/hienthi",
        "/sinhvien/add",
        "/sinhvien/delete",
        "/sinhvien/detail",
        "/sinhvien/view-update",
        "/sinhvien/update"
})
public class ServletSinhVien extends HttpServlet {
    private SinhVienRePo rp = new SinhVienRePo();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hienthi")) {
            this.hienthi(request, response);
        } else if (uri.contains("detail")) {
            this.detail(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.viewUpdate(request, response);
        }
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        SinhVien s = rp.getOne(id);
        request.setAttribute("detail", s);
        request.getRequestDispatcher("/view/update.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        SinhVien s = rp.getOne(id);
        rp.delete(s);
        request.setAttribute("list", rp.getAll());
        request.getRequestDispatcher("/view/bang.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        SinhVien s = rp.getOne(id);
        request.setAttribute("detail", s);
        request.getRequestDispatcher("/view/bang.jsp").forward(request, response);
    }

    private void hienthi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", rp.getAll());
        request.getRequestDispatcher("/view/bang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
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
        SinhVien sv = new SinhVien();

        BeanUtils.populate(sv, request.getParameterMap());

        rp.update(sv);

        response.sendRedirect("/sinhvien/hienthi");
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        SinhVien sv = new SinhVien();

        BeanUtils.populate(sv, request.getParameterMap());

        rp.add(sv);

        response.sendRedirect("/sinhvien/hienthi");
    }
}
