package com.example.sof3022_buoi1.PhongKham.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bac_si")
@Entity
public class BacSi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tên không được để trống")
    @Column(name = "ten")
    private String ten;

    @NotNull(message = "Lương không được để trống")
    @Range(min = 0, max = 10, message = "Lương chỉ được trong khoảng 1 đến 10")
    @Column(name = "luong")
    private Integer luong;

    @NotNull(message = "Giới tính không được để trống")
    @Column(name = "gioi_tinh")
    private Boolean gioiTinh;

    @NotNull(message = "Vui lòng chọn phòng khám")
    @ManyToOne
    @JoinColumn(name = "id_phong_kham", referencedColumnName = "id")
    private PhongKham phongKham;
}
