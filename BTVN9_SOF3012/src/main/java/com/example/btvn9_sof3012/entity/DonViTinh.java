package com.example.btvn9_sof3012.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "DonViTinh")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class DonViTinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDonViTinh")
    private Long id;

    @Column(name = "maDonViTinh")
    private String ma;
}
