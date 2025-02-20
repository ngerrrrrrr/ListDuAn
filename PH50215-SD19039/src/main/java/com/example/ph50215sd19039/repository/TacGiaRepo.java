package com.example.ph50215sd19039.repository;

import com.example.ph50215sd19039.entity.TacGia;
import com.example.ph50215sd19039.util.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class TacGiaRepo {
    private Session s;

    public TacGiaRepo() {s = Hibernate.getFACTORY().openSession();
    }

    public List<TacGia> getAll(){
        return s.createQuery("FROM TacGia ").list();
    }

    public static void main(String[] args) {
        TacGiaRepo rp = new TacGiaRepo();
        System.out.println(rp.getAll());
    }

    public TacGia getOne(Long id){
        return s.find(TacGia.class, id);
    }
}
