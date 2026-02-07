package com.ht.management.ration.distribution.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "ration_card_number", unique = true)
    private String rationCardNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + "*****" + '\'' +
                ", role='" + role + '\'' +
                ", rationCardNumber='" + rationCardNumber + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + "*****" + '\'' +
                '}';
    }

}
