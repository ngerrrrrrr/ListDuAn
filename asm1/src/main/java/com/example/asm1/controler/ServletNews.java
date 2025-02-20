package com.example.asm1.controler;

import com.example.asm1.entity.news;
import com.example.asm1.repository.Repo_News;
import com.example.asm1.repository.Repo_User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletNews", value = {"/ServletNews",
        "/Admin",
        "/SVadmin",
        "/Add",
        "/Delete",
        "/Edit",
        "/Update",
        "/AddData"

})
public class ServletNews extends HttpServlet {
    private Repo_News rp = new Repo_News();
    private Repo_User repo = new Repo_User();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("ServletNews")) {
            ArrayList<news> list = rp.getAll();
            request.setAttribute("ListNew", list);
            request.getRequestDispatcher("/view/giaoDien.jsp").forward(request, response);
        }else if (uri.contains("/SVadmin")){
            ArrayList<news> list = rp.getAll();
            request.setAttribute("listN", list);
            request.getRequestDispatcher("/view/Admin.jsp").forward(request, response);
        }else if (uri.contains("Delete")){
            String id = request.getParameter("id");
            rp.Delete(id);

            ArrayList<news> list = rp.getAll();
            request.setAttribute("listN", list);
            request.getRequestDispatcher("/view/Admin.jsp").forward(request, response);
//        }else if (uri.contains("Add")){
//            request.getRequestDispatcher("/view/add.jsp").forward(request, response);
        }else if (uri.contains("Edit")){
            String id = request.getParameter("id");
            news n = rp.timNew(id);
            request.setAttribute("timNew", n);
            request.getRequestDispatcher("/view/update.jsp").forward(request, response);
        }
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("Admin")) {
            // Lấy giá trị id và pass từ request
            String id = request.getParameter("id");
            String pass = request.getParameter("pass");

            // Kiểm tra nếu id hoặc pass rỗng
            if (id == null || id.trim().isEmpty() || pass == null || pass.trim().isEmpty()) {
                // Điều hướng lại trang đăng nhập và thông báo lỗi nếu thông tin chưa đầy đủ
                request.setAttribute("errorMessage", "Vui lòng nhập đầy đủ tài khoản và mật khẩu.");
                request.getRequestDispatcher("/view/login.jsp").forward(request, response);
                return;
            }

            // Kiểm tra thông tin đăng nhập với repository
            if (repo.User(id, pass) > 0) {
                // Nếu thông tin đúng, chuyển đến trang Admin
                request.setAttribute("loginStatus", "success");
                request.getRequestDispatcher("/view/Admin.jsp").forward(request, response);
            } else {
                // Nếu thông tin sai, điều hướng lại trang đăng nhập với thông báo lỗi
                request.setAttribute("loginStatus", "failed");
                request.getRequestDispatcher("/view/login.jsp").forward(request, response);
            }
        }
        else if (uri.contains("Update")){
            String id = request.getParameter("id");
            String tit = request.getParameter("title");
            String cont = request.getParameter("content");
            String img = request.getParameter("img");
            rp.Update(id, tit, cont, img);

            ArrayList<news> list = rp.getAll();
            request.setAttribute("listN", list);
            request.getRequestDispatcher("/view/Admin.jsp").forward(request, response);
        }
//        else if (uri.contains("/AddData")){
//            String id = request.getParameter("id");
//            String tit = request.getParameter("title");
//            String cont = request.getParameter("content");
//            String img = request.getParameter("img");
//            String date = request.
//            String aut = rs.getString(6);
//            int view = rs.getInt(7);
//            String cate = rs.getString(8);
//            boolean home = rs.getBoolean(9);
//            rp.Add(tit, cont, img);
//
//            ArrayList<news> list = rp.getAll();
//            request.setAttribute("listN", list);
//            request.getRequestDispatcher("/view/Admin.jsp").forward(request, response);
//        }
    }
}
