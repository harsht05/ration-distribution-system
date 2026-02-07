package com.ht.management.ration.distribution.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ration_request")
public class RationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "ration_shop_id", nullable = false)
    private Long rationShopId;

    @Column(name = "item", columnDefinition = "TEXT")
    private List item;

    @Column(name = "status", nullable = false)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "request_date")
    private Date requestDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "approval_date")
    private Date approvalDate;

    @Override
    public String toString() {
        return "RationRequest{" +
                "requestId=" + requestId +
                ", userId=" + userId +
                ", rationShopId=" + rationShopId +
                ", item=" + item +
                ", status='" + status + '\'' +
                ", requestDate='" + requestDate + '\'' +
                ", approvalDate='" + approvalDate + '\'' +
                '}';
    }
}
