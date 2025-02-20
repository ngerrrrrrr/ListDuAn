package com.example.btvn6_sof3012.repository;

import com.example.btvn6_sof3012.entity.SinhVien;
import com.example.btvn6_sof3012.util.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class SinhVienRePo {
    private Session s;

    public SinhVienRePo() {
        s = Hibernate.getFACTORY().openSession();
    }

    public List<SinhVien> getAll() {
        return s.createQuery("FROM SinhVien ").list();
    }

    public static void main(String[] args) {
        SinhVienRePo rp = new SinhVienRePo();
        System.out.println(rp.getAll());
    }

//    public List<SinhVien> getTop(){
//        String hql = "SELECT sv FROM SinhVien sv WHERE  ORDER BY tuoi ASC";
//    }

    public SinhVien getOne(Long id) {
        return s.find(SinhVien.class, id);
    }

    public void add(SinhVien sv) {
        try {
            s.getTransaction().begin();

            s.persist(sv);

            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void delete(SinhVien sv) {
        try {
            s.getTransaction().begin();

            s.delete(sv);

            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void update(SinhVien sv) {
        try {
            s.getTransaction().begin();

            s.merge(sv);

            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }
}
