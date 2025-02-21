package com.example.AsmJ5.ASM.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hoa_don_chi_tiet")
@Entity
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Vui lòng chọn sản phẩm!")
    @ManyToOne
    @JoinColumn(name = "id_spct", referencedColumnName = "id")
    private SanPhamChiTiet sanPhamChiTiet;

    @NotNull(message = "Vui lòng chọn hóa đơn")
    @ManyToOne
    @JoinColumn(name = "id_hoa_don", referencedColumnName = "id")
    private HoaDon hoaDon;

    @NotNull(message = "Số lượng không được để trống!")
    @Column(name = "so_luong")
    private Integer soLuong;

    @NotNull(message = "Đơn giá không được để trống!")
    @Column(name = "don_gia")
    private BigDecimal donGia;

    @NotNull(message = "Vui lòng chọn trạng thái!")
    @Column(name = "trang_thai")
    private Boolean trangThai;
}
