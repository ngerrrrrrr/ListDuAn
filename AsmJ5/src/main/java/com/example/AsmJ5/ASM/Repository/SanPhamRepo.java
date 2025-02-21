package com.example.AsmJ5.ASM.Repository;

import com.example.AsmJ5.ASM.Model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, Integer> {
}
