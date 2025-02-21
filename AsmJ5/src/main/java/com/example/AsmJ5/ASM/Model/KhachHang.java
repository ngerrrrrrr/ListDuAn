package com.example.AsmJ5.ASM.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "khach_hang")
@Entity
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tên không được để trống!")
    @Column(name = "ten")
    private String ten;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Column(name = "sdt")
    private String sdt;

    @NotBlank(message = "Mã không được để trống!")
    @Column(name = "ma_kh")
    private String ma;

    @NotNull(message = "Trạng thái không được để trống")
    @Column(name = "trang_thai")
    private Boolean trangThai;
}
