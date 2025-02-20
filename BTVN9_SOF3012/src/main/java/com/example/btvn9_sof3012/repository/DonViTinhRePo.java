package com.example.btvn9_sof3012.repository;

import com.example.btvn9_sof3012.entity.DonViTinh;
import com.example.btvn9_sof3012.util.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class DonViTinhRePo {
    private Session s;

    public DonViTinhRePo() {s = Hibernate.getFACTORY().openSession();
    }

    public List<DonViTinh> getAll(){
        return s.createQuery("FROM DonViTinh ").list();
    }

    public DonViTinh getOne(Long id){
        return s.find(DonViTinh.class, id);
    }
}
