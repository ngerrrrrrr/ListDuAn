package com.example.AsmJ5.ASM.Repository;

import com.example.AsmJ5.ASM.Model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepo extends JpaRepository<HoaDon, Integer> {
}
