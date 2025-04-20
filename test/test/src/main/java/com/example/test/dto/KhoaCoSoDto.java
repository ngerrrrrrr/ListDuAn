package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhoaCoSoDto {
    private Long id;
    private Integer trangThai;
    private Long ngayTao;
    private Long ngaySua;
    private String tenKhoa;
    private String tenCoSo;
    private String tenNhanVien;
}
