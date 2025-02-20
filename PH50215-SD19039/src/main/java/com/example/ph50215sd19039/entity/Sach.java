package com.example.ph50215sd19039.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Sach")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Sach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MaSach")
    private String ma;

    @Column(name = "TenSach")
    private String ten;

    @Column(name = "NamXuatBan")
    private Integer nam;

    @Column(name = "TheLoai")
    private String theLoai;

//    @Column(name = "TacGiaID")
//    private Long tacGiaId;

    @ManyToOne
    @JoinColumn(name = "tacGiaID", referencedColumnName = "id")
    private TacGia tg;

    public Sach(String ma, String ten, Integer nam, String theLoai, TacGia tg) {
        this.ma = ma;
        this.ten = ten;
        this.nam = nam;
        this.theLoai = theLoai;
        this.tg = tg;
    }
}
