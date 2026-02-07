package com.ht.management.ration.distribution.model;

import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inventory")
public class Inventory {
    @EmbeddedId
    private InventoryId id;

    @Column(name = "quantity_available")
    private Integer quantityAvailable;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated_date")
    private Date lastUpdatedDate;

    @Override
    public String toString() {
        return "Inventory{" +
                "rationShopId=" + (id != null ? id.getRationShopId() : null) +
                ", itemType='" + (id != null ? id.getItemType() : null) + '\'' +
                ", quantityAvailable=" + quantityAvailable +
                ", lastUpdatedDate=" + lastUpdatedDate +
                '}';
    }
}
