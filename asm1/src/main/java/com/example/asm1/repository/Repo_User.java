package com.example.asm1.repository;

import com.example.asm1.entity.Users;
import com.example.asm1.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Repo_User {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public Repo_User() {con = DBConnect.getConnection();
    }

    public int User(String taiKhoan, String matKhau) {
        String sql = "SELECT COUNT(*) FROM Users WHERE id = ? AND password = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, taiKhoan);
            ps.setString(2, matKhau);

            ResultSet rs = ps.executeQuery();  // Sử dụng executeQuery() để thực thi SELECT
            if (rs.next()) {
                return rs.getInt(1);  // Trả về số lượng bản ghi khớp
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;  // Trả về 0 nếu không tìm thấy bản ghi nào
    }
}
