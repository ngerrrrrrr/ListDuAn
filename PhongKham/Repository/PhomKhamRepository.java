package com.example.sof3022_buoi1.PhongKham.Repository;

import com.example.sof3022_buoi1.PhongKham.Model.PhongKham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhomKhamRepository extends JpaRepository<PhongKham, Integer> {
}
