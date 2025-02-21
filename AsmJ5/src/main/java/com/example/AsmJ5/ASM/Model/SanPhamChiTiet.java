package com.example.AsmJ5.ASM.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sp_chi_tiet")
@Entity
public class SanPhamChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Vui lòng chọn màu sắc")
    @ManyToOne
    @JoinColumn(name = "id_mau_sac", referencedColumnName = "id")
    private MauSac mauSac;

    @NotNull(message = "Vui lòng chọn kích thước!")
    @ManyToOne
    @JoinColumn(name = "id_kich_thuoc", referencedColumnName = "id")
    private KichThuoc kichThuoc;

    @NotNull(message = "Vui lòng chọn sản phẩm!")
    @ManyToOne
    @JoinColumn(name = "id_san_pham", referencedColumnName = "id")
    private SanPham sanPham;

    @NotNull(message = "Số lượng không được để trống")
    @Column(name = "so_luong")
    private Integer soLuong;

    @NotNull(message = "Đơn giá không được để trống!")
    @Column(name = "don_gia")
    private BigDecimal donGia;

    @NotNull(message = "Trạng thái không được để trống!")
    @Column(name = "trang_thai")
    private Boolean trangThai;
}
