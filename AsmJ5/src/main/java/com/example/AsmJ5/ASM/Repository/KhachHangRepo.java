package com.example.AsmJ5.ASM.Repository;

import com.example.AsmJ5.ASM.Model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang, Integer> {
}
