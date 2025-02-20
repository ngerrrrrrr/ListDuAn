package com.example.ph50215sd19039.repository;

import com.example.ph50215sd19039.entity.Sach;
import com.example.ph50215sd19039.util.Hibernate;
import jakarta.persistence.Query;
import org.hibernate.Session;

import java.util.List;

public class SachRepo {
    private Session s;

    public SachRepo() {
        s = Hibernate.getFACTORY().openSession();
    }

    public List<Sach> getAll() {
        return s.createQuery("FROM Sach ").list();
    }

    public Sach getOne(Long id) {
        return s.find(Sach.class, id);
    }

    public void add(Sach sach) {
        try {
            s.getTransaction().begin();

            s.persist(sach);

            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public void delete(Sach sach) {
        try {
            s.getTransaction().begin();

            s.delete(sach);

            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public List<Sach> search(String ten) {
        String hql = "SELECT sach FROM Sach sach WHERE ten Like :ten";
        Query q = s.createQuery(hql);
        q.setParameter("ten", "%" + ten + "%");
        return q.getResultList();
    }

    public void update(Sach sach) {
        try {
            s.getTransaction().begin();

            s.merge(sach);

            s.getTransaction().commit();
        } catch (Exception e) {
            s.getTransaction().rollback();
        }
    }

    public List<Sach> phanTrang(Integer pageNo, Integer pageSize) {
        Integer offSet = pageNo * pageSize;

        String hql = """
                SELECT sach FROM Sach  sach
                ORDER BY sach.id
                """;
        Query q = s.createQuery(hql);
        q.setFirstResult(offSet);
        q.setMaxResults(pageSize);
        return q.getResultList();
    }

    public static void main(String[] args) {
        System.out.println(new SachRepo().getAll());
    }
}
