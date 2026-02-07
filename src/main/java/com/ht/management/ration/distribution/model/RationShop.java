package com.ht.management.ration.distribution.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ration_shop")
public class RationShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ration_shop_id")
    private Long rationShopId;

    @Column(name = "shop_name", nullable = false)
    private String shopName;

    @Column(name = "location")
    private String location;

    @Column(name = "license_number", unique = true, nullable = false)
    private String licenseNumber;

    @Override
    public String toString() {
        return "RationShop{" +
                "rationShopId=" + rationShopId +
                ", shopName='" + shopName + '\'' +
                ", location='" + location + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                '}';
    }
}
