package com.example.sof3022_buoi1.PhongKham.Repository;

import com.example.sof3022_buoi1.PhongKham.Model.BacSi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacSiRepository extends JpaRepository<BacSi, Integer> {
}
