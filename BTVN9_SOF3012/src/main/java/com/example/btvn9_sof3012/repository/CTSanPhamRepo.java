package com.example.btvn9_sof3012.repository;

import com.example.btvn9_sof3012.entity.CTSanPham;
import com.example.btvn9_sof3012.util.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class CTSanPhamRepo {
    private Session s;

    public CTSanPhamRepo() {s = Hibernate.getFACTORY().openSession();
    }

    public List<CTSanPham> getAll(){
        return s.createQuery("FROM CTSanPham ").list();
    }

    public CTSanPham getOne(Long id){
        return s.find(CTSanPham.class, id);
    }

    public static void main(String[] args) {
        CTSanPhamRepo rp = new CTSanPhamRepo();
        System.out.println(rp.getAll());
    }

    public void add(CTSanPham ctsp){
        try {
            s.getTransaction().begin();

            s.persist(ctsp);

            s.getTransaction().commit();
        }catch (Exception e){
            s.getTransaction().rollback();
        }
    }

    public void delete(CTSanPham ctsp){
        try {
            s.getTransaction().begin();

            s.delete(ctsp);

            s.getTransaction().commit();
        }catch (Exception e){
            s.getTransaction().rollback();
        }
    }
}
