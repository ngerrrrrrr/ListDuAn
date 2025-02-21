package com.example.AsmJ5.ASM.Repository;

import com.example.AsmJ5.ASM.Model.SanPhamChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamChiTietRepo extends JpaRepository<SanPhamChiTiet, Integer> {
}
