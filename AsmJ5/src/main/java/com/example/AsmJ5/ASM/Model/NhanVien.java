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
@Table(name = "nhan_vien") // Chỉnh lại tên bảng theo snake_case
@Entity
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tên không được để trống!")
    @Column(name = "ten")
    private String ten;

    @NotBlank(message = "Mã không được để trống!")
    @Column(name = "ma_nv")
    private String ma;

    @NotBlank(message = "Tên đăng nhập không được để trống!")
    @Column(name = "ten_dang_nhap")
    private String account;

    @NotBlank(message = "Mật khẩu không được để trống!")
    @Column(name = "mat_khau")
    private String pass;

    @NotNull(message = "Trạng thái không được để trống!")
    @Column(name = "trang_thai")
    private Boolean trangThai;
}
