package com.example.AsmJ5.ASM.Repository;

import com.example.AsmJ5.ASM.Model.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepo extends JpaRepository<MauSac, Integer> {
}
