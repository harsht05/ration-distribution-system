package com.ht.management.ration.distribution.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment_info")
public class PaymentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "transaction_id", unique = true)
    private String transactionId;

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus;

    @Override
    public String toString() {
        return "PaymentInfo{" +
                "paymentId=" + paymentId +
                ", userId=" + userId +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", transactionId='" + transactionId + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
