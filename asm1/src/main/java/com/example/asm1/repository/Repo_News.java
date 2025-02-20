package com.example.asm1.repository;

import com.example.asm1.entity.news;
import com.example.asm1.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Repo_News {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public Repo_News() {con = DBConnect.getConnection();
    }

    public ArrayList<news> getAll(){
        ArrayList<news> list = new ArrayList<>();
        sql = "SELECT * FROM [ASM1_J3].[dbo].[NEWS]";


        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                String id = rs.getString(1);
                String tit = rs.getString(2);
                String cont = rs.getString(3);
                String img = rs.getString(4);
                String date = rs.getString(5);
                String aut = rs.getString(6);
                int view = rs.getInt(7);
                String cate = rs.getString(8);
                boolean home = rs.getBoolean(9);
                list.add(new news(id, tit, cont, img, date, aut, view, cate, home));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return list;
    }
//    public int Add(String id, String tit, String cont, String img){
//        sql = "INSERT INTO NEWS (Id, Title, Content, Image, PostedDate, Author, ViewCount, CategoryId, Home) VALUES(?,?,?,?,?,?,?,?,?)";
//        try{
//            ps = con.prepareStatement(sql);
//
//            return ps.executeUpdate();
//        }catch (Exception e){
//            e.printStackTrace();
//            return 0;
//        }
//    }
    public int Delete(String id){
        sql = "DELETE FROM NEWS WHERE Id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public int Update(String id, String tit, String cont, String img){
        sql = "UPDATE [dbo].[NEWS]\n" +
                "   SET [Title] = ?\n" +
                "      ,[Content] = ?\n" +
                "      ,[Image] = ?\n" +
                " WHERE Id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, tit);
            ps.setString(2, cont);
            ps.setString(3, img);
            ps.setString(4, id);
            return ps.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    public news timNew(String idd){
        sql = "SELECT *" +
                "  FROM [ASM1_J3].[dbo].[NEWS] WHERE Id = ?";
        news n = null;
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, idd);
            rs = ps.executeQuery();
            if (rs.next()){
                String id = rs.getString(1);
                String tit = rs.getString(2);
                String cont = rs.getString(3);
                String img = rs.getString(4);
                String date = rs.getString(5);
                String aut = rs.getString(6);
                int view = rs.getInt(7);
                String cate = rs.getString(8);
                boolean home = rs.getBoolean(9);
                n = new news(id, tit, cont, img, date, aut,  view, cate, home);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return n;
    }
}
