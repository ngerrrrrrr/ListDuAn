package com.example.ph50215sd19039.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "TacGia")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TacGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MaTacGia")
    private String ma;

    @Column(name = "TenTacGia")
    private String ten;

    @Column(name = "QuocTich")
    private String quocTich;

    @Column(name = "NgaySinh")
    private String ngaySinh;

    @Column(name = "GhiChu")
    private String ghiChu;

    public TacGia(Long id) {
        this.id = id;
    }
}
