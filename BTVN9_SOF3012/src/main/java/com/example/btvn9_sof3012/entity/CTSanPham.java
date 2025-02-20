package com.example.btvn9_sof3012.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "chiTietSanPham")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CTSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCTSP")
    private Long id;

    @Column(name = "soLuongTon")
    private Integer so;

    @Column(name = "donGia")
    private Float gia;

    @Column(name = "ghiChu")
    private String ghiChu;

    @ManyToOne
    @JoinColumn(name = "idDonViTinh", referencedColumnName = "idDonViTinh")
    private DonViTinh dvt;
}
